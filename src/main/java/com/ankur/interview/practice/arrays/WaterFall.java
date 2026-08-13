package com.ankur.interview.practice.arrays;

import java.util.Arrays;

// ═══════════════════════════════════════════════════════════════════════════
// PROBLEM — Waterfall Streams
// ═══════════════════════════════════════════════════════════════════════════
//
// You are given a 2-D grid and a source column at the top row.
// 100% of water is dropped at that column and flows downward under rules:
//
//   • If the cell directly below is OPEN (0): water falls straight down.
//   • If the cell directly below is a BLOCK (1): water splits 50 / 50 and
//     spreads LEFT and RIGHT along the current row until each half either:
//       – finds a cell with no block ABOVE it AND no block IN the current
//         row → falls down there, or
//       – hits a block in the row above (wall) → that half is lost/trapped.
//
// Return an array of percentages representing how much water lands in each
// column of the BOTTOM row.
//
// ── GRID ENCODING ────────────────────────────────────────────────────────
//   0.0  → open cell          1.0  → solid block
//
// ── INTERNAL WATER ENCODING (negative numbers carry water) ───────────────
//   Water is stored as negative fractions so it doesn't conflict with 1.0.
//     -1.0  = 100% of the stream      -0.5  = 50%      -0.25 = 25%
//   At the end each negative value is converted: percentage = value × -100
//
// ── EXAMPLE  source = col 3 ──────────────────────────────────────────────
//
//   col →    0    1    2    3    4    5    6
//   row 0  [ 0 ][ 0 ][ 0 ][ S ][ 0 ][ 0 ][ 0 ]   S = source, -1 (100%)
//   row 1  [ 1 ][ 0 ][ 0 ][ 0 ][ 0 ][ 0 ][ 0 ]   water falls to col 3
//   row 2  [ 0 ][ 0 ][ # ][ # ][ # ][ 0 ][ 0 ]   BLOCK below → split 50/50
//                                                    left  50% → col 1
//                                                    right 50% → col 5
//   row 3  [ 0 ][ 0 ][ 0 ][ 0 ][ 0 ][ 0 ][ 0 ]   both halves fall straight
//   row 4  [ # ][ # ][ # ][ 0 ][ 0 ][ # ][ 0 ]   col 1 hits block → split
//                                                    left  trapped (wall)
//                                                    right 25% → col 3
//                                                  col 5 hits block → split
//                                                    left  25% → col 4
//                                                    right 25% → col 6
//   row 5  [ 0 ][ 0 ][ 0 ][ 0 ][ 0 ][ 0 ][ # ]   col 6 hits block → split
//                                                    both sides trapped → lost
//   row 6  [ 0 ][ 0 ][ 0 ][ 0 ][ 0 ][ 0 ][ 0 ]   col 3 and col 4 land
//
//   result = [ 0, 0, 0, 25, 25, 0, 0 ]   (total = 50%; 50% was lost to traps)
//
// ═══════════════════════════════════════════════════════════════════════════
public class WaterFall {

    public static double[] getWaterPercentages(double[][] array, int source) {

        // Mark the source cell with -1 (100% water) in the top row.
        double[] prevRow = array[0];
        prevRow[source] = -1;

        // Process the grid row by row, carrying water downward.
        for (int j = 1; j < array.length; j++) {
            double[] currRow = array[j];
            for (int k = 0; k < prevRow.length; k++) {
                double valueAbove = prevRow[k];

                // Negative value in the row above means water is present there.
                boolean hasWaterAbove = valueAbove < 0;

                // 1.0 in the current row means this cell is a solid block.
                boolean hasBlock = currRow[k] == 1.0;

                // No water above this column — nothing to do.
                if (!hasWaterAbove)
                    continue;

                // Open cell below: water falls straight down, accumulate it.
                if (!hasBlock) {
                    currRow[k] += valueAbove;
                    continue;
                }

                // Block below: split water evenly and spread each half sideways.
                double splitWater = valueAbove / 2;

                // Spread the RIGHT half: slide right until we can fall or get trapped.
                // Trapped = hit a block in prevRow (wall blocks the slide path).
                int rightIdx = k;
                while (rightIdx + 1 < prevRow.length) {
                    rightIdx += 1;
                    if (prevRow[rightIdx] == 1.0) { // wall above this cell — trapped
                        break;
                    }
                    if (currRow[rightIdx] != 1) {   // open cell below — water falls here
                        currRow[rightIdx] += splitWater;
                        break;
                    }
                    // currRow[rightIdx] == 1 (block) but no wall above — keep sliding right
                }

                // Spread the LEFT half: mirror logic going left.
                int leftIdx = k;
                while (leftIdx - 1 >= 0) {
                    leftIdx -= 1;
                    if (prevRow[leftIdx] == 1.0) {  // wall above — trapped
                        break;
                    }
                    if (currRow[leftIdx] != 1) {    // open cell below — water falls here
                        currRow[leftIdx] += splitWater;
                        break;
                    }
                }
            }
            // Move down one row: what was current becomes the new "above".
            prevRow = currRow;
        }

        // Convert the bottom row's negative fractions to positive percentages.
        // e.g. -0.25 → 25%    0 stays 0 (no water reached that column).
        double[] finalPercent = new double[prevRow.length];
        for (int i = 0; i < prevRow.length; i++) {
            double num = prevRow[i];
            if (num == 0) {
                finalPercent[i] = num;
            } else {
                finalPercent[i] = num * -100;
            }
        }
        return finalPercent;
    }

    public static void main(String[] args) {
        double [][] a= {
                {0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0},
                {0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0},
                {1,1,1,0,0,1,0},
                {0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0}
        };
       double[] result =  getWaterPercentages(a,3);
        Arrays.stream(result)
                .forEach(System.out::println);
    }
}
