package com.ankur.interview.practice.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSmallestDifference {
    @Test
    public void TestCase1() {
      int[] expected = {28, 26};
      Assertions.assertArrayEquals(SmallestDifference.smallestDifference(
        new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17}), expected);
    }
  }


