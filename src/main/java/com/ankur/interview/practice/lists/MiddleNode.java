package com.ankur.interview.practice.lists;

public class MiddleNode {
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public static LinkedList middleNode(LinkedList linkedList) {
    // Write your code here.
    LinkedList slowPointer=linkedList;
    LinkedList fastPointer=linkedList;
    while(fastPointer!=null&& fastPointer.next!=null){
      slowPointer=slowPointer.next;
      fastPointer=fastPointer.next.next;
    }
    return slowPointer;
  }
}
