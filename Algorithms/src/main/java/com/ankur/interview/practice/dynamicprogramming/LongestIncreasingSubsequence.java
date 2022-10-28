package com.ankur.interview.practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
  public static int lengthOfLongestIncreasingSubsequence(int[] arr) {
    int[] dp = new int[arr.length];
    dp[0] = 1;
    int result =0;
      //int[][]  = new int[arr.length][arr.length];
      for (int i = 1; i < arr.length; i++) {
      int maxLength = 0;
      for (int j = 0; j < i; j++) {
        // if a[i] can be added to sequence
        if (arr[i] > arr[j]) {
          // from the ones which are less then a[i] get the max
          if (maxLength < dp[j]) {
            maxLength = dp[j];
          }
        }
      }
      // update the dp with whatever max from lessors was +1 value
      dp[i]= maxLength+1;
      if(dp[i]>result){
        result= dp[i];
      }
    }
    return result;
  }
  public static int longestIncreasingSubsequenceBinary(int[] arr) {
 return 0;
  }
  }
