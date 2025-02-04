package com.ankur.interview.practice.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCheckWaitTime {

    @Test
    public void TestCase1() {
      int[] queries = new int[] {3, 2, 1, 2, 6};
      int expected = 17;
      var actual = CheckWaitTime.minimumWaitingTime(queries);
      Assertions.assertTrue(actual == expected);
    }
  }
