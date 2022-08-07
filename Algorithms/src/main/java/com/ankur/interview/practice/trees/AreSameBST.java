package com.ankur.interview.practice.trees;

import java.util.List;
import java.util.Objects;

public class AreSameBST {

  public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {

    return areSameBsts(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean areSameBsts(List<Integer> arrayOne, List<Integer> arrayTwo, int rootOneIdx
    , int rootTwoIdx, int minValue, int maxValue) {
    if (rootOneIdx == -1 || rootTwoIdx == -1)
      return rootOneIdx == rootTwoIdx;
    if (arrayOne.get(rootOneIdx).intValue() != arrayTwo.get(rootTwoIdx).intValue()) {
      return false;
    }

    int leftRootIdxOne = getIndexFirstSmaller(arrayOne, rootOneIdx, minValue);
    int leftRootIdxTwo = getIndexFirstSmaller(arrayTwo, rootTwoIdx, minValue);
    int rightRootIdxOne = getIndexFirstBiggerOrEqual(arrayOne, rootOneIdx, maxValue);
    int rightRootIdxTwo = getIndexFirstBiggerOrEqual(arrayTwo, rootTwoIdx , maxValue);

    int currentValue = arrayOne.get(rootOneIdx);
    boolean leftAreSame = areSameBsts(arrayOne, arrayTwo, leftRootIdxOne, leftRootIdxTwo, minValue, currentValue);
    boolean rightAreSame = areSameBsts(arrayOne, arrayTwo, rightRootIdxOne, rightRootIdxTwo, currentValue, maxValue);
    return leftAreSame && rightAreSame;
  }

  private static int getIndexFirstBiggerOrEqual(List<Integer> arrayOne, int rootTwoIdx, int maxValue) {
    for (int i = rootTwoIdx + 1; i < arrayOne.size(); i++) {
      if (arrayOne.get(i) >= arrayOne.get(rootTwoIdx) && arrayOne.get(i) < maxValue)
        return i;
    }
    return -1;
  }

  private static int getIndexFirstSmaller(List<Integer> arrayOne, int rootOneIdx, int minValue) {
    for (int i = rootOneIdx + 1; i < arrayOne.size(); i++) {
      if (arrayOne.get(i) < arrayOne.get(rootOneIdx)
        && arrayOne.get(i) >= minValue)
        return i;
    }
    return -1;
  }
}
