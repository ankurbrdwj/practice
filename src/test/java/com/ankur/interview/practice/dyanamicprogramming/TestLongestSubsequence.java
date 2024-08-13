package com.ankur.interview.practice.dyanamicprogramming;

import com.ankur.interview.practice.dynamicprogramming.LongestStringSubsequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestLongestSubsequence {
  // This file is initialized with a code version of this
// question's sample test case. Feel free to add, edit,
// or remove test cases in this file as you see fit!

    @Test
    public void TestCase1() {
      char[] expected = {'X', 'Y', 'Z', 'W'};
      Assertions.assertTrue(compare(LongestStringSubsequence.longestCommonSubsequence("ZXVVYZW", "XKYKZPW"), expected));
    }

    private static boolean compare(List<Character> arr1, char[] arr2) {
      if (arr1.size() != arr2.length) {
        return false;
      }
      for (int i = 0; i < arr1.size(); i++) {
        if (arr1.get(i) != arr2[i]) {
          return false;
        }
      }
      return true;
    }
  }
