package com.ankur.interview.practice.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRemoveIslands {
  // This file is initialized with a code version of this
// question's sample test case. Feel free to add, edit,
// or remove test cases in this file as you see fit!

  @Test
    public void TestCase1() {
      int[][] input =
        new int[][] {
          {1, 0, 0, 0, 0, 0},
          {0, 1, 0, 1, 1, 1},
          {0, 0, 1, 0, 1, 0},
          {1, 1, 0, 0, 1, 0},
          {1, 0, 1, 1, 0, 0},
          {1, 0, 0, 0, 0, 1},
        };
      int[][] expected =
        new int[][] {
          {1, 0, 0, 0, 0, 0},
          {0, 0, 0, 1, 1, 1},
          {0, 0, 0, 0, 1, 0},
          {1, 1, 0, 0, 1, 0},
          {1, 0, 0, 0, 0, 0},
          {1, 0, 0, 0, 0, 1},
        };
      int[][] actual = new RemoveIsland().removeIslands(input);
      for (int i = 0; i < actual.length; i++) {
        for (int j = 0; j < actual[i].length; j++) {
          Assertions.assertEquals(actual[i][j], expected[i][j]);
        }
      }
    }
  }


