package com.ankur.interview.practice.stacks;

import org.junit.jupiter.api.Test;

public class TestNextGreaterElement {
  @Test
  public void testNextGreaterInArray(){
        int[] input = new int[] {2, 5, -3, -4, 6, 7, 2};
        int[] expected = new int[] {5, 6, 6, 6, 7, -1, 5};
        int[] actual = new NextGreaterElement().nextGreaterElement(input);
        assert (expected.equals(actual));
      }

  @Test
  public void testNextGreaterIndex(){
    int[] input = new int[] {2, 5, -3, -4, 6, 7, 2};
    int[] expected = new int[] {5, 6, 6, 6, 7, -1, 5};
    int[] actual = new NextGreaterElement().nextGreaterIndex(input);
    assert (expected.equals(actual));
  }
}
