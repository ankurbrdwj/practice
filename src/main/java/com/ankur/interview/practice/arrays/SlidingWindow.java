package com.ankur.interview.practice.arrays;

public class SlidingWindow {
  /*
  /Get max sum on k elements in array
   */
  public static void main(String[] args) {
    int[] a = {1, 3, 5, 7, 2, 4, 6,1,3,9};
    int k = 3;
    int maxSum = getMaxSum(a, k);
    System.out.println(maxSum);
  }

  private static int getMaxSum(int[] a, int k) {
    int windowSum = 0;
    int maxSum = 0;
    int start = 0;
    for (int i = 0; i < a.length; i++) {
      windowSum = windowSum + a[i];
      if((i-start+1)==k){
        maxSum= Math.max(maxSum,windowSum);
        windowSum = windowSum - a[start];
        start ++;
      }
    }
    return maxSum;
  }
}
