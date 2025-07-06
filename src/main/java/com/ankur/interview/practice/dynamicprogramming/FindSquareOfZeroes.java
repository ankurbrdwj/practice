package com.ankur.interview.practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSquareOfZeroes {
  /*
  / Given a matrix of 0s and 1s, determine if there is a square of size 2x2 or larger
  / that consists entirely of 0s.
  / For example, the following matrix has a square of 0s:
   */
  public static boolean squareOfZeroes(List<List<Integer>> matrix) {
    // Write your code here.
    // there are roughle n^3 square in nXn matrix
    // need to build a cache with keys r1+r2+c1+c2 rows and cols string
    // helper mathod that checks if current square is square of 0s

    if (matrix == null || matrix.isEmpty()) {
      return false;
    }
    Map<String, Boolean> cache = new HashMap<>();
    int rows = matrix.size();
    int cols = matrix.get(0).size();
    return hasSquareOfZeroes(matrix, 0, 0, rows - 1, cols - 1, cache);
  }

  private static boolean hasSquareOfZeroes(List<List<Integer>> matrix, int r1, int c1, int r2,
                                           int c2,
                                           Map<String, Boolean> cache) {
    // Check if the square defined by (r1, c1) to (r2, c2) is valid
    if (r1 >= r2 || c1 >= c2) {
      return false;
    }
    String key = r1 + "_" + c1 + "_" + r2 + "_" + c2;
    if (cache.containsKey(key)) {
      return cache.get(key);
    }
    boolean result = isSquareOfZeroes(matrix, r1, c1, r2, c2)
      || hasSquareOfZeroes(matrix, r1 + 1, c1 + 1, r2 - 1, c2 - 1, cache)
      || hasSquareOfZeroes(matrix, r1, c1 + 1, r2 - 1, c2, cache)
      || hasSquareOfZeroes(matrix, r1 + 1, c1, r2, c2 - 1, cache)
      || hasSquareOfZeroes(matrix, r1 + 1, c1 + 1, r2, c2, cache)
      || hasSquareOfZeroes(matrix, r1, c1, r2 - 1, c2 - 1, cache);
    cache.put(key, result);
    return cache.get(key);
  }

  static boolean isSquareOfZeroes(List<List<Integer>> matrix, int r1, int c1, int r2, int c2) {
    // Check if the square defined by (r1, c1) to (r2, c2) is all 0s
    for (int row = r1; row <= r2; row++) {
      if (matrix.get(row).get(c1) != 0 || matrix.get(row).get(c2) != 0) {
        return false;
      }
    }
    for (int col = c1; col <= c2; col++) {
      if (matrix.get(r1).get(col) != 0 || matrix.get(r2).get(col) != 0) {
        return false;
      }
    }
    return true;
  }

  // We will try another approach where we can  try to find count of 0 on right of a 0 and count od 0 to bottom on a 0
  public static boolean squareOfZeroesBottomUp(List<List<Integer>> matrix) {
    List<List<MatrixInfo>> matrixInfo = preComputeMatrixInfo(matrix);
    int n = matrix.size();
    for (int topRow = 0; topRow < n; topRow++) {
      for (int leftCol = 0; leftCol < n; leftCol++) {
        int squareSize = 2;
        while (squareSize <= n - leftCol && squareSize <= n - topRow) {
          int rightCol = leftCol + squareSize - 1;
          int bottomRow = topRow + squareSize - 1;
          if (isSquareZero(matrixInfo, topRow, leftCol, bottomRow, rightCol)) {
            return true;
          }
          squareSize++;
        }
      }
    }
    return false;
  }

  private static List<List<MatrixInfo>> preComputeMatrixInfo(List<List<Integer>> matrix) {
    List<List<MatrixInfo>> matrixInfo = new ArrayList<>();
    for (int i = 0; i < matrix.size(); i++) {
      List<MatrixInfo> inner = new ArrayList<>();
      for (int j = 0; j < matrix.get(i).size(); j++) {
        int numZeroes = matrix.get(i).get(j) == 0 ? 1 : 0;
        inner.add(new MatrixInfo(numZeroes, numZeroes));
      }
      matrixInfo.add(inner);
    }
    int lastIndex = matrix.size() - 1;
    for (int i = lastIndex; i >= 0; i--) {
      for (int j = lastIndex; j >= 0; j--) {
        if (matrix.get(i).get(j) == 1) continue;
        if (i < lastIndex) {
          matrixInfo.get(i).get(j).countBottom += matrixInfo.get(i + 1).get(j).countBottom ;
        }
        if (j < lastIndex) {
          matrixInfo.get(i).get(j).countRight += matrixInfo.get(i).get(j + 1).countRight;
        }
      }
    }
    return matrixInfo;
  }

  private static boolean isSquareZero(List<List<MatrixInfo>> matrixInfo, int topRow, int leftCol,
                                      int bottomRow, int rightCol) {
    int squareLength = rightCol - leftCol + 1;
    boolean hasTopBorder = matrixInfo.get(topRow).get(leftCol).countRight >= squareLength;
    boolean hasLeftBorder = matrixInfo.get(topRow).get(leftCol).countBottom >= squareLength;
    boolean hasBottomBorder = matrixInfo.get(bottomRow).get(leftCol).countRight >= squareLength;
    boolean hasRightBorder = matrixInfo.get(topRow).get(rightCol).countBottom >= squareLength;
    return hasRightBorder && hasLeftBorder && hasTopBorder && hasBottomBorder;
  }


  static class MatrixInfo {
    private int countRight;
    private int countBottom;

    public MatrixInfo(int countRight, int countBottom) {
      this.countRight = countRight;
      this.countBottom = countBottom;
    }

  }
}

