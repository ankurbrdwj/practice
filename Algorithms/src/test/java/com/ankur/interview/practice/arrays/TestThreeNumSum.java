package com.ankur.interview.practice.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestThreeNumSum {
    private boolean compare(List<Integer[]> triplets1, List<Integer[]> triplets2) {
      if (triplets1.size() != triplets2.size()) return false;
      for (int i = 0; i < triplets1.size(); i++) {
        if (!Arrays.equals(triplets1.get(i), triplets2.get(i))) {
          return false;
        }
      }
      return true;
    }

    @Test
    public void TestCase1() {
      List<List<Integer>> expected = new ArrayList<>();
      expected.add(Arrays.asList(-1, -1, 2));
      expected.add(Arrays.asList(-1, 0, 1));
      List<List<Integer>> output = Triplets.findTriplets(new int[] {-1,0,1,2,-1,-4}, 0);
      Assertions.assertEquals(output, expected);
    }
  }
