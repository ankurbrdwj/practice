package com.ankur.interview.practice.arrays;

/*
 * Container With Most Water (LeetCode 11) — Two-Pointer
 *
 * Given heights[] representing vertical lines, find two lines that together
 * with the x-axis form a container holding the most water.
 *
 * Key insight: area = min(h[l], h[r]) * (r - l).
 * Always move the pointer with the SHORTER line inward — moving the taller
 * one can only decrease the width without increasing the limiting height.
 *
 * Time  O(n)   — single pass
 * Space O(1)
 */
public class ContainWater {

    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1, max = 0;
        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            max = Math.max(max, area);
            if (heights[left] < heights[right]) left++;
            else right--;
        }
        return max;
    }
}