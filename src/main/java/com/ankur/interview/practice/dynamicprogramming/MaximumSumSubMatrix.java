package com.ankur.interview.practice.dynamicprogramming;

public class MaximumSumSubMatrix {
  /*
  / given a matrix, find the maximum sum of any submatrix.given size s
  We will precompute all sums in bottom right in sums matrix
  then we will take size and remove
   */
  public static int maximumSumSubMatrix(int[][] matrix, int size) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int maxSum = Integer.MIN_VALUE;
    int rows = matrix.length;
    int cols = matrix[0].length;
    int[][] sums = fillSumsMatrix(matrix, size);
    // we will take 0 row and 0 columns first
    // we will take bottom righ ij to be the sum
    for (int row = size - 1; row < matrix.length; row++) {
      for (int col = size - 1; col < matrix[row].length; col++) {
        int total = sums[row][col];
        // we will take the sum of all elements in the submatrix
        boolean touchesTopBorder = (row - size < 0);
        if (!touchesTopBorder) {
          total = total - sums[row - size][col];
        }
        boolean touchesLeftBorder = (col - size < 0);
        if (!touchesLeftBorder) {
          total = total - sums[row][col - size];
        }
        boolean touchesTopOrLeftBorders = touchesTopBorder || touchesLeftBorder;
        if (!touchesTopOrLeftBorders) {
          total = total + sums[row - size][col - size];
        }
        maxSum = Math.max(maxSum, total);
      }
    }

    return maxSum;
  }

  private static int[][] fillSumsMatrix(int[][] matrix, int size) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int[][] sums = new int[rows][cols];
    // we will take 0 row and 0 columns first
    // we will take bottom righ ij to be the su
    sums[0][0] = matrix[0][0];
    // filll topBorder
    for (int col = 1; col < matrix[0].length; col++) {
      sums[0][col] = sums[0][col - 1] + matrix[0][col];
    }
    // fill the leftBorder
    for (int row = 1; row < matrix.length; row++) {
      sums[row][0] = sums[row - 1][0] + matrix[row][0];
    }
    // keep filling the bottomRight corner
    for (int row = 1; row < rows; row++) {
      for (int col = 1; col < cols; col++) {
        sums[row][col] = sums[row - 1][col] + sums[row][col - 1] - sums[row - 1][col - 1]
          + matrix[row][col];
      }
    }
    return sums;

  }
}
