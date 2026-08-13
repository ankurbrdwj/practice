package com.ankur.interview.practice.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumDifferencePairs {

    public static List<List<Integer>> findMinDifferencePairs(List<Integer> latencies, int n) {
        List<Integer> sorted = new ArrayList<>(latencies.subList(0, n));
        Collections.sort(sorted);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, sorted.get(i) - sorted.get(i - 1));
        }

        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (sorted.get(i) - sorted.get(i - 1) == minDiff) {
                pairs.add(List.of(sorted.get(i - 1), sorted.get(i)));
            }
        }

        return pairs;
    }
}