package com.ankur.interview.practice.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {

    // Algorithm: Bucket Sort
    //
    // Problem: given nums[] and k, return the k most frequent elements.
    //
    // *** The core insight ***
    //   Frequency becomes the array index.
    //   A number that appears f times is placed at bucket[f].
    //   Because frequency can never exceed n (that would mean one number fills the
    //   whole array), the highest-frequency element always lands at the rightmost
    //   occupied bucket — no comparisons needed, the array position IS the rank.
    //   Scanning right-to-left therefore gives us elements in descending frequency
    //   order for free, in O(n) instead of the O(n log n) a sort would cost.
    //
    // *** What happens when multiple numbers share the same frequency? ***
    //   bucket[f] is a List, not a single slot.
    //   All numbers with frequency f are appended to the same list at bucket[f].
    //   Example: nums = [1,1,2,2,3,3], k = 2
    //     freq map: {1:2, 2:2, 3:2}
    //     bucket[2] = [1, 2, 3]   ← all three share the same bucket (HashMap iteration order)
    //   When we scan and reach bucket[2] we drain it left-to-right until k is met.
    //   Order within a tie bucket is not guaranteed — that is the price of keeping O(n).
    //   (Using TreeSet would give ordering but costs O(n log n) for bucket inserts.)
    //
    // Approach:
    //   1. Count each number's frequency with a HashMap.
    //   2. Create n+1 buckets where bucket[f] holds all numbers that appear f times.
    //   3. Scan buckets right-to-left (highest index first), collecting elements
    //      until we have k results.
    //
    // Time:  O(n)  — one pass to count, one pass to build buckets, one pass to collect
    // Space: O(n)  — map + buckets together hold every element once
    //
    // --- Trace A: nums = [1,1,1,2,2,3], k = 2  (distinct frequencies) ---
    //
    // Step 1  freq map       {1:3, 2:2, 3:1}
    //
    // Step 2  buckets (n=6, size 7)
    //           index:  0    1    2    3    4    5    6
    //           value: null [3]  [2]  [1] null null null
    //                        ↑    ↑    ↑
    //                      f=1  f=2  f=3   ← frequency IS the index
    //                     (lowest)        (highest → rightmost)
    //
    // Step 3  scan right → left
    //           i=6  null  skip
    //           i=5  null  skip
    //           i=4  null  skip
    //           i=3  [1]   → result: [1]
    //           i=2  [2]   → result: [1,2]  ← idx==k, stop
    //
    // --- Trace B: nums = [1,1,2,2,3], k = 2  (tie at frequency 2) ---
    //
    // Step 1  freq map       {1:2, 2:2, 3:1}
    //
    // Step 2  buckets (n=5, size 6)
    //           index:  0    1      2      3    4    5
    //           value: null [3]  [1,2]  null null null
    //                        ↑     ↑
    //                       f=1   f=2 ← 1 and 2 share bucket[2] (HashMap iteration order)
    //
    // Step 3  scan right → left
    //           i=5  null  skip
    //           i=4  null  skip
    //           i=3  null  skip
    //           i=2  [1,2] → result: [1]  (take 1)
    //                      → result: [1,2] ← idx==k, stop
    //                        (3 is never reached; it lost the tie by sitting at i=1)
    //
    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: count frequencies
        // Java 8+: freq.merge(n, 1, Integer::sum)
        //   merge(key, value, remappingFn) — if key absent puts value,
        //   if key present applies remappingFn(oldVal, value) to get new value.
        //   Integer::sum is a method reference equivalent to (a, b) -> a + b.
        //
        // Pre-Java 8 equivalent — manual get + null check:
        //   Integer count = freq.get(n);
        //   freq.put(n, count == null ? 1 : count + 1);
        //
        // Both do the same thing: start count at 1, increment by 1 on each repeat.
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            Integer count = freq.get(n);
            freq.put(n, count == null ? 1 : count + 1);
        }

        // Step 2: bucket[f] = list of numbers with frequency f.
        // ArrayList.add() is O(1) amortised — preserves the overall O(n) guarantee.
        // Index represents frequency, so we need n+1 slots (frequency 0..n).
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int n : freq.keySet()) {
            int f = freq.get(n);
            if (buckets[f] == null) buckets[f] = new ArrayList<>();
            buckets[f].add(n);
        }

        // Step 3: scan from highest frequency down, pick until we have k elements.
        // This is the implicit sort — instead of comparing values we just walk the
        // bucket array from index n down to 1. Higher index = higher frequency = comes first.
        int[] result = new int[k];
        int idx = 0;
        for (int f = buckets.length - 1; f >= 1 && idx < k; f--) {
            if (buckets[f] == null) continue;
            for (int n : buckets[f]) {
                result[idx++] = n;
                if (idx == k) break;
            }
        }

        return result;
    }
}