package com.ankur.interview.practice.dyanamicprogramming;

import com.ankur.interview.practice.dynamicprogramming.PalindromePartitionMinCut;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPalindromePartitions {
   @Test
    public void TestCase1() {
      Assertions.assertTrue(
        PalindromePartitionMinCut.minCut("noonabbad") == 2);
    }
  @Test
  public void TestCase2() {
    Assertions.assertTrue(
      PalindromePartitionMinCut.palindromeMinCut("noonabbad") == 2);
  }
  }

