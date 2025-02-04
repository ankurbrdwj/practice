package com.ankur.interview.practice.arrays;

import com.ankur.interview.practice.greedy.CanSeeOcean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestOceanView {
  @Test
  void testHaveOceanView(){
    int[] input = new int[]{4, 2 ,3 ,1};
    int[] output = new int[]{0,2,3};


   int[] actual= CanSeeOcean.haveOceanView(input);
    Assertions.assertArrayEquals(output,actual);
  }
}
