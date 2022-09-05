package com.ankur.interview.practice.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestIntervals {
  @Test
  public void testIntervals(){
    int[][] input1= new int[][]{{0,2},{5,10},{13,23},{24,25}};
    int[][] input2 = new int[][]{{1,5},{8,12},{15,24},{25,26}};
    int[][] exp = new int[][]{{1,2},{5,5},{8,10},{15,23},{24,24},{25,25}};
    int[][] result = IntersectingInterval.intervalIntersection(input1,input2);
    Assertions.assertArrayEquals(exp, result);
  }
  @Test
  public void testIntervals2(){
    int[][] input1= new int[][]{{0,2},{5,10},{13,23},{24,25}};
    int[][] input2 = new int[][]{{1,5},{8,12},{15,24},{25,26}};
    int[][] exp = new int[][]{{1,2},{5,5},{8,10},{15,23},{24,24},{25,25}};
    int[][] result = IntersectingInterval.intervalIntersection(input1,input2);
    Assertions.assertArrayEquals(exp, result);
  }
}
