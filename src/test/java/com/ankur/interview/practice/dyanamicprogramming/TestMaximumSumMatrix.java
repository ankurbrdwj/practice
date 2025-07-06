package com.ankur.interview.practice.dyanamicprogramming;

import com.ankur.interview.practice.dynamicprogramming.MaximumSumSubMatrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMaximumSumMatrix {

    @Test
    public void TestCase1() {
      int[][] matrix =
        new int[][] {{5, 3, -1, 5}, {-7, 3, 7, 4}, {12, 8, 0, 0}, {1, -8, -8, 2}};
      int size = 2;
      int expected = 18;
      var actual = MaximumSumSubMatrix.maximumSumSubMatrix(matrix, size);
      Assertions.assertTrue(expected == actual);
    }
  }
