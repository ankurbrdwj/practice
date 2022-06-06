package com.ankur.interview.adventofcode.Day10;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class TestDay10 {
    @Test
    public void testDay10_part2() throws IOException {
        com.ankur.interview.adventofcode.Day10.Day10 day10 = new com.ankur.interview.adventofcode.Day10.Day10();
        List<String> data = Files.readAllLines(Paths.get("src/test/java/com/ankur/interview/adventofcode/Day10/input10.txt"));
        List<Integer> intList = data.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        day10.solvePart2(intList);
       /* Collections.sort(intList, Comparator.naturalOrder());
        Node node = new Node();
        node.data = intList.get(0);
        int i =0;
        while(i<intList.size()-1){
            if(intList.get(i+1)-intList.get(i)<=3){
                node.left = new Node(intList.get(i));
            }
        }*/
    }
}
