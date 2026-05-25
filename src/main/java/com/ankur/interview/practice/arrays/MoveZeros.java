package com.ankur.interview.practice.arrays;

/*
 * Move Zeroes (LeetCode 283) — Two-Pointer
 *
 * Shift all non-zero elements to the front in their original relative order,
 * then fill remaining positions with zeros. Done in-place, no extra space.
 *
 * `insert` tracks next write position. Scan array once writing non-zeros,
 * then zero-fill from insert to end.
 *
 * Time  O(n)
 * Space O(1)
 *
 * Example: [0,1,0,3,12] → [1,3,12,0,0]
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int insert = 0;
        for (int n : nums) {
            if (n != 0) nums[insert++] = n;
        }
        while (insert < nums.length) {
            nums[insert++] = 0;
        }
    }
}