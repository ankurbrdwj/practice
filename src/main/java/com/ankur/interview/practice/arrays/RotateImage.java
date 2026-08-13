package com.ankur.interview.practice.arrays;

public class RotateImage {

    /*
     * PROBLEM: Rotate an n x n matrix 90 degrees clockwise, in-place.
     *
     * ─────────────────────────────────────────────────────────────────────
     * VISUAL EXAMPLE  (4 x 4)
     * ─────────────────────────────────────────────────────────────────────
     *
     *   Original          After 90° CW rotation
     *   ┌──────────────┐  ┌──────────────┐
     *   │  1   2   3  4│  │ 13   9   5  1│
     *   │  5   6   7  8│  │ 14  10   6  2│
     *   │  9  10  11 12│  │ 15  11   7  3│
     *   │ 13  14  15 16│  │ 16  12   8  4│
     *   └──────────────┘  └──────────────┘
     *
     *   Rule: element at [row][col]  →  moves to  [col][n-1-row]
     *
     * ─────────────────────────────────────────────────────────────────────
     * ALGORITHM  (two-pass, O(1) extra space)
     * ─────────────────────────────────────────────────────────────────────
     *
     *   STEP 1 ── TRANSPOSE  (flip across the main diagonal)
     *   Swap matrix[i][j]  ↔  matrix[j][i]  for every i < j
     *
     *   Original              After transpose
     *   ┌──────────────┐      ┌──────────────┐
     *   │  1   2   3  4│      │  1   5   9  13│
     *   │  5   6   7  8│  ──► │  2   6  10  14│
     *   │  9  10  11 12│      │  3   7  11  15│
     *   │ 13  14  15 16│      │  4   8  12  16│
     *   └──────────────┘      └──────────────┘
     *
     *   Think of it as reflecting every element over the diagonal ╲:
     *
     *        ╲  2  3  4          ╲  5  9  13
     *           ╲  7  8    ──►      ╲  10 14
     *              ╲ 12               ╲  15
     *                 ╲                  ╲
     *   (elements on the diagonal stay put)
     *
     * ─────────────────────────────────────────────────────────────────────
     *
     *   STEP 2 ── REVERSE EACH ROW  (left ↔ right)
     *
     *   After transpose        After reversing rows
     *   ┌──────────────┐       ┌──────────────┐
     *   │  1   5   9  13│      │ 13   9   5  1│
     *   │  2   6  10  14│  ──► │ 14  10   6  2│
     *   │  3   7  11  15│      │ 15  11   7  3│
     *   │  4   8  12  16│      │ 16  12   8  4│
     *   └──────────────┘       └──────────────┘
     *
     *   Row 0:  [1, 5, 9,13]  →  [13, 9, 5, 1]
     *   Row 1:  [2, 6,10,14]  →  [14,10, 6, 2]
     *   ...
     *
     *   Each row is reversed using two pointers (left, right) walking inward.
     *
     * ─────────────────────────────────────────────────────────────────────
     * WHY THIS WORKS
     * ─────────────────────────────────────────────────────────────────────
     *   Transpose sends (row, col) → (col, row).
     *   Reversing a row maps (col, row) → (col, n-1-row)  … wait, let's be
     *   precise:
     *     after transpose:  value originally at [r][c] is now at [c][r]
     *     after row-reverse: column index flips: [c][r] → [c][n-1-r]
     *   Combined:  original [r][c]  →  final [c][n-1-r]
     *   That is exactly the 90° CW mapping: new[c][n-1-r] = old[r][c]  ✓
     *
     * ─────────────────────────────────────────────────────────────────────
     * COMPLEXITY
     * ─────────────────────────────────────────────────────────────────────
     *   Time : O(n²)  — every cell is visited a constant number of times
     *   Space: O(1)   — only a single temp variable for swaps
     */

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose — swap across main diagonal
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}