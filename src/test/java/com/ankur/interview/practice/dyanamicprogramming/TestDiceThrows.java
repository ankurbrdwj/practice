package com.ankur.interview.practice.dyanamicprogramming;

import com.ankur.interview.practice.dynamicprogramming.DiceThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDiceThrows {
    @Test
    public void TestCase1() {
      var numDice = 2;
      var numSides = 6;
      var target = 7;
      var expected = 6;
      var actual = DiceThrows.countWays(numDice, numSides, target);
      Assertions.assertTrue(expected == actual);
    }
  }

