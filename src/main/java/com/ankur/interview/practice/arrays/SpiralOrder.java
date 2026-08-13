package com.ankur.interview.practice.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    /*
     * PROBLEM: Given an m x n matrix, return all elements in spiral order.
     *
     * ─────────────────────────────────────────────────────────────────────
     * VISUAL EXAMPLE  (3 x 4)
     * ─────────────────────────────────────────────────────────────────────
     *
     *   ┌───────────────┐
     *   │  1   2   3   4│   → → → ↓
     *   │  5   6   7   8│           ↓
     *   │  9  10  11  12│   ← ← ← ←
     *   └───────────────┘
     *
     *   Spiral output: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
     *
     * ─────────────────────────────────────────────────────────────────────
     * IDEA: 4 MOVING BOUNDARIES
     * ─────────────────────────────────────────────────────────────────────
     *
     *   Maintain four walls that close inward after each pass:
     *
     *       left=0                right=3
     *         │                    │
     *   top=0 ┌────────────────────┐
     *         │  1   2   3   4     │
     *         │  5   6   7   8     │
     *  bot=2  └────────────────────┘
     *
     *   Four moves per "ring":
     *
     *   1. LEFT → RIGHT  along `top`  row          (top++)
     *   2. TOP  → BOTTOM along `right` column      (right--)
     *   3. RIGHT→ LEFT   along `bottom` row         (bottom--)   [if top <= bottom]
     *   4. BOTTOM→ TOP   along `left`  column       (left++)     [if left <= right]
     *
     * ─────────────────────────────────────────────────────────────────────
     * STEP-BY-STEP  (3 x 4 matrix)
     * ─────────────────────────────────────────────────────────────────────
     *
     *   Initial boundaries:  top=0, bot=2, left=0, right=3
     *
     *   Pass 1:
     *   ┌──────────────────────────┐
     *   │ [1]→[2]→[3]→[4]         │  ← move 1 (top row):   1,2,3,4   top → 1
     *   │              ↓[8]        │  ← move 2 (right col): 8,12      right → 2
     *   │       [12]←[11]←[10]←[9]│  ← move 3 (bot row):  12,11,10,9 bot → 1
     *   └──────────────────────────┘
     *   [5]↑                         ← move 4 (left col):  5         left → 1
     *
     *   After pass 1: top=1, bot=1, left=1, right=2
     *   Remaining inner matrix:
     *   ┌─────────┐
     *   │ [6]→[7] │  ← move 1: 6,7   top → 2  (top > bot now, stop)
     *   └─────────┘
     *
     *   Final: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
     *
     * ─────────────────────────────────────────────────────────────────────
     * GUARD CONDITIONS
     * ─────────────────────────────────────────────────────────────────────
     *
     *   After move 1 (top++), top may now exceed bot — if so, the bottom
     *   row pass would re-visit already-collected cells, so we skip it.
     *
     *        [ 1  2  3 ]     After move 1: top=1, bot=0  → top > bot
     *                        Skip move 3 and move 4 — no rows left.
     *
     *   Similarly after move 2 (right--), right may go below left — skip move 4.
     *
     * ─────────────────────────────────────────────────────────────────────
     * COMPLEXITY
     * ─────────────────────────────────────────────────────────────────────
     *   Time : O(m * n)  — every element visited exactly once
     *   Space: O(1)      — output list aside, no extra space used
     */

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // Move 1: left → right along top row
            for (int col = left; col <= right; col++)
                result.add(matrix[top][col]);
            top++;

            // Move 2: top → bottom along right column
            for (int row = top; row <= bottom; row++)
                result.add(matrix[row][right]);
            right--;

            // Move 3: right → left along bottom row (guard: row still exists)
            if (top <= bottom) {
                for (int col = right; col >= left; col--)
                    result.add(matrix[bottom][col]);
                bottom--;
            }

            // Move 4: bottom → top along left column (guard: column still exists)
            if (left <= right) {
                for (int row = bottom; row >= top; row--)
                    result.add(matrix[row][left]);
                left++;
            }
        }

        return result;
    }
}