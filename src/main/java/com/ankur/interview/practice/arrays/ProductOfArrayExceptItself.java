package com.ankur.interview.practice.arrays;

/*
 * Product of Array Except Self (LeetCode 238) — Prefix/Suffix Product
 *
 * result[i] = product of every element except nums[i], without division.
 *
 * Pass 1 (left→right): result[i] = product of all elements to the LEFT of i.
 * Pass 2 (right→left): multiply result[i] by product of all elements to the RIGHT.
 *
 * Time  O(n)
 * Space O(1) extra (output array doesn't count)
 *
 * Example: [1,2,3,4] → [24,12,8,6]
 */
public class ProductOfArrayExceptItself {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
}