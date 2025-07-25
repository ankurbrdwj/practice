package com.ankur.interview.practice.popular;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestStableIntern {

    @Test
    public void TestCase1() {
      int[][] interns = {
        {0, 1, 2, 3},
        {2, 1, 3, 0},
        {0, 2, 3, 1},
        {3, 1, 0, 2}
      };

      int[][] teams = {
        {1, 3, 2, 0},
        {0, 1, 2, 3},
        {1, 2, 3, 0},
        {3, 0, 2, 1}
      };
      int[][] expected = {
        {0, 1},
        {1, 2},
        {2, 0},
        {3, 3}
      };
      var actual = StableIntern.stableInternships(interns, teams);
      Assertions.assertTrue(expected.length == actual.length);

      for (int[] match : expected) {
        boolean containsMatch = false;
        for (int[] actualMatch : actual) {
          if (actualMatch[0] == match[0] && actualMatch[1] == match[1]) {
            containsMatch = true;
          }
        }
        Assertions.assertTrue(containsMatch);
      }
    }
  }
