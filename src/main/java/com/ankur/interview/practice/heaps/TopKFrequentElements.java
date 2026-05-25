package com.ankur.interview.practice.heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Top K Frequent Elements (LeetCode 347) — HashMap + Min Heap
 *
 * Build a frequency map, then use a min heap of size k keyed by frequency.
 * Evict the least-frequent element when heap exceeds k, leaving the k most
 * frequent elements at the end.
 *
 * Alternative O(n) approach: bucket sort by frequency (index = frequency,
 * value = list of numbers with that frequency), scan buckets high→low.
 *
 * Time  O(n log k)
 * Space O(n)
 *
 * Example: nums=[1,1,1,2,2,3], k=2 → [1,2]
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.merge(n, 1, Integer::sum);

        // min heap ordered by frequency — evict the least frequent
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(freq::get));
        for (int n : freq.keySet()) {
            minHeap.add(n);
            if (minHeap.size() > k) minHeap.poll();
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) result[i] = minHeap.poll();
        return result;
    }

    // O(n) bucket-sort variant
    public int[] topKFrequentBuckets(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.merge(n, 1, Integer::sum);

        @SuppressWarnings("unchecked")
        java.util.List<Integer>[] buckets = new java.util.List[nums.length + 1];
        for (int n : freq.keySet()) {
            int f = freq.get(n);
            if (buckets[f] == null) buckets[f] = new java.util.ArrayList<>();
            buckets[f].add(n);
        }

        int[] result = new int[k];
        int idx = 0;
        for (int f = buckets.length - 1; f >= 0 && idx < k; f--) {
            if (buckets[f] != null) {
                for (int n : buckets[f]) {
                    if (idx == k) break;
                    result[idx++] = n;
                }
            }
        }
        return result;
    }
}