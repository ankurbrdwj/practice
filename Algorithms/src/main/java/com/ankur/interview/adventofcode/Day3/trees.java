package com.ankur.interview.adventofcode.Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class trees {

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        List<String> data = Files.readAllLines(Paths.get("src/main/java/com/ankur/interview/adventofcode/Day3/input.txt"));
        solutionToPart1(data);
        solutionToPart2(data);
    }

    private static void solutionToPart2(List<String> data) {
        int x = data.get(0).length();
//		store the slopes in an array
        int[] xArray = {1, 3, 5, 7, 1};
        int[] yArray = {1, 1, 1, 1, 2};
//		long type because the product may exceed int capacity
        long product = 1;
//		for each slope
        for (int i = 0; i < xArray.length; i++) {
            int X = xArray[i];
            int xInc = xArray[i];
            int Y = yArray[i];
            int yInc = yArray[i];
            int treeCount = 0;
            while (Y < data.size()) {
                X %= x; //wrapping x value if exceeds limit
                String row = data.get(Y);
                char c = row.charAt(X);
                if (c == '#') treeCount++;

                X += xInc;
                Y += yInc;
            }
            product *= treeCount;
        }
        System.out.println(product);
    }

    private static void solutionToPart1(List<String> data) {
        int x = data.get(0).length();
//		slope value or start value
        int X = 3;
        int Y = 1;
        int treeCount = 0;
//		iterate till the end of the forest
        while (Y < data.size()) {
            X %= x; //wrapping x value if exceeds limit
            String row = data.get(Y);
            char c = row.charAt(X);
            if (c == '#') treeCount++;

            X += 3;
            Y += 1;
        }
        System.out.println(treeCount);
    }

    public static boolean getFreq(String input, char c, int min, int max) {
        char[] a = input.toCharArray();
        int[] freq = new int[26];
        for (int i = 0; i < a.length; i++) {
            freq[a[i] - 'a']++;
        }
        int index = c - 'a';
        if (freq[index] > min && freq[index] <= max)
            return true;
        else
            return false;
    }
}
