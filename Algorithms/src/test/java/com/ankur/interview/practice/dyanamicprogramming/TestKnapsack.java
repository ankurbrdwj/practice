package com.ankur.interview.practice.dyanamicprogramming;

import com.ankur.interview.practice.dynamicprogramming.Knapsack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestKnapsack {
    @Test
    public void TestCase1() {
      int[][] input = {{1, 2}, {4, 3}, {5, 6}, {6, 7}};
      int[][] expected = {{10}, {1, 3}};
      Assertions.assertTrue(compare(Knapsack.knapsackProblem(input, 10), expected));
    }

    private static boolean compare(List<List<Integer>> arr1, int[][] arr2) {
      if (arr1.get(0).get(0) != arr2[0][0]) {
        return false;
      }
      if (arr1.get(1).size() != arr2[1].length) {
        return false;
      }
      for (int i = 0; i < arr1.get(1).size(); i++) {
        if (arr1.get(1).get(i) != arr2[1][i]) {
          return false;
        }
      }
      return true;
    }
  }

