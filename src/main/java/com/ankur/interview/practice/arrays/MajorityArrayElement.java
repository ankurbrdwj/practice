package com.ankur.interview.practice.arrays;

public class MajorityArrayElement {
  public static int majorityElementBitwise(int[] array) {
    return 0;
  }

  public static int majorityElement1(int[] array) {
    int count = 0;
    int answer = array[0];
    for (int value : array) {
      if (count == 0) {
        answer = value;
      }
      if (value == answer) {
        count++;
      } else {
        count--;
      }
    }
    return answer;
  }

  public static int majorityElement2(int[] array) {
    int answer = 0;
    for (int currentBit = 0; currentBit < 32; currentBit++) {
      int currentBitValue = 1 << currentBit;
      int onesCount = 0;
      for (int num : array) {
        if ((num & currentBitValue) != 0) {
          onesCount++;
        }
      }
      if (onesCount > array.length / 2) {
        answer += currentBitValue;
      }
    }
    return answer;
  }
}
