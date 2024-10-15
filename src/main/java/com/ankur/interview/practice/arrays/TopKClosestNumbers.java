package com.ankur.interview.practice.arrays;

import java.util.Arrays;

public class TopKClosestNumbers {

    public static int[] findKClosest(int[] arr, int center, int k) {
      // Initialize two pointers
      int left = 0, right = arr.length - 1;

      // Shrink the window to keep only k closest elements
      while (right - left + 1 > k) {
        // Compare the absolute differences and move the farther pointer
        if (Math.abs(arr[left] - center) > Math.abs(arr[right] - center)) {
          left++;
        } else {
          right--;
        }
      }

      // The range from left to right now contains the k closest elements
      return Arrays.stream(Arrays.copyOfRange(arr, left, right + 2))
        .filter(value -> value != center)  // Filter out the center value
        .toArray();
    }

  }

