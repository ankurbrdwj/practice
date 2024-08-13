package com.ankur.interview.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
  //blind75
  public static void main(String[] args) {
    int[] a = {-6, -8, 12, 3, 1, 2, 5, 6};
    int target = 0;
    List<List<Integer>> result = findTriplets(a, target);
    result.forEach(arr -> {
      for (Integer i : arr) {
        System.out.print(i);
      }
      System.out.println();
    });
  }

  public static List<List<Integer>> findTriplets(int[] a, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(a);
    for (int i = 0; i < a.length - 2; i++) {
      int l = i + 1;
      int r = a.length - 1;
      while (l < r) {
        int currentSum = a[i] + a[l] + a[r];
        if (currentSum == target) {
          List<Integer> temp = Arrays.asList(a[i], a[l], a[r]);
          if (!result.contains(temp)) {
            result.add(temp);
          }
          l = l + 1;
          r = r - 1;
        } else if (currentSum < target) {
          l = l + 1;
        } else {
          r = r - 1;
        }
      }
    }
    return result;
  }
}
