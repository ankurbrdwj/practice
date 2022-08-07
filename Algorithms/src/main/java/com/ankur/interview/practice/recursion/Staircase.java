package com.ankur.interview.practice.recursion;

public class Staircase {
  /*
  staircase of height k and max number step s can be travelled in
  numways[k-1]+numways[k-2]+numways[k-3]+ . . . . numways[k-s] /

   */

  public static int findMaxSteps(int height, int maxSteps) {
    return maxStepsHelper(height, maxSteps);
  }

  private static int maxStepsHelper(int height, int maxSteps) {
    if (height <= 1)
      return 1;
    int numWays = 0;
    for (int step = 1; step < Math.min(maxSteps, height) + 1; step++) {
      numWays += maxStepsHelper(height - step, maxSteps);
    }

    return numWays;
  }
}
