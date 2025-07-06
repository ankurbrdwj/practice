package com.ankur.interview.practice.dyanamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.ankur.interview.practice.dynamicprogramming.MaximizeExpressionInAnArray;

public class TestMaximizeExpression {
    @Test
    public void TestCase1() {
      int[] input = new int[] {3, 6, 1, -3, 2, 7};
      int expected = 4;
      var actual = MaximizeExpressionInAnArray.maximizeExpression(input);
      Assertions.assertTrue(expected == actual);
    }
  }
