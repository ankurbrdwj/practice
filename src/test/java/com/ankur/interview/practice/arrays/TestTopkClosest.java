package com.ankur.interview.practice.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTopkClosest {
  @Test
  void kClosest(){
    int [] arr = new int []{-6,-5,-3,-1,1,2,4,6,7,9};
    int[] result =
      TopKClosestNumbers.findKClosest(arr,-1,5);
    int[] exp= new int[]{-5,-3,1,2,4};
    Assertions.assertArrayEquals(result,exp);
  }
}
