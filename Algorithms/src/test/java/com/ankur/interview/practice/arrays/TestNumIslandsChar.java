package com.ankur.interview.practice.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestNumIslandsChar {
  @Test
  public void testIslands(){
    char[][] arr = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
    Assertions.assertEquals(3, NumIslandsChar.numIslands(arr));
  }
}
