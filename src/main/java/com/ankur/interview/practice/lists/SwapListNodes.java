package com.ankur.interview.practice.lists;

public class SwapListNodes {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList nodeSwap(LinkedList head) {
    // Write your code here.
    LinkedList tempNode = new LinkedList(0);
    tempNode.next = head;

    LinkedList prev = tempNode;
    while (prev.next != null && prev.next.next != null) {
      LinkedList first = prev.next;
      LinkedList second = prev.next.next;

      //swap
      first.next = second.next;
      second.next = first;
      prev.next = second;

      prev = first; // move to next two

    }
    return tempNode.next;
  }
}
