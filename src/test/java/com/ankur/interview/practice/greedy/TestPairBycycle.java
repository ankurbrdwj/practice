package com.ankur.interview.practice.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPairBycycle {

  @Test
  public void TestCase1() {
    int[] redShirtSpeeds = new int[] {5, 5, 3, 9, 2};
    int[] blueShirtSpeeds = new int[] {3, 6, 7, 2, 1};
    boolean fastest = true;
    int expected = 32;
    var actual =
      new PairBicycleRiders().tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest);
    Assertions.assertTrue(expected == actual);
  }
}
