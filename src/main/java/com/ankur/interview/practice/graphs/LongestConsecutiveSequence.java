package com.ankur.interview.practice.graphs;

import java.util.HashSet;
import java.util.Set;

/*
 * Longest Consecutive Sequence (LeetCode 128) — HashSet
 *
 * Add all numbers to a HashSet for O(1) lookup.
 * For each number n, only start counting if n-1 is NOT in the set
 * (meaning n is the start of a sequence). Then extend n+1, n+2, ... as far
 * as possible. This ensures each sequence is counted exactly once.
 *
 * Time  O(n)  — each element is visited at most twice (outer loop + inner while)
 * Space O(n)
 *
 * Example: [100,4,200,1,3,2] → 4  (sequence 1,2,3,4)
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int max = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int len = 1;
                while (set.contains(n + len)) len++;
                max = Math.max(max, len);
            }
        }
        return max;
    }
}