package com.ankur.interview.practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximizeExpressionInAnArray {

  public static int maximizeExpression(int[] array) {
    if(array.length < 4) {
      return 0;
    }
    List<Integer> maxOfA = new ArrayList<>(Arrays.asList(array[0]));
    List<Integer> maxOfAMinusB = new ArrayList<>(Arrays.asList(Integer.MIN_VALUE));
    List<Integer> maxOfAMinusBPlusC = new ArrayList<>(Arrays.asList(Integer.MIN_VALUE,Integer.MIN_VALUE));
    List<Integer> maxOfAMinusBPlusCMinusD = new ArrayList<>(Arrays.asList(Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE));

    for(int i = 1; i < array.length; i++) {
      maxOfA.add(Math.max(maxOfA.get(i - 1), array[i]));
    }
    for (int i = 1; i < array.length; i++) {
      maxOfAMinusB.add(Math.max(maxOfAMinusB.get(i - 1), maxOfA.get(i - 1) - array[i]));
    }
    for( int i = 2; i < array.length; i++) {
      maxOfAMinusBPlusC.add(Math.max(maxOfAMinusBPlusC.get(i - 1), maxOfAMinusB.get(i - 1) + array[i]));
    }
    for(int i = 3; i < array.length; i++) {
      maxOfAMinusBPlusCMinusD.add(Math.max(maxOfAMinusBPlusCMinusD.get(i - 1), maxOfAMinusBPlusC.get(i - 1) - array[i]));
    }

    return maxOfAMinusBPlusCMinusD.get(array.length - 1);
  }
}
