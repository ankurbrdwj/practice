package com.ankur.interview.practice.arrays;

import java.util.HashSet;

public class ZeroSumSubArrays {
  public static boolean zeroSum(int[] nums) {
    int sumTillNow = 0;
    HashSet<Integer> set =new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      sumTillNow = sumTillNow + nums[i];
      if(set.contains(sumTillNow))
        return true;
      set.add(sumTillNow);
    }
    return false;
  }
}
