package com.ankur.interview.practice.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCountSquares {
    @Test
    public void TestCase1() {
      var input = new int[][] {
        new int[] {1, 1}, new int[] {0, 0}, new int[] {-4, 2},
        new int[] {-2, -1}, new int[] {0, 1}, new int[] {1, 0},
        new int[] {-1, 4}};
      var expected = 2;
      var actual = CountSquares.countSquares(input);
      Assertions.assertTrue(expected == actual);
    }
  }
