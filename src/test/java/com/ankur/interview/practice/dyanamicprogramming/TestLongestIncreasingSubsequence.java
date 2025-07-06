package com.ankur.interview.practice.dyanamicprogramming;

import com.ankur.interview.practice.dynamicprogramming.LongestIncreasingSubsequence;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLongestIncreasingSubsequence {
  @Test
  public void TestCase1() {
    int[] expected = {-24, 2, 3, 5, 6, 35};
    List<Integer> actual = LongestIncreasingSubsequence
      .listOfLIS(new int[] {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35});
    Assertions.assertTrue(compare(actual, expected));
  }
  @Test
  public void TestCase2() {
    int[] expected = {-24, 2, 3, 5, 6, 35};
    List<Integer> actual = LongestIncreasingSubsequence
      .listOfLISBS(new int[] {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35});
    Assertions.assertTrue(compare(actual, expected));
  }
  public static boolean compare(List<Integer> arr1, int[] arr2) {
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

