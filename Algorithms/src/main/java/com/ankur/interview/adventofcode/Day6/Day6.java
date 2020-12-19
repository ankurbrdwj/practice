package com.ankur.interview.adventofcode.Day6;

import com.ankur.interview.adventofcode.Day5.Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Day6 {
    public static void main(String[] args) throws IOException {
//		copy and paste the input data into a file and read from it
        System.out.println(System.getProperty("user.dir"));
        String data = Files.readString(Paths.get("src/main/java/com/ankur/interview/adventofcode/Day6/input.txt"));
        final String[] groups = data.split("\n\n");
        solvedPart1(groups);
        solvedPart2(groups);
    }

    private static void solvedPart2(String[] groups) {
        int total = 0;
        for(String group : groups) {
            final String[] persons = group.split("[^a-z]");
            group = String.join("", persons);
            final HashMap<Character, Integer> map = new HashMap<>();
            for (char c : group.toCharArray()) {
                map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
            }

            for (int count : map.values()) {
                total += count == persons.length ? 1 : 0;
            }
        }

        System.out.println(total);
    }

    private static void solvedPart1(String[] groups) {
        int total = 0;
        for(String group : groups) {
            group = group.replaceAll("[^a-z]", "");
            final HashSet<Character> set = new HashSet<>();
            for (char c : group.toCharArray()) {
                set.add(c);
            }

            total += set.size();
        }

        System.out.println(total);
    }

}
