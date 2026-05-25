package com.ankur.interview.practice.arrays;

/*
 * Find Pivot Index (LeetCode 724) — Prefix Sum
 *
 * Find the leftmost index where sum of elements to the left equals sum to the right.
 * The pivot element itself is not included in either sum.
 *
 * Compute total sum once. Scan left→right maintaining a running left sum.
 * At index i: rightSum = total - leftSum - nums[i].
 * Pivot when leftSum == rightSum.
 *
 * Time  O(n)
 * Space O(1)
 *
 * Example: [1,7,3,6,5,6] → 3  (left=[1,7,3]=11, right=[5,6]=11)
 * Example: [1,2,3]        → -1
 */
public class PivotIndex {

    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int n : nums) total += n;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left == total - left - nums[i]) return i;
            left += nums[i];
        }
        return -1;
    }
}