package com.ankur.interview.practice.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KSortedArray {
  /*
  / Sort array that is already k-sorted
   */
  public static int[] sortKSortedArray(int[] array, int k) {
    int[] sorted = new int[array.length];
    List<Integer> values = new ArrayList<>();
    for (int i = 0; i < Math.min(k + 1, array.length); i++) {
      values.add(array[i]);
    }
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(values);
    int nextIndexToInsertElement = 0;
    for (int i = k+1; i < array.length; i++) {
      int minElement = minHeap.poll();
      sorted[nextIndexToInsertElement] = minElement;
      nextIndexToInsertElement +=1;

      int currentElement = array[i];
      minHeap.add(currentElement);
    }
    while (!minHeap.isEmpty()) {
      int minElement = minHeap.poll();
      sorted[nextIndexToInsertElement] = minElement;
      nextIndexToInsertElement +=1;
    }
    return sorted;
  }
}
