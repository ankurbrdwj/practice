package com.ankur.interview.practice.stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * Next Greater Element — Brute → Optimal
 *
 * Problem: For each element find the NEXT element to its RIGHT that is
 * strictly greater. Return -1 if none exists.
 *
 * Example (non-circular): [4, 5, 2, 10, 8] → [5, 10, 10, -1, -1]
 *
 * Variation — Circular: treat the array as wrapping around.
 * Example: [2, 5, -3, -4, 6, 7, 2] → [5, 6, 6, 6, 7, -1, 5]
 *
 * ─────────────────────────────────────────────────────
 * Approach          Time     Space
 * ─────────────────────────────────────────────────────
 * Brute force       O(n²)    O(1) extra
 * Optimal (stack)   O(n)     O(n)   (each element pushed/popped once)
 * Circular          O(n)     O(n)   (2-pass trick with index % n)
 * ─────────────────────────────────────────────────────
 */
public class NextGreaterElement {

    // -------------------------------------------------------------------------
    // 1. BRUTE FORCE — O(n²) time, O(1) extra space
    //
    //    For every index i, scan j = i+1 … n-1 until arr[j] > arr[i].
    //    Simple, but each element may scan the entire remaining array.
    // -------------------------------------------------------------------------
    public int[] bruteForce(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }
        return result;
    }

    // -------------------------------------------------------------------------
    // 2. OPTIMAL (right-to-left) — O(n) time, O(n) space
    //
    //    Monotonic decreasing stack (stores VALUES, top is smallest).
    //
    //    Scan right → left. At index i:
    //      • Pop stack elements that are <= arr[i].
    //        (They are useless: arr[i] is to the LEFT and already >= them,
    //         so they can never be the "next greater" for anything further left.)
    //      • Stack top (if any) is the next greater for arr[i].
    //      • Push arr[i].
    //
    //    Why O(n)? Every element is pushed exactly once and popped at most once.
    // -------------------------------------------------------------------------
    public int[] optimal(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }

    // -------------------------------------------------------------------------
    // 3. OPTIMAL (left-to-right) — O(n) time, O(n) space
    //
    //    Alternative scanning direction. Stack stores INDICES of elements
    //    whose next-greater has not yet been found.
    //
    //    At index i: while stack top index j has arr[j] < arr[i], arr[i] is
    //    the answer for j — pop and assign. Then push i.
    //
    //    Produces identical output; useful when you need to know the index gap.
    // -------------------------------------------------------------------------
    public int[] optimalLeftToRight(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        return result;
    }

    // -------------------------------------------------------------------------
    // 4. CIRCULAR VARIANT — O(n) time, O(n) space
    //
    //    Treat the array as wrapping around: element at index n-1 can look
    //    forward to index 0, 1, … as its "right" neighbours.
    //
    //    Trick: iterate index from 2n-1 down to 0, use i % n for real index.
    //    The first pass (i >= n) seeds the stack with all values so the second
    //    pass (i < n) can see "future" elements as if the array wrapped.
    //    Only write result during the real pass (i < n), and only once
    //    (result[idx] == -1 guard) so we don't overwrite a valid answer.
    // -------------------------------------------------------------------------
    public int[] circular(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;
            while (!stack.isEmpty() && stack.peek() <= arr[idx]) {
                stack.pop();
            }
            if (i < n && result[idx] == -1 && !stack.isEmpty()) {
                result[idx] = stack.peek();
            }
            stack.push(arr[idx]);
        }
        return result;
    }

    // backward-compat alias
    public int[] nextGreaterElement(int[] array) {
        return circular(array);
    }
}