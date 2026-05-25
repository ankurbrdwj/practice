package com.ankur.interview.practice.lists;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    // blind75
    //
    // Algorithm: Min-Heap (PriorityQueue)
    //
    // Problem: given k sorted linked lists, merge them into one sorted list.
    //
    // Approach:
    //   1. Seed a min-heap with the head of every non-null list.
    //   2. Repeatedly poll the smallest node, append it to the result,
    //      then push that node's next (if any) back into the heap.
    //   3. The heap always holds at most k nodes, so each poll/push is O(log k).
    //
    // Time:  O(N log k)  — N total nodes, k lists
    // Space: O(k)        — heap holds at most one node per list
    //
    // --- Trace with k=3 lists: [1->4->5], [1->3->4], [2->6] ---
    //
    // Step 0  seed heap          heap: {1(L0), 1(L1), 2(L2)}   result: []
    // Step 1  poll 1(L0), push 4 heap: {1(L1), 2(L2), 4(L0)}   result: [1]
    // Step 2  poll 1(L1), push 3 heap: {2(L2), 3(L1), 4(L0)}   result: [1,1]
    // Step 3  poll 2(L2), push 6 heap: {3(L1), 4(L0), 6(L2)}   result: [1,1,2]
    // Step 4  poll 3(L1), push 4 heap: {4(L0), 4(L1), 6(L2)}   result: [1,1,2,3]
    // Step 5  poll 4(L0), push 5 heap: {4(L1), 5(L0), 6(L2)}   result: [1,1,2,3,4]
    // Step 6  poll 4(L1), no next heap: {5(L0), 6(L2)}          result: [1,1,2,3,4,4]
    // Step 7  poll 5(L0), no next heap: {6(L2)}                  result: [1,1,2,3,4,4,5]
    // Step 8  poll 6(L2), no next heap: {}                        result: [1,1,2,3,4,4,5,6]
    //
    public static SinglyLinkedList mergeKSortedLists(SinglyLinkedList[] lists) {
        // Min-heap ordered by node value
        PriorityQueue<SinglyLinkedList> heap =
                new PriorityQueue<>((a, b) -> a.value - b.value);

        // Seed heap with the head of each non-empty list
        for (SinglyLinkedList head : lists) {
            if (head != null) heap.offer(head);
        }

        // Sentinel head avoids null checks when appending to result
        SinglyLinkedList sentinel = new SinglyLinkedList(0);
        SinglyLinkedList tail = sentinel;

        while (!heap.isEmpty()) {
            // Smallest node across all lists
            SinglyLinkedList node = heap.poll();
            tail.next = node;
            tail = tail.next;

            // Advance that list by one and re-insert into heap
            if (node.next != null) heap.offer(node.next);
        }

        return sentinel.next;
    }
}