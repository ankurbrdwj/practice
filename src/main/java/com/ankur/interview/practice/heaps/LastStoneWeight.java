package com.ankur.interview.practice.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Last Stone Weight (LeetCode 1046) — Max Heap
 *
 * Repeatedly smash the two heaviest stones:
 *   - If equal weight: both destroyed.
 *   - If unequal: heavier stone loses the lighter's weight, put it back.
 *
 * Use a max heap (reverse-order PriorityQueue) for O(log n) access to max.
 *
 * Time  O(n log n)
 * Space O(n)
 *
 * Example: [2,7,4,1,8,1] → 1
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) maxHeap.add(s);
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (y != x) maxHeap.add(y - x);
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}