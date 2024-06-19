package com.ankur.interview.practice.lists;

public class RearrangeLinkedList {
  //blind75
  /*
  / rearrange list around number k where numbers less the k are before k and more then k after k
   */

  static SinglyLinkedList arrangeListAroundK(SinglyLinkedList listHead, int k) {
    // solution is to have 3 lists smaller equals and larger and build them in one loop
    SinglyLinkedList smallListHead = null;
    SinglyLinkedList smallListTail = null;
    SinglyLinkedList equalListHead = null;
    SinglyLinkedList equalListTail = null;
    SinglyLinkedList greaterListHead = null;
    SinglyLinkedList greaterListTail = null;
    SinglyLinkedList current = listHead ;
    while (current != null) {
      if (current.value < k) {
        SinglyLinkedListPair smaller = buildSmallerList(smallListHead, smallListTail, current);
        smallListHead=smaller.head;
        smallListTail=smaller.tail;
      } else if (current.value > k) {
        SinglyLinkedListPair greaterPair= buildSmallerList(greaterListHead, greaterListTail, current);
        greaterListHead=greaterPair.head;
        greaterListTail=greaterPair.tail;
      } else {
        SinglyLinkedListPair equalPair=buildSmallerList(equalListHead, equalListTail, current);
        equalListHead=equalPair.head;
        equalListTail=equalPair.tail;
      }
      SinglyLinkedList prev = current;
      current = current.next;
      prev.next = null;
    }
    SinglyLinkedListPair firstList= connectSmallLists(smallListHead, smallListTail, equalListHead, equalListTail);
    SinglyLinkedListPair finalList= connectSmallLists(firstList.head, firstList.tail, greaterListHead, greaterListTail);
    return finalList.head;
  }

  private static SinglyLinkedListPair connectSmallLists(SinglyLinkedList headOne,
                                                        SinglyLinkedList tailOne,
                                                        SinglyLinkedList headTwo,
                                                        SinglyLinkedList tailTwo) {
    SinglyLinkedList newHead = headOne == null ? headTwo:headOne ;
    SinglyLinkedList newTail = tailTwo == null ? tailOne:tailTwo ;
    if (tailOne != null) {
      tailOne.next = headTwo;
    }
    return new SinglyLinkedListPair(newHead,newTail);
  }

  private static SinglyLinkedListPair buildSmallerList(SinglyLinkedList head, SinglyLinkedList tail,
                                                       SinglyLinkedList current) {
    SinglyLinkedList newHead = head;
    SinglyLinkedList newTail = current;

    if (newHead == null) {
      newHead = current;
    }
    if (tail != null) {
      tail.next = current;
    }
    return new SinglyLinkedListPair(newHead, newTail);
  }
}
