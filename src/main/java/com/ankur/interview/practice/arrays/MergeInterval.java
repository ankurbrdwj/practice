package com.ankur.interview.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

    public static int[][] mergeInterval(int[][] intervals) {
        int[][] sorted = intervals.clone();
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> mergedInterval = new ArrayList<>();
        int[] currentinterval = sorted[0];
        mergedInterval.add(currentinterval);
        for (int i = 1; i < sorted.length; i++) {
            int[] item = sorted[i];
            int currentEnd = currentinterval[1];
            int nextStart = item[0];
            int nextEnd = item[1];
            if (currentEnd >= nextStart) {
                currentinterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentinterval = item;
                mergedInterval.add(currentinterval);
            }
        }
        return mergedInterval.toArray(new int[mergedInterval.size()][]);
    }

    public static int[][] mergeIntervalStream(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.stream(intervals)
              .sorted(Comparator.comparingInt((int[] a) -> a[0]))
              .forEach(interval -> {
                  if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                      merged.add(interval);
                  } else {
                      merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
                  }
              });
        return merged.toArray(new int[merged.size()][]);
    }
}
