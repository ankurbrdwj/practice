package com.ankur.interview.practice.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestKnightsIntersection {
    @Test
    public void TestCase1() {
      var knightA = new int[] {0, 0};
      var knightB = new int[] {2, 1};
      var expected = 1;
      var actual = KnightsIntersection.knightConnection(knightA, knightB);
      Assertions.assertTrue(expected == actual);
    }
  }
