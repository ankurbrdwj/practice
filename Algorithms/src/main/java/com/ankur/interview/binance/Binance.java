package com.ankur.interview.binance;

import java.util.HashMap;
import java.util.Map;

public class Binance {
  public static int sumDivisibleByThree(int[] nums, int k) {
    int dp[][] = new int[3][nums.length];
    dp[nums[0]%3][0] = nums[0];

    for(int i=1;i<nums.length;i++)
    {
      int index1 = (nums[i] + dp[0][i-1])%3;
      int index2 = (nums[i] + dp[1][i-1])%3;
      int index3 = (nums[i] + dp[2][i-1])%3;

      dp[index1][i] = Math.max(dp[index1][i],dp[0][i-1] + nums[i]);
      dp[index2][i] = Math.max(dp[index2][i],dp[1][i-1] + nums[i]);
      dp[index3][i] = Math.max(dp[index3][i],dp[2][i-1] + nums[i]);

      dp[0][i] = Math.max(dp[0][i-1],dp[0][i]);
      dp[1][i] = Math.max(dp[1][i-1],dp[1][i]);
      dp[2][i] = Math.max(dp[2][i-1],dp[2][i]);
    }
    return dp[0][nums.length-1];
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3, 4, 4};
// 14 ,
// from all possible sums which one is divible by 3 and is maximum
// n number of sums by skipping one element at a  time
    // fir you skip n-1 element then skip n-2 elements
    // 3 , 6 , 9 --> sums which are multiples of 3
    // 5+1, 7+2 , 8+1 not % 3==0 if i dont add them


// if sum not %3
    System.out.println(sumDivisibleByThree(arr, 3));
  }
}
