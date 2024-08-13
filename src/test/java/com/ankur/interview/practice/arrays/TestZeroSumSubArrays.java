package com.ankur.interview.practice.arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestZeroSumSubArrays {
  @Test
  void testZeroSum(){
int [] nums = new int[]{-5,-5,2,3,-2};
    boolean result = ZeroSumSubArrays.zeroSum(nums);
    assertTrue(result);
  }
}
