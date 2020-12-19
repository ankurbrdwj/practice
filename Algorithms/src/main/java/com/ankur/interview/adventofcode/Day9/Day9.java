package com.ankur.interview.adventofcode.Day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day9 {
    private static int part1 =0;
    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("src/main/java/com/ankur/interview/adventofcode/Day9/input.txt"));
        List<Long> data = new ArrayList<>();
        for (String s : input) data.add(Long.valueOf(s));
        solvePart1(data);
        solvePart2(data);
    }

    private static void solvePart1(List<Long> data) {
        int window = 25;
        long result = 0;
        for (int i = window; i < data.size(); i++) {
            List<Long> sortedList = new ArrayList<>(data.subList(i - window, i));
            Collections.sort(sortedList, Comparator.naturalOrder());
            result = twoNumSum(sortedList, data.get(i));
            if (result == 0) {
                System.out.println(i);
                part1 = i;
                System.out.println(data.get(i));
            }
        }
    }

    private static boolean contains(List<Long> data, int start, int end, long l) {
        long result = 0;
        for (int j = start; j < end; j++) {
            if (data.get(j) == l) {
                return true;
                //result = data.get(j);
                //break;
            }

        }
        return false;
    }

    private static void solvePart2(List<Long> data) {
        int l = part1 - 1;
        int r = part1;
        long sum = data.get(l) + data.get(r);
        long target = data.get(part1);
        while (true) {
            if (sum < target) {
                l--;
                sum += data.get(l);
            } else if (sum > target) {
                r--;
                sum -= data.get(r+1);
            } else {
                System.out.println(data.get(l) + data.get(r));
                List<Long> result = new ArrayList<>(data.subList(l,r+1));
                LongSummaryStatistics statistics=result.stream().mapToLong(i->i).summaryStatistics();
                System.out.println(statistics.getMin()+statistics.getMax());
                break;
            }

        }
    }

    private static long twoNumSum(List<Long> sortedList, long target) {
        Long result = 0L;
        int l = 0;
        int r = sortedList.size() - 1;
        while (l < r) {
            long left = sortedList.get(l);
            long right = sortedList.get(r);
            long sum = left + right;
            if (sum == target) {
                result = sum;
                return result;
            }
            if (sum < target) {
                l++;
            }
            if (sum > target) {
                r--;
            }
        }
        return result;
    }
}
