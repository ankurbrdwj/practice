package com.ankur.interview.practice.stacks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestSunsetView {
  @Test
  public void TestCase1() {
    int[] buildings = new int[] {3, 5, 4, 4, 3, 1, 3, 2};
    String direction = "EAST";
    ArrayList<Integer> expected = new ArrayList<Integer>();
    expected.add(1);
    expected.add(3);
    expected.add(6);
    expected.add(7);
    var actual = SunsetViews.sunsetViews(buildings, direction);
     Assertions.assertEquals(expected, actual);
  }
}
