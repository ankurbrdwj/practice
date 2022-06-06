package com.ankur.interview.algexp.lists;

import org.junit.jupiter.api.Test;

public class RemoveDuplicatesTest {

    @Test
    public void testDuplicates() {
        RemoveDuplicateSorted rds = new RemoveDuplicateSorted();
        SinglyLinkedList sll = new SinglyLinkedList(1);
        sll.next = new SinglyLinkedList(2);
        sll.next.next = new SinglyLinkedList(2);
        sll.next.next.next = new SinglyLinkedList(3);
        sll.next.next.next.next = new SinglyLinkedList(3);
        sll.next.next.next.next.next = new SinglyLinkedList(4);
        sll.next.next.next.next.next.next = new SinglyLinkedList(4);

       // RemoveDuplicateSorted.removeDuplicatesSinglyList(sll);
    }
}
