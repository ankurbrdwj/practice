package com.ankur.interview.practice.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMajorityElement {

  @Test
  public void TestCase1() {
    var input = new int[] {1, 2, 3, 2, 2, 1, 2};
    var expected = 2;
    var actual = MajorityArrayElement.majorityElement1(input);
    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void TestCase2() {
    var input = new int[] {1, 2, 3, 2, 2, 1, 2};
    var expected = 2;
    var actual = MajorityArrayElement.majorityElement2(input);
    Assertions.assertEquals(expected, actual);
  }
}
