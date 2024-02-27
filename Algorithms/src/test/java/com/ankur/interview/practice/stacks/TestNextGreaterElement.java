package com.ankur.interview.practice.stacks;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class TestNextGreaterElement {
  @Test
  void testNextGreaterInArray(){
        int[] input = new int[] {2, 5, -3, -4, 6, 7, 2};
        int[] expected = new int[] {5, 6, 6, 6, 7, -1, 5};
        int[] actual = new NextGreaterElement().nextGreaterElement(input);
    assertArrayEquals(expected, actual);
      }

  @Test
  void testNextGreaterIndex(){
    int[] input = new int[] {2, 5, -3, -4, 6, 7, 2};
    int[] expected = new int[] {5, 6, 6, 6, 7, -1, 5};
    int[] actual = new NextGreaterElement().nextGreaterIndex(input);
    assertArrayEquals(expected, actual);
  }
}
