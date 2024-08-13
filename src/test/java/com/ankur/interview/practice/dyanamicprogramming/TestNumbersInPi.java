package com.ankur.interview.practice.dyanamicprogramming;

import com.ankur.interview.practice.dynamicprogramming.NumbersInPi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestNumbersInPi {
    String PI = "3141592653589793238462643383279";

    @Test
    public void TestCase1() {
      String[] numbers =
        new String[] {
          "314159265358979323846", "26433", "8", "3279", "314159265", "35897932384626433832", "79"
        };
      Assertions.assertTrue(NumbersInPi.numbersInPi(PI, numbers) == 2);
    }
  }
