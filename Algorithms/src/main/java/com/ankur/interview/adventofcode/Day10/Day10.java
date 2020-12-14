package com.ankur.interview.adventofcode.Day10;

import com.ankur.interview.adventofcode.Day8.Accumulator;
import com.ankur.interview.adventofcode.Day8.Computer;
import com.ankur.interview.adventofcode.Day8.Instruction;
import com.ankur.interview.adventofcode.Day8.Jumper;
import com.ankur.interview.adventofcode.Day8.NoOperation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day10 {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        List<String> data = Files.readAllLines(Paths.get("src/main/java/com/ankur/interview/adventofcode/Day10/input.txt"));
        List<Integer> intList = data.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        solvePart1(intList);
        solvePart2(intList);
    }

    private static void solvePart1(List<Integer> intList) {
        IntSummaryStatistics summary = intList.stream().mapToInt(i -> i).summaryStatistics();
        int deviceJolt = summary.getMax() + 3;
        int outletJolt = 0;
        Collections.sort(intList, Comparator.naturalOrder());
        int diff1 = 0;
        int diff3 = 0;
        int lastSelected =0;
        for (int i = 0; i < intList.size(); i++) {
            if (intList.get(i) == lastSelected + 1) {
                diff1++;
                outletJolt += intList.get(i);
                lastSelected = intList.get(i);
            } else if (intList.get(i) == lastSelected + 2) {
                outletJolt += intList.get(i);
                lastSelected = intList.get(i);
            } else if (intList.get(i) == lastSelected + 3) {
                diff3++;
                outletJolt += intList.get(i);
                lastSelected = intList.get(i);
            } else {
                System.out.println("cannot be chained");
            }
        }
        System.out.println(deviceJolt);
        System.out.println(diff1);
        System.out.println(diff3);
        System.out.println(diff1+diff3);
        System.out.println(diff1*diff3);
        System.out.println(outletJolt);
    }

   /* public Integer getWithMinDiff(Integer effectiveRating, List<Integer> list) {

    }*/

    private static void solvePart2(List<Integer> intList) {

    }


}
