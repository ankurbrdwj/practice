package com.ankur.interview.practice.dynamicprogramming;

public class DiceThrows {
  public static int countWays(int numDices,int numSides, int target) {
    // Create a table to store results of subproblems
    int[][] dp = new int[numDices + 1][target+1];
    dp[0][0] = 1; // Base case: There is one way to reach 0 (do nothing)

    // Fill the table in bottom-up manner
    for (int dice = 1; dice <= numDices; dice++) {
      for (int sum = 1; sum <= target; sum++) {
        int ans=0;
        for (int k = 1; k <=numSides; k++) {
          if(sum-k>=0){
            ans += dp[dice-1][sum - k];
          }
        }
        dp[dice][sum] = ans;
      }
    }

    return dp[numDices][target];
  }
}
