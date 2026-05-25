package com.ankur.interview.practice.arrays;

/*
 * Range Sum Query — Immutable (LeetCode 303) — Prefix Sum Array
 *
 * Precompute prefix sums so any range query [left, right] answers in O(1).
 * prefix[i] = sum of nums[0..i-1].
 * sumRange(l, r) = prefix[r+1] - prefix[l].
 *
 * Time  O(n) build,  O(1) per query
 * Space O(n)
 *
 * Example: nums=[-2,0,3,-5,2,-1]
 *   sumRange(0,2) → 1   (-2+0+3)
 *   sumRange(2,5) → -1  (3-5+2-1)
 */
public class RangeSumQuery {

    private final int[] prefix;

    public RangeSumQuery(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}