package com.ankur.interview.practice.heaps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestKSortedArray {

  @Test
  public void TestCase1() {
    int[] input = new int[] {3, 2, 1, 5, 4, 7, 6, 5};
    int k = 3;
    int[] expected = new int[] {1, 2, 3, 4, 5, 5, 6, 7};
    var actual = KSortedArray.sortKSortedArray(input, k);
    for (int i = 0; i < expected.length; i++) {
      Assertions.assertEquals(expected[i], actual[i]);
    }
  }
}
