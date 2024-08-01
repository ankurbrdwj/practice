package com.ankur.interview.practice.lists;

public class LinkedListPalindrome {
  /*
  / 1 find the second half of list
    2 reverse the second half
    3 it should be same
   */

  public boolean listPalindrome(LinkedList head) {
    // Write your code here.
    LinkedList firstHalfHead = head;
    LinkedList secondHalfHead = findSecondHalf(head);
    LinkedList reversedSecondHalfNode = reverseLinkedList(secondHalfHead);
    while (reversedSecondHalfNode != null) {
      if (reversedSecondHalfNode.value != firstHalfHead.value) {
        return false;
      }
      reversedSecondHalfNode = reversedSecondHalfNode.next;
      firstHalfHead = firstHalfHead.next;
    }
    return true;
  }

  public LinkedList findSecondHalf(LinkedList head) {
    LinkedList fastPtr = head;
    LinkedList slowPtr = head;
    while (fastPtr != null && fastPtr.next != null) {
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;
    }
    return slowPtr;
  }

  static LinkedList reverseLinkedList(LinkedList head) {
    LinkedList previous = null;
    LinkedList current = head;
    while (current != null) {
      LinkedList nextNode = current.next;
      current.next = previous;
      previous = current;
      current = nextNode;
    }
    return previous;
  }

  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

}
