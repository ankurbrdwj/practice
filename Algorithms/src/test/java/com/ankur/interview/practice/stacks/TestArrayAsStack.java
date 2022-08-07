package com.ankur.interview.practice.stacks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArrayAsStack {

    @Test
    public void TestCase1() {
      ArrayList<Integer> stack = new ArrayList<Integer>(Arrays.asList(-5, 2, -2, 4, 3, 1));
      ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(-5, -2, 1, 2, 3, 4));
      var actual = new ArrayAsStack().sortRecursively(stack);
      Assertions.assertTrue(expected.equals(actual));
    }
  }
