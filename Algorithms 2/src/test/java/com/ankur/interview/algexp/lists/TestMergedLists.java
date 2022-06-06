package com.ankur.interview.algexp.lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMergedLists {

    @Test
    public void testMergeSortedList() {
        SinglyLinkedList head1 = new SinglyLinkedList(1);
        SinglyLinkedList head2 = new SinglyLinkedList(2);
        head1.next = new SinglyLinkedList(5);
        head1.next.next = new SinglyLinkedList(7);
        head2.next = new SinglyLinkedList(3);
        head2.next.next = new SinglyLinkedList(4);
        head2.next.next.next = new SinglyLinkedList(6);
        SinglyLinkedList result = MergeSortedLists.mergeSortedLists(head1, head2);
        Assertions.assertEquals(1,result.value);

    }
}
