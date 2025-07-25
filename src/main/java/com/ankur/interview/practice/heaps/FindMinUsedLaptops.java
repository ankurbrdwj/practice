package com.ankur.interview.practice.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class FindMinUsedLaptops {
  /*
  / find minimum number of laptops used at any time
   */
  public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
    // Write your code here.
    if (times == null || times.isEmpty()) return 0;

    // Sort intervals by start time
    times.sort(Comparator.comparingInt(a -> a.get(0)));

    // Min-heap to track end times of overlapping intervals
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (ArrayList<Integer> interval : times) {
      int start = interval.get(0);
      int end = interval.get(1);

      // If current start >= earliest ending laptop, reuse it
      if (!minHeap.isEmpty() && start >= minHeap.peek()) {
        minHeap.poll();
      }

      // Always add current end to the heap
      minHeap.add(end);
    }

    // Heap size == number of laptops in use at peak time
    return minHeap.size();
  }

}
