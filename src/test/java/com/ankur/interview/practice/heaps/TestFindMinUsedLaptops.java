package com.ankur.interview.practice.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFindMinUsedLaptops {
   @Test
    public void TestCase1() {
      int[][] times =
        new int[][] {{0, 2}, {1, 4}, {4, 6}, {0, 4}, {7, 8}, {9, 11}, {3, 10}};
      ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
      for (int[] time : times) {
        input.add(new ArrayList(Arrays.asList(time[0], time[1])));
      }
      int expected = 3;
      var actual = new FindMinUsedLaptops().laptopRentals(input);
      Assertions.assertTrue(expected == actual);
    }
  }

