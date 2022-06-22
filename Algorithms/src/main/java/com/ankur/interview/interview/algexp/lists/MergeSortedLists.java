package com.ankur.interview.algexp.lists;

public class MergeSortedLists {

    public static SinglyLinkedList mergeSortedLists(SinglyLinkedList head1, SinglyLinkedList head2) {
        SinglyLinkedList runner1 = head1;
        SinglyLinkedList runner2 = head2;
        SinglyLinkedList prev = null;
   /*     if (head1.value > head2.value) {
            head1 = head2;
        }*/
        while (runner1 != null && runner2 != null) {
            if (runner1.value < runner2.value) {
                if (prev == null) {
                    prev = runner1;
                } else {
                    prev.next = runner1;
                }
                runner1 = runner1.next;
            } else {
                if (prev == null) {
                    prev = runner2;
                } else {
                    prev.next = runner2;
                }
                runner2 = runner2.next;
            }
        }
            if (runner2 != null) {
                prev.next = runner2;
                runner2 = runner2.next;
            }
            if (runner1 != null) {
                prev.next = runner1;
                runner1 = runner1.next;
            }
        return head1;
    }
}
