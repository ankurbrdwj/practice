package com.ankur.interview.practice.arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * Subarray Sum Equals K (LeetCode 560) — Prefix Sum + HashMap
 *
 * Count subarrays whose elements sum to k.
 *
 * A subarray nums[j..i] sums to k iff prefixSum[i] - prefixSum[j-1] == k,
 * i.e., prefixSum[j-1] == prefixSum[i] - k.
 *
 * As we build the running prefix sum, look up (sum - k) in a frequency map
 * of sums seen so far. Seed the map with {0: 1} to handle subarrays starting
 * at index 0.
 *
 * Time  O(n)
 * Space O(n)
 *
 * Example: nums=[1,1,1], k=2 → 2
 * Example: nums=[1,2,3], k=3 → 2  ([1,2] and [3])
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            count += prefixCount.getOrDefault(sum - k, 0);
            prefixCount.merge(sum, 1, Integer::sum);
        }
        return count;
    }
}