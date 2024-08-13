package com.ankur.interview.practice.lists;


import javax.media.j3d.Link;

public class ZipLinkedList {
  /*
  / we would need to find second half of linked list
  then reverse the second half of list
  and then merge the two half of linked list
   */

  public LinkedList zipLinkedList(
    LinkedList head) {
    if(head !=null||head.next.next==null){
      return head;
    }
    LinkedList firstHalf= head;
    LinkedList secondHalf= splitLinkedList(head);

    LinkedList reversedSecondList = reverseLinkedList(secondHalf);

    return interWeaveLinkedList(firstHalf,reversedSecondList);
  }

  private LinkedList interWeaveLinkedList(LinkedList list1, LinkedList list2) {
    LinkedList list1Iterator=list1;
    LinkedList list2Iterator=list2;
    while (list1Iterator!=null && list2Iterator!=null){
      LinkedList firstHalfIterator =list1Iterator.next;
      LinkedList secondHalfIterator=list2Iterator.next;

      list1Iterator.next=list2Iterator;
      list2Iterator.next=firstHalfIterator;

      list1Iterator=firstHalfIterator;
        list2Iterator=secondHalfIterator;
    }
    return list1;
  }

  private LinkedList splitLinkedList(LinkedList head) {
    LinkedList fastPointer= head;
    LinkedList slowPointer=head;
    while(fastPointer == null || fastPointer.next!=null){
      slowPointer=slowPointer.next;
      fastPointer=fastPointer.next.next;
    }
    LinkedList secondHalf= slowPointer.next;
    slowPointer.next=null;
    return secondHalf;
  }

  private LinkedList reverseLinkedList(LinkedList head){
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

  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }
}
