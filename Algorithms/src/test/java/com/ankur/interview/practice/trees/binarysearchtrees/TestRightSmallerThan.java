package com.ankur.interview.practice.trees.binarysearchtrees;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRightSmallerThan {
  @Test
  public void testRightSmallerThan(){
    List<Integer> array = Arrays.asList(8,5,11,-1,3,4,2);
    List<Integer> result = RightSmallerThan.rightSmallerThan(array);
    List<Integer> expected = Arrays.asList(5,4,4,0,1,1,0);
    Assertions.assertArrayEquals(result.toArray(),expected.toArray());
  }
}
