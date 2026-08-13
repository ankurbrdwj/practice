package com.ankur.interview.practice.heaps;

import java.util.TreeMap;

// Sliding-Window Median — median of the last k elements of a running stream.
//
// WHY NOT TWO PLAIN PRIORITY QUEUES (like Median.java)?
// ───────────────────────────────────────────────────────────────────────────
// The continuous-median trick (max-heap | min-heap) breaks down here because
// we must also REMOVE the element that just left the window. PriorityQueue
// can remove an arbitrary element, but only in O(n) — too slow.
//
// FIX: Replace both heaps with TreeMap<value, count>.
//   • TreeMap keeps keys sorted → lastKey() = max, firstKey() = min  (O(log k))
//   • merge(val, ±1) handles duplicates by counting occurrences
//   • insert AND remove are both O(log k)
//
// INVARIANT (same as Median.java, just with TreeMaps):
//   lower  = max-side (smaller half),  lSize elements
//   upper  = min-side (larger half),   uSize elements
//   lSize == uSize      → median = avg of lower.lastKey() and upper.firstKey()
//   lSize == uSize + 1  → median = lower.lastKey()
//   (lower always holds the extra element when k is odd)
//
// ─── EXAMPLE TRACE  nums = [2, 1, 5, 3],  k = 2 ────────────────────────────
//
//   i=0  add(2):  lower={2} lS=1  upper={} uS=0   balance→ok   window not full
//
//   i=1  add(1):  1≤lastKey(2) → lower={1,2} lS=2
//         balance: lS=2 > uS+1=1 → move lastKey 2 → upper={2} uS=1  lower={1} lS=1
//         window full (i=k-1=1): median = (1+2)/2 = 1.5   result[0]=1.5
//
//   i=2  add(5):  5>lastKey(1) → upper={2,5} uS=2
//         balance: uS=2 > lS=1  → move firstKey 2 → lower={1,2} lS=2  upper={5} uS=1
//         evict nums[0]=2: 2≤lastKey(2) → remove from lower → lower={1} lS=1
//         balance: lS=1 uS=1 ok
//         median = (1+5)/2 = 3.0   result[1]=3.0
//
//   i=3  add(3):  3>lastKey(1) → upper={3,5} uS=2
//         balance: uS=2 > lS=1  → move firstKey 3 → lower={1,3} lS=2  upper={5} uS=1
//         evict nums[1]=1: 1≤lastKey(3) → remove from lower → lower={3} lS=1
//         balance: lS=1 uS=1 ok
//         median = (3+5)/2 = 4.0   result[2]=4.0
//
//   result = [1.5, 3.0, 4.0]
// ─────────────────────────────────────────────────────────────────────────────
//
// Time:  O(n log k)   Space: O(k)
public class SlidingWindowMedian {

    // lower = max-side (smaller half), upper = min-side (larger half)
    private final TreeMap<Integer, Integer> lower = new TreeMap<>();
    private final TreeMap<Integer, Integer> upper = new TreeMap<>();
    private int lSize = 0, uSize = 0;

    // Returns the median of each k-length window as it slides across nums.
    public double[] medians(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
            if (i >= k) evict(nums[i - k]); // element that just left the window
            if (i >= k - 1) result[i - k + 1] = median(k);
        }
        return result;
    }

    // ── private helpers ───────────────────────────────────────────────────────

    private void add(int val) {
        if (lower.isEmpty() || val <= lower.lastKey()) {
            lower.merge(val, 1, Integer::sum);
            lSize++;
        } else {
            upper.merge(val, 1, Integer::sum);
            uSize++;
        }
        balance();
    }

    private void evict(int val) {
        if (!lower.isEmpty() && val <= lower.lastKey()) {
            decrement(lower, val);
            lSize--;
        } else {
            decrement(upper, val);
            uSize--;
        }
        balance();
    }

    // Keeps lSize == uSize  or  lSize == uSize + 1.
    private void balance() {
        while (lSize > uSize + 1) {
            int top = lower.lastKey();
            decrement(lower, top);
            lSize--;
            upper.merge(top, 1, Integer::sum);
            uSize++;
        }
        while (uSize > lSize) {
            int top = upper.firstKey();
            decrement(upper, top);
            uSize--;
            lower.merge(top, 1, Integer::sum);
            lSize++;
        }
    }

    private double median(int k) {
        if (k % 2 == 1) return lower.lastKey();
        return ((double) lower.lastKey() + upper.firstKey()) / 2.0;
    }

    // Decrements count; removes the key entirely when count reaches zero.
    private void decrement(TreeMap<Integer, Integer> map, int val) {
        if (map.merge(val, -1, Integer::sum) == 0) map.remove(val);
    }
}