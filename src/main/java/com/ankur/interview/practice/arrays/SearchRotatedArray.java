package com.ankur.interview.practice.arrays;

/*
 * Search in Rotated Sorted Array (LeetCode 33) — Modified Binary Search
 *
 * Array was sorted then rotated at some unknown pivot.
 * At every midpoint, ONE of the two halves is always fully sorted.
 * Determine which half is sorted, check if target lies in it, then
 * discard the other half.
 *
 * Time  O(log n)
 * Space O(1)
 *
 * Example: [4,5,6,7,0,1,2], target=0 → index 4
 */
public class SearchRotatedArray {

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;

            if (nums[lo] <= nums[mid]) {
                // left half [lo..mid] is sorted
                if (nums[lo] <= target && target < nums[mid]) hi = mid - 1;
                else lo = mid + 1;
            } else {
                // right half [mid..hi] is sorted
                if (nums[mid] < target && target <= nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }

    // Variation: find minimum element (entry point of rotation)
    // Time O(log n)
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) lo = mid + 1; // min is in right half
            else hi = mid;                           // mid could be the min
        }
        return nums[lo];
    }
}