package com.ankur.interview.practice.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSweetAndSalty {
  @Test
  void testCase1() {
    int[] dishes = new int[] {-3, -5, 1, 7};
    int target = 8;
    int[] expected = new int[] {-3, 7};
    int[] actual = SweetAndSalty.getSweetAndSalty(dishes, target);
    Assertions.assertTrue(actual.length == 2);
    Assertions.assertTrue(actual[0] == expected[0]);
    Assertions.assertTrue(actual[1] == expected[1]);
  }
}
