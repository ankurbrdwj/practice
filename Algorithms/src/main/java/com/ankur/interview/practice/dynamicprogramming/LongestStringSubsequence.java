package com.ankur.interview.practice.dynamicprogramming;

import com.jogamp.common.util.ArrayHashSet;

import java.util.ArrayList;
import java.util.List;

public class LongestStringSubsequence {
  public static List<Character> longestCommonSubsequence(String str1, String str2) {
    int[][] dp = new int[str2.length() + 1][str1.length() + 1];
    for (int i = 1; i < str2.length() + 1; i++) {
      for (int j = 1; j < str1.length() + 1; j++) {
        if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return buildSequence(dp, str1);
  }

  private static List<Character> buildSequence(int[][] dp, String str1) {
    List<Character> seq = new ArrayList<>();
    int i = dp.length - 1;
    int j = dp[0].length - 1;
    while (i != 0 && j != 0) {
      if (dp[i][j] == dp[i - 1][j]) {
        i--;
      } else if (dp[i][j] == dp[i][j - 1]) {
        j--;
      } else {
        seq.add(0, str1.charAt(j - 1));
        i--;
        j--;
      }
    }
    return seq;
  }
}
