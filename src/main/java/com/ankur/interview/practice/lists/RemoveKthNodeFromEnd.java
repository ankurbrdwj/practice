package com.ankur.interview.practice.lists;

/*
 * PROBLEM: Remove Kth Node From End of List  (Blind 75)
 *
 * Given the head of a singly linked list and an integer k, remove the kth
 * node from the END of the list. The removal is in-place; the method is void.
 *
 * Constraints:
 *   - The list has at least one node.
 *   - 1 <= k <= length of list
 *
 * Examples:
 *
 *   Input:  0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9,  k = 1
 *   Output: 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8        (removed last)
 *
 *   Input:  0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9,  k = 4
 *   Output: 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 7 -> 8 -> 9        (removed 6)
 *
 *   Input:  0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9,  k = 10
 *   Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9        (removed head)
 *
 * Approach: Two pointers — keep `second` exactly k steps ahead of `first`.
 * When `second` reaches the last node, `first` is just before the target.
 *
 * Special case: if `second` falls off the list (== null) after the initial
 * k steps, the head itself must be removed. Since the method is void (can't
 * return a new head), we copy the next node's value into head and skip it.
 *
 * Time: O(n)   Space: O(1)
 */
public class RemoveKthNodeFromEnd {

  public static void removeKthNodeFromEnd(LinkedList head, int k) {
    LinkedList first = head;
    LinkedList second = head;

    // advance `second` k steps so the gap between the two pointers is k
    int count = 1;
    while (count <= k) {
      second = second.next;
      count++;
    }

    // second fell off the end → the head is the kth node from the end.
    // Can't reassign `head`, so overwrite its value with the next node's value.
    if (second == null) {
      head.value = head.next.value;
      head.next  = head.next.next;
      return;
    }

    // move both pointers until second reaches the last node;
    // first then points to the node just before the one to remove
    while (second.next != null) {
      second = second.next;
      first  = first.next;
    }

    first.next = first.next.next; // unlink the target node
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
