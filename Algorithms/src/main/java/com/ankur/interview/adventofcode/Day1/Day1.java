package com.ankur.interview.adventofcode.Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day1 {
    public static void main(String[] args) throws IOException {
        List<String> data = Files.readAllLines(Paths.get("src/main/java/com/ankur/interview/adventofcode/Day1/input.txt"));
        solutionToPart1(data);
        solutionToPart2(data);
    }


    public static void solutionToPart1(List<String> data) {
        // this problem is similar to two sum from LeetCode
        // refer https://leetcode.com/problems/two-sum/ for hints and explanation
        int target = 2020;
        Set<Integer> set = new HashSet<Integer>();
        for (String s : data) {
            int num = Integer.parseInt(s);
            int toFind = target - num;
            if (set.contains(toFind)) {
                System.out.println(num * toFind);
                return;
            } else {
                set.add(num);
            }
        }
    }

    public static void solutionToPart2(List<String> data) {
        // this problem is similar to 3Sum from LeetCode
        // refer https://leetcode.com/problems/3sum/ for hints and explanation
        int target = 2020;
        for (int i = 0; i < data.size(); i++) {
            int fixed = Integer.parseInt(data.get(i));
            int currentTarget = target - fixed;
            Set<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < data.size(); j++) {
                if (j == i) continue;
                int num = Integer.parseInt(data.get(j));
                int toFind = currentTarget - num;
                if (set.contains(toFind)) {
                    System.out.println(num * toFind * fixed);
                    return;
                } else {
                    set.add(num);
                }
            }
        }
    }
}
