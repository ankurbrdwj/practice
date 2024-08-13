package com.ankur.interview.practice.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestStarcaseSteps {
  // This file is initialized with a code version of this
// question's sample test case. Feel free to add, edit,
// or remove test cases in this file as you see fit!

    @Test
    public void TestCase1() {
      int stairs = 4;
      int maxSteps = 2;
      int expected = 5;
      int actual = Staircase.findMaxSteps(stairs, maxSteps);
      Assertions.assertEquals(expected, actual);
    }
  }

