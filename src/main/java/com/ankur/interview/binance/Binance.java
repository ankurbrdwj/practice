package com.ankur.interview.binance;

import java.util.HashMap;
import java.util.Map;

public class Binance {
  /* Leetcode 1262
  / int integer array find maximum sum divisible by 3 .
  take remainders in y axis and array on x create tabulation
  0th row will have all sums divisible by k where k=3 here
  dp[0][n-1] will have last sum divisible by k =3
 array ->   3 6 5  1  8
 rem  -> 0  3 9 9  15 18
         1  0 0 0  10 22
         2  0 0 14 14 23
  here dp[0][n-1] = 18 is answer
  dp[sum%3][j] = Math.max(sum,dp[sum%k][j])
  dp[i][j] = Math.max(dp[i][j-1],dp[i][j])
   */
  public static int sumDivisibleByThree(int[] nums, int k) {
    int dp[][] = new int[k][nums.length];
    dp[nums[0] % 3][0] = nums[0];
    for (int column = 1; column < nums.length; column++) {
      for (int row = 0; row < k; row++) {
        int sum = dp[row][column - 1] + nums[column]; // keep adding
        int rowIndex = (sum) % 3; // which row the above sum will go
        dp[rowIndex][column] = Math.max(dp[rowIndex][column], sum);
        dp[row][column] = Math.max(dp[row][column - 1], dp[row][column]);
      }

//      int index0 = (nums[i] + dp[0][i - 1]) % 3;
//      int index1 = (nums[i] + dp[1][i - 1]) % 3;
//      int index2 = (nums[i] + dp[2][i - 1]) % 3;
//
//      dp[index0][i] = Math.max(dp[index0][i], dp[0][i - 1] + nums[i]);
//      dp[index1][i] = Math.max(dp[index1][i], dp[1][i - 1] + nums[i]);
//      dp[index2][i] = Math.max(dp[index2][i], dp[2][i - 1] + nums[i]);
//
//      dp[0][i] = Math.max(dp[0][i - 1], dp[0][i]);
//      dp[1][i] = Math.max(dp[1][i - 1], dp[1][i]);
//      dp[2][i] = Math.max(dp[2][i - 1], dp[2][i]);
    }
    return dp[0][nums.length - 1];
  }

  public static void main(String[] args) {
    int[] arr = new int[]{3, 6, 5, 1, 8};

    System.out.println(sumDivisibleByThree(arr, 3));
  }
}
