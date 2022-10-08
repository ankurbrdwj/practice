package com.ankur.interview.practice.dynamicprogramming;

public class MaxProfitWithKTransactions {
  public static int maxProfit(int[] prices, int k) {
    int[][] dp = new int[k + 1][prices.length];
    for (int i = 1; i < dp.length; i++) {
      int maxDiff = -prices[0];
      for (int j = 0; j < dp[0].length; j++) {
        dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
        maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
      }
    }
    return dp[k][prices.length-1];
  }

}
