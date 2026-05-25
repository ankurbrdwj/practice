package com.ankur.interview.practice.arrays;

/*
 * Maximum Average Subarray I (LeetCode 643) — Fixed Sliding Window
 *
 * Find a contiguous subarray of length k with the maximum average.
 * Maintain a running sum: add element entering the window, subtract element
 * leaving. Track the maximum sum seen; divide by k at the end.
 *
 * Time  O(n)
 * Space O(1)
 *
 * Example: nums=[1,12,-5,-6,50,3], k=4 → 12.75  (subarray [12,-5,-6,50])
 */
public class MaxAverageSubarray {

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        double max = sum;
        for (int i = k; i < nums.length; i++) {// window start = i-k , window end is i
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return max / k;
    }
}