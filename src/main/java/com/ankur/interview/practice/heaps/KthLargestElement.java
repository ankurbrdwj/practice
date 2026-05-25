package com.ankur.interview.practice.heaps;

import java.util.PriorityQueue;

/*
 * Kth Largest Element in an Array (LeetCode 215) — Min Heap of Size K
 *
 * Maintain a min heap of the k largest elements seen so far.
 * For each number: add it, then if heap size exceeds k, poll the minimum.
 * The heap top is always the kth largest.
 *
 * Why min heap? We want to evict the smallest of the k candidates, keeping
 * the k largest. A min heap puts the smallest at the top for O(log k) removal.
 *
 * Time  O(n log k)
 * Space O(k)
 *
 * Example: [3,2,1,5,6,4], k=2 → 5
 * Example: [3,2,3,1,2,4,5,5,6], k=4 → 4
 */
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.poll();
    }
}