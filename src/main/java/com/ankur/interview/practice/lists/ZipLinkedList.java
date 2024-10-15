package com.ankur.interview.practice.lists;

public class ZipLinkedList {
  /*
  / we would need to find second half of linked list
  then reverse the second half of list
  and then merge the two half of linked list
   */

  public LinkedList zipLinkedList(
    LinkedList head) {
    if(head.next == null || head.next.next == null){
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
    while(fastPointer != null && fastPointer.next!=null){
      slowPointer=slowPointer.next;
      fastPointer=fastPointer.next.next;
    }
    LinkedList secondHalf= slowPointer.next;
    slowPointer.next=null;
    return secondHalf;
  }
/*
1.	Step 1: Save the next node (next = curr.next;)
	•	Before breaking the current link, next temporarily stores the node that curr points to, allowing you to continue traversing the list after reversing the link.
	2.	Step 2: Reverse the link (curr.next = prev;)
	•	The key operation is reversing the next pointer of the current node (curr). Instead of pointing to the next node in the original list, curr.next is now pointed to prev, which reverses the direction of the list.
	3.	Step 3: Move prev to curr (prev = curr;)
	•	The prev pointer is updated to the current node (curr). This prepares prev to be used in the next iteration when reversing the next link.
	4.	Step 4: Move curr to next (curr = next;)
	•	Finally, curr is updated to the next node (which was stored in next). This continues the traversal of the list.
 */
  private LinkedList reverseLinkedList(LinkedList head){
    LinkedList curr = head;
    LinkedList prev = null;
    LinkedList next;
    while (curr != null) {
      next = curr.next;  // Step 1: Save the next node
      curr.next = prev;  // Step 2: Reverse the link
      prev = curr;       // Step 3: Move prev to curr
      curr = next;       // Step 4: Move curr to next
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
