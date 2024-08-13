package com.ankur.interview.practice.arrays;

public class ZeroSumSubArrays {
  public static boolean zeroSum(int[] nums) {
    int sum = 0;
    boolean result = false;
    for (int i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
    }
    result = sum == 0;
    return result;
  }
}
