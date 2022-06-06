package com.ankur.interview.adventofcode.Day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
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
        int lastSelected = 0;
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
        System.out.println(diff1 + diff3);
        System.out.println(diff1 * diff3);
        System.out.println(outletJolt);
        System.out.println(getWithMinDiff(intList));
    }

    public static Integer getWithMinDiff(List<Integer> list) {
        int d1 = 0;
        int d3 = 1;
        for (int i = 0; i < list.size(); i++) {
            final int prev = i == 0 ? 0 : list.get(i - 1);
            final int d = list.get(i) - prev;
            if (d == 1) {
                d1++;
            } else if (d == 3) {
                d3++;
            }
        }
        System.out.println(d1);
        System.out.println(d3);
        System.out.println(d1 * d3);
        return d1 * d3;
    }

    public static void solvePart2(List<Integer> intList) {
        /*int count = 1;
        Collections.sort(intList,Comparator.naturalOrder());
        intList.add(0, 0);
        intList.add(intList.get(intList.size()-1)+3);
        for (int i = 0; i < intList.size()-2; i++) {
            int pick = intList.get(i);
            if(intList.get(i+2)- intList.get(i)<=3){
                count++;
            }
        }
        System.out.println(count);*/
        Collections.sort(intList, Comparator.naturalOrder());
        /*final long[] sums = new long[intList.get(intList.size() - 1) + 1];
        sums[0] = 1;
        for (int i = 0; i < intList.size(); i++) {
            final long x = intList.get(i) >= 3 ? sums[intList.get(i) - 3] : 0;
            final long y = intList.get(i) >= 2 ? sums[intList.get(i) - 2] : 0;
            final long z = intList.get(i) >= 1 ? sums[intList.get(i) - 1] : 0;
            sums[intList.get(i)] = x + y + z;
        }

        System.out.println(sums[sums.length - 1]);*/
        int i = 0;
        Long[] sums = new Long[intList.size()];
        long result = dp(i, intList, sums);
        System.out.println(result);
    }

    private static long dp(int i, List<Integer> list, Long[] sums) {
        if (sums[i] != null) {
            return sums[i];
        }
        if (i == list.size()-1) {
            return 1;
        }

        long total = 0;
        for (int k = i + 1; k < list.size(); k++) {
            if (list.get(k) - list.get(i) <= 3) {
                total = total + dp(k, list, sums);
            }
        }
       /* if (i + 1 < list.size() && list.get(i + 1) - list.get(i) <= 3) {
            total += dp(i + 1, list, sums);
        }
        if (i + 2 < list.size() && list.get(i + 2) - list.get(i) <= 3) {
            total += dp(i + 2, list, sums);
        }
        if (i + 3 < list.size() && list.get(i + 3) - list.get(i) <= 3) {
            total += dp(i + 3, list, sums);
        }*/
        System.out.println(total);
        sums[i] = total;
        return total;
    }


    static class TripleTree {
        int left;
        int middle;
        int right;
        TripleTree tripleTree;

        public TripleTree() {
        }

        public TripleTree(int left, int middle, int right, TripleTree tripleTree) {
            this.left = left;
            this.middle = middle;
            this.right = right;
            this.tripleTree = tripleTree;
        }
    }
}
