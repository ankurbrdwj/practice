package com.ankur.interview.practice.greedy;

import java.util.Arrays;

public class CheckWaitTime {
  /*
  / given input List of execution times in  array input =[3,2,1,2,6]
  return and array with minimum waiting time for each input
  min waiting time is sum of all the execution times after the current index
   */
  static int minimumWaitingTime(int[] input) {
    Arrays.sort(input);  // nlogn
    int minWaitingTime = 0;
    for (int i = 0; i < input.length; i++) {
      // all will have to wait for current execution time
      // so curreent will be added to all remaining
      int remainingQueries = input.length - (i + 1);
      int minWaitingTimeForCurrentQuery = remainingQueries * input[i];
      minWaitingTime += minWaitingTimeForCurrentQuery;
    }
    return minWaitingTime;
  }
}
