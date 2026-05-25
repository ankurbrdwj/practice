package com.ankur.interview.practice.arrays;

/*
 * Maximum Product Subarray (LeetCode 152) — DP with min/max tracking
 *
 * Unlike max sum, a negative number can flip the sign and become the new max.
 * Track both the running max AND min product ending at each index.
 * When the current element is negative, swap max and min before extending.
 *
 * Time  O(n)
 * Space O(1)
 *
 * Example: [2,3,-2,4] → 6  (subarray [2,3])
 * Example: [-2,0,-1]  → 0
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = max; max = min; min = tmp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }
}