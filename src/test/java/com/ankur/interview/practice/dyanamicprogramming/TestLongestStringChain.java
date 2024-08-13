package com.ankur.interview.practice.dyanamicprogramming;

import com.ankur.interview.practice.dynamicprogramming.LongestStringChain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLongestStringChain {


    @Test
    public void TestCase1() {
      List<String> strings =
        new ArrayList<String>(
          Arrays.asList("abde", "abc", "abd", "abcde", "ade", "ae", "1abde", "abcdef"));
      List<String> expected =
        new ArrayList<String>(Arrays.asList("abcdef", "abcde", "abde", "ade", "ae"));
      Assertions.assertTrue(LongestStringChain.longestStringChain(strings).equals(expected));
    }
  }
