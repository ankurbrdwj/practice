package com.ankur.interview.practice.arrays;

import java.util.Arrays;

public class NumbersWithDiffK {
  static int countPairsWithDiffK(int arr[], int n,
                                 int k)
  {
    int count = 0;
    Arrays.sort(arr); // Sort array elements

    int l = 0;
    int r = 0;
    while(r < n)
    {
      int diff = arr[r] - arr[l];
      if(diff == k)
      {
        count++;
       // l++;
        r++;
      }
      else if(diff > k)
        l++;
      else // arr[r] - arr[l] < sum
        r++;
    }
    return count;
  }

  // Driver program to test above function
  public static void main(String[] args)
  {
    int arr[] = {1,3,1,8};
    int n = arr.length;
    int k = 2;
    System.out.println("Count of pairs with given diff is " +
      countPairsWithDiffK(arr, n, k));
  }
}
