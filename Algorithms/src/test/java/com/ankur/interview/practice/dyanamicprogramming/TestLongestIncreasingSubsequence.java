package com.ankur.interview.practice.dyanamicprogramming;

import com.ankur.interview.practice.dynamicprogramming.LongestIncreasingSubsequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLongestIncreasingSubsequence {
  @Test
  public void testLongest(){
    int[] arr = new int[] {10,9,2,5,3,7,101,18};
    int result = LongestIncreasingSubsequence.lengthOfLongestIncreasingSubsequence(arr);
    Assertions.assertEquals(4,result);
  }
}
