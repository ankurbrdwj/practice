package com.ankur.interview.practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JuicePackaging {

  /*
  / given price per unit,
   package juice for max profit
   array of prices per unit prices[0,1,3,2,1]
   where index is the unit
              0 1 2 3 4
            0 0
            1 2
            2
            3
            4
   */

  public List<Integer> juiceBottlingDP(int[] prices) {
    List<Integer> list = new ArrayList<>();
    int[][] dp = new int[prices.length + 1][prices.length + 1];
    for (int i = 1; i < prices.length; i++) {
      for (int j = 0; j < prices.length; j++) {
        if (j >= i) {
          dp[i][j] = Math.max(dp[i - 1][j], prices[i] + dp[i][j - i]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    int i = prices.length-1, j = prices.length-1;
    while (i > 0 && j > 0) {
      if (i > j || dp[i][j] == dp[i - 1][j]) {
        i--;
      } else {
        list.add(i); // use unit i
        j -= i;
      }
    }

    // Sort to return ascending order
    Collections.sort(list);
    return list;
  }
}
