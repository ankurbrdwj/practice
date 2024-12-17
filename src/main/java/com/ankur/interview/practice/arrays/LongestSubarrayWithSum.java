package com.ankur.interview.practice.arrays;

public class LongestSubarrayWithSum {
  /*
  / How Does a slinding window slides
   */
  public int[] findLongestSubArrayWithSum(int[] array, int targetSum) {
    // Write your code here.
    int[] result = new int[] {};
    int leftIndex = 0;
    int rightIndex = 0;
    int currentSum = 0;
    while (rightIndex < array.length) {
      currentSum = currentSum + array[rightIndex];
      while (leftIndex < rightIndex && currentSum > targetSum) {
        // remove the left element
        currentSum = currentSum - array[leftIndex];
        // and slide
        leftIndex++;
      }
      if (currentSum == targetSum) {
        if (result.length == 0 || result[1] - result[0] < rightIndex - leftIndex) {
          result = new int[] {leftIndex, rightIndex};
        }
      }
      rightIndex++;
    }

    return result;
  }
}
