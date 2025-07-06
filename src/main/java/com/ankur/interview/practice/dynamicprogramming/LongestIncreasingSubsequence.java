package com.ankur.interview.practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
  public static List<Integer> listOfLIS(int[] nums) {
    int[] chain = new int[nums.length];
    Arrays.fill(chain, Integer.MIN_VALUE);
    int[] lengths = new int[nums.length];
    Arrays.fill(lengths, 1);
    int maxLengthIdx = 1;
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          if (lengths[j] + 1 >= lengths[i]) {
            lengths[i] = lengths[j] + 1;
            chain[i] = j;
          }
        }
      }
      if (lengths[i] > lengths[maxLengthIdx]) {
        maxLengthIdx = i;
      }
    }
    return buildChain(nums, chain, maxLengthIdx);
  }

  private static List<Integer> buildChain(int[] nums, int[] chain, int maxLengthIdx) {
    List<Integer> seq = new ArrayList<>();
    int i = maxLengthIdx;
    while (i >= 0) {
      seq.add(0, nums[i]);
      i = chain[i];
    }
    return seq;
  }

  public static List<Integer> listOfLISBS(int[] array) {
    int[] chain = new int[array.length];
    int[] indices = new int[array.length+1];
    Arrays.fill(indices, Integer.MIN_VALUE);
    int maxLength = 0;
    for (int i = 0; i < array.length; i++) {
      int num = array[i];
      // binary search for  length at i
      int newLength = binarySearch(1, maxLength, array, indices, num);
      chain[i] = indices[newLength - 1];
      indices[newLength] = i;
      maxLength = Math.max(maxLength, newLength);
    }
    return buildSequence(array, chain, indices[maxLength]);
  }

  private static List<Integer> buildSequence(int[] nums, int[] chain, int currentIdx) {
    List<Integer> seq = new ArrayList<>();
    while (currentIdx != Integer.MIN_VALUE) {
      seq.add(0, nums[currentIdx]);
      currentIdx = chain[currentIdx];
    }
    return seq;
  }

  private static int binarySearch(int startIdx, int endIdx, int[] nums, int[] indices, int num) {
    if (startIdx > endIdx) {
      return startIdx;
    }
    int middleIdx = (startIdx + endIdx) / 2;
    if (nums[indices[middleIdx]] < num) {
      startIdx = middleIdx + 1;
    } else {
      endIdx = middleIdx - 1;
    }
    return binarySearch(startIdx, endIdx, nums, indices, num);
  }

}
