package com.ankur.interview.practice.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBestSeatInARow {
  @Test
  public void TestCase1() {
    var input = new int[] {1, 0, 1, 0, 0, 0, 1};
    var expected = 4;
    var actual = new BestSeatInARow().bestSeat(input);
    Assertions.assertTrue(expected == actual);
  }
}
