package com.ankur.interview.adventofcode.Day8;

import com.ankur.interview.adventofcode.Day7.Day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day8 {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        List<String> data = Files.readAllLines(Paths.get("src/main/java/com/ankur/interview/adventofcode/Day8/input.txt"));
        Instruction[] instructions = new Instruction[data.size()];
        for (int i = 0; i < data.size(); i++) {
            int value = Integer.parseInt(data.get(i).split(" ")[1]);
            String type = data.get(i).split(" ")[0];
            switch (type) {
                case "acc":
                    instructions[i] = new Accumulator(type, value);
                    break;
                case "nop":
                    instructions[i] = new NoOperation(type, value);
                    break;
                case "jmp":
                    instructions[i] = new Jumper(type, value);
                    break;
            }
        }
        Computer computer = new Computer(instructions);
        solvePart1(computer);
        solvePart2(computer);
    }

    private static void solvePart2(Computer computer) {
        for (int i = 0; i < computer.instructions.length; i++) {
            final Instruction original = computer.instructions[i];
            if (original instanceof Jumper) {
                computer.instructions[i] = new NoOperation("nop",0);
            } else if (original instanceof NoOperation) {
                computer.instructions[i] = new Jumper("jmp",original.value);
            } else {
                continue;
            }

            final HashSet<Instruction> history = new HashSet<>();
            while (computer.execute()) {
                if (computer.position >= computer.instructions.length) {
                    System.out.println(computer.accumulator);
                    return;
                }

                final Instruction instruction = computer.instructions[computer.position];
                if (history.contains(instruction)) {
                    break;
                }

                history.add(instruction);
            }

            computer.instructions[i] = original;
            computer.reset();
        }
    }

    private static void solvePart1(Computer computer) {
        Set<Instruction> set = new HashSet<>();
        while(computer.execute()){
            Instruction instruction = computer.instructions[computer.position];
            if(set.contains(instruction)){
                System.out.println(computer.accumulator);
                return;
            }
            set.add(instruction);

        }
    }
}
