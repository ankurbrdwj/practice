package com.ankur.interview.practice.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SweetAndSalty {
  public static int[] getSweetAndSalty(int[] dishes, int target) {
    int left = 0;
    int right = 0;
    int[] bestPair = new int[2];
    int bestDifference = Integer.MAX_VALUE;
    List<Integer> sweetList = new ArrayList<>();
    List<Integer> savoryList = new ArrayList<>();
    for (int dish : dishes) {
      if (dish > 0) {
        savoryList.add(dish);
      } else {
        sweetList.add(dish);
      }
    }
      sweetList.sort(Comparator.comparingInt(Math::abs));
      savoryList.sort(Comparator.naturalOrder());

      while (left < sweetList.size() && right < savoryList.size()) {
        int currentSum = sweetList.get(left) + savoryList.get(right);
        if (currentSum <= target) {
          int currentDifference = target - currentSum;
          if (currentDifference < bestDifference) {
            bestDifference = currentDifference;
            bestPair[0] = sweetList.get(left);
            bestPair[1] = savoryList.get(right);
          }
          right++;
        }else{
          left++;
        }
      }
    return bestPair;
  }
}
