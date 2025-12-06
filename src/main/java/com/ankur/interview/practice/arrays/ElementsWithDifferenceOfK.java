package com.ankur.interview.practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class ElementsWithDifferenceOfK {
    static final long MOD = 1_000_000_007L;

    public static long countOfElementsWithDifferenceOfK(int[] arr, int k) {
        Map<Integer, Long> freq = new HashMap<>();

        // Step 1: Count frequencies
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0L) + 1);
        }

        long result = 0;

        // Step 2: Count valid pairs
        for (int x : freq.keySet()) {
            long countX = freq.get(x);

            if (k == 0) {
                // Count pairs (x, x)
                long c = countX;
                long pairs = (c * (c - 1) / 2) % MOD;
                result = (result + pairs) % MOD;
            } else {
                // Only count (x, x+k) to avoid double counting
                if (freq.containsKey(x + k)) {
                    long countY = freq.get(x + k);
                    long pairs = (countX * countY) % MOD;
                    result = (result + pairs) % MOD;
                }
            }
        }

        return result % MOD;
    }
}
