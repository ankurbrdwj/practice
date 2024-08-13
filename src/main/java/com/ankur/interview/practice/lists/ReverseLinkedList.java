package com.ankur.interview.practice.lists;

public class ReverseLinkedList {
  //#blind75
  public static LinkedList reverseLinkedList(LinkedList head) {
    // Write your code here.
    LinkedList curr = head;
    LinkedList prev = null;
    LinkedList next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
