package com.ankur.interview.practice.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

// LeetCode 295 — Find Median from Data Stream
//
// Design a class that supports two operations on a live number stream:
//   addNum(int)     — insert a number
//   findMedian()   — return the median of all numbers inserted so far
//
// ═══════════════════════════════════════════════════════════════════════════
// THE TWO-HEAP TRICK
// ═══════════════════════════════════════════════════════════════════════════
//
// Imagine the sorted stream split down the middle:
//
//   lower half  │  upper half
//   ────────────┼────────────
//   1  2  3  [4]│[5]  7  9
//                ↑    ↑
//            max-heap  min-heap
//            (lowers)  (uppers)
//
//   • lowers  = max-heap  →  its ROOT is the LARGEST of the small half
//   • uppers  = min-heap  →  its ROOT is the SMALLEST of the large half
//
//   No matter how many numbers arrive, we only ever need those two roots
//   to compute the median — everything else stays buried in the heaps.
//
// INVARIANT after every addNum:
//   lowers.size() == uppers.size()       → median = avg of both roots
//   lowers.size() == uppers.size() + 1   → median = lowers.peek()
//   (lowers holds the extra element when the total count is odd)
//
// ═══════════════════════════════════════════════════════════════════════════
// STEP-BY-STEP TRACE   stream: 5, 2, 8, 3, 9
// ═══════════════════════════════════════════════════════════════════════════
//
//  addNum(5)
//    route: lowers empty → push 5 to lowers
//    lowers=[5]  uppers=[]   sizes 1-0  → lowers has extra  median = 5.0
//
//  addNum(2)
//    route: 2 ≤ lowers.peek()=5 → push 2 to lowers
//    lowers=[5,2]  sizes 2-0  → lowers 2 ahead, rebalance:
//      pop 5 from lowers → push 5 to uppers
//    lowers=[2]  uppers=[5]  sizes 1-1  → median = (2+5)/2 = 3.5
//
//  addNum(8)
//    route: 8 > lowers.peek()=2 → push 8 to uppers
//    lowers=[2]  uppers=[5,8]  sizes 1-2  → uppers ahead, rebalance:
//      pop 5 from uppers → push 5 to lowers
//    lowers=[5,2]  uppers=[8]  sizes 2-1  → lowers has extra  median = 5.0
//
//  addNum(3)
//    route: 3 ≤ lowers.peek()=5 → push 3 to lowers
//    lowers=[5,2,3]  uppers=[8]  sizes 3-1  → lowers 2 ahead, rebalance:
//      pop 5 from lowers → push 5 to uppers
//    lowers=[3,2]  uppers=[5,8]  sizes 2-2  → median = (3+5)/2 = 4.0
//
//  addNum(9)
//    route: 9 > lowers.peek()=3 → push 9 to uppers
//    lowers=[3,2]  uppers=[5,8,9]  sizes 2-3  → uppers ahead, rebalance:
//      pop 5 from uppers → push 5 to lowers
//    lowers=[5,3,2]  uppers=[8,9]  sizes 3-2  → lowers has extra  median = 5.0
//
//  Final sorted view:  2  3  [5]  8  9   ← median = 5.0  ✓
//
// ═══════════════════════════════════════════════════════════════════════════
// Time:  addNum O(log n)   findMedian O(1)     Space: O(n)
// ═══════════════════════════════════════════════════════════════════════════
public class MedianFromStream {

    // max-heap: peek() gives the largest element of the lower half
    private final PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder());
    // min-heap: peek() gives the smallest element of the upper half
    private final PriorityQueue<Integer> uppers = new PriorityQueue<>();

    public void addNum(int num) {
        // Route: belongs to lower half if ≤ current max of lowers, else upper half.
        if (lowers.isEmpty() || num <= lowers.peek()) {
            lowers.offer(num);
        } else {
            uppers.offer(num);
        }
        rebalance();
    }

    public double findMedian() {
        if (lowers.size() > uppers.size()) return lowers.peek();
        return ((double) lowers.peek() + uppers.peek()) / 2.0;
    }

    // Ensures lowers is never more than 1 ahead, and never behind uppers.
    private void rebalance() {
        if (lowers.size() > uppers.size() + 1) {
            uppers.offer(lowers.poll()); // push max of lowers up to uppers
        } else if (uppers.size() > lowers.size()) {
            lowers.offer(uppers.poll()); // pull min of uppers down to lowers
        }
    }
}