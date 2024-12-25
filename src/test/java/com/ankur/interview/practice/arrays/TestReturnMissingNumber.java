package com.ankur.interview.practice.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestReturnMissingNumber {
  @Test
  public void testMissingNumber() {
    int[] nums = new int[] {1, 4, 3};
    int[] expected = new int[] {2,5};
    int[] actual = ReturnMissingNumber.missingNumber(nums);
    Assertions.assertTrue(expected.length == actual.length);
    for (int i = 0; i < expected.length; i++) {
      Assertions.assertTrue(expected[i] == actual[i]);
    }
  }
}
