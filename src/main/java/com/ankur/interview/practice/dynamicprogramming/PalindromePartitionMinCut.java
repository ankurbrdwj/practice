package com.ankur.interview.practice.dynamicprogramming;

import java.util.Arrays;

public class PalindromePartitionMinCut {
  /*
  / minimum cuts required to partition a string into palindromes
   */
  public static int minCut(String s) {
    int n = s.length();
    if (n == 0) {
      return 0;
    }
    boolean[][] isPalindrome = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        isPalindrome[i][j] = isPalindrome(s.substring(i, j + 1));
      }
    }

    int[] cuts = new int[n];
    Arrays.fill(cuts, Integer.MAX_VALUE);
    for (int i = 0; i < n; i++) {
      if (isPalindrome[0][i]) {// max cuts
        cuts[i] = 0; // if the whole substring is a palindrome, no cuts needed
      } else {
        cuts[i] = cuts[i - 1] + 1; // if not a palindrome, we need at least one cut
        for (int k = 1; k < i; k++) {
          if (isPalindrome[k][i] && cuts[k - 1] + 1 < cuts[i]) { // checking all  solutions before i
            cuts[i] = cuts[k - 1] + 1; // update cuts if we find a better partition
          }
        }
      }
    }
    return cuts[n - 1];
  }

  private static boolean isPalindrome(String substring) {
    int left = 0;
    int right = substring.length() - 1;
    while (left < right) {
      if (substring.charAt(left) != substring.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  public static int palindromeMinCut(String s) {
    int n = s.length();
    if (n == 0) {
      return 0;
    }
    boolean[][] isPalindrome = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        if (i == j) {
          isPalindrome[i][j] = true;
        } else {
          isPalindrome[i][j] = false;
        }
      }
    }
    for (int length = 2; length <= n; length++) {
      for (int i = 0; i <= n - length; i++) {
        int j = i + length - 1;
        if (length == 2) {
          isPalindrome[i][j] = s.charAt(i) == s.charAt(j);
        } else {
          isPalindrome[i][j] = (s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]);
        }
      }
    }
    int[] cuts = new int[n];
    Arrays.fill(cuts, Integer.MAX_VALUE);
    for (int i = 0; i < n; i++) {
      if (isPalindrome[0][i]) {// max cuts
        cuts[i] = 0; // if the whole substring is a palindrome, no cuts needed
      } else {
        cuts[i] = cuts[i - 1] + 1; // if not a palindrome, we need at least one cut
        for (int k = 1; k < i; k++) {
          if (isPalindrome[k][i] &&
            cuts[k - 1] + 1 < cuts[i]) { // checking all  solutions before i
            cuts[i] = cuts[k - 1] + 1; // update cuts if we find a better partition
          }
        }
      }
    }
    return cuts[n - 1];
  }
}

