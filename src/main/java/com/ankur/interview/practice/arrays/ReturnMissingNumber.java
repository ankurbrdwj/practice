package com.ankur.interview.practice.arrays;

import java.util.HashSet;
import java.util.Set;

public class ReturnMissingNumber {
/*
/ sample input 12754

total= 19+6+3= 27 - 19=9
avg = 9/2 = 4

firstHalfSum = 1+2+4 = 7
secondHalfSum = 7+5 = 12
expectedfirstSum = 1+2+3+4 = 10
expectedSecondHalfSum = 5+6+7 = 18
firstNumber = expectedfirstSum - firstHalfSum = 10-7=3
secondNumber= expectedSecondHalfSum-secondHalfSum = 18 -12 = 6
 */

  public static int[] missingNumber(int[] nums) {
    int total = 0;
    for (int i = 1; i < nums.length + 3; i++) {
      total = total + i;
    }
    // get the missing total
    for (int num : nums) {
      total = total - num;
    }
    int averageOfMissingSum = total / 2;
    int firstHalfSum = 0;
    int secondHalfSum = 0;

    for (int num : nums) {
      if (num <= averageOfMissingSum) {
        firstHalfSum += num;
      } else {
        secondHalfSum += num;
      }
    }
    int expectedFirstHalfSum = 0;
    int expectedSecondHalfSum = 0;
    for (int i = 1; i < nums.length + 3; i++) {
      if (i <= averageOfMissingSum) {
        expectedFirstHalfSum += i;
      } else {
        expectedSecondHalfSum += i;
      }
    }
    return new int[]{expectedFirstHalfSum-firstHalfSum,expectedSecondHalfSum-secondHalfSum};
  }
}
