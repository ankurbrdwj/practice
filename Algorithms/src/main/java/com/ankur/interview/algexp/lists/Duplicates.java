package com.ankur.interview.algexp.lists;

public class Duplicates {

    // list is sorted
    public static SinglyLinkedList removeDuplicates(SinglyLinkedList root) {
        SinglyLinkedList curr = root;
        while (curr != null) {
            SinglyLinkedList next = curr.next;
            while (next != null && next.value == curr.value) {
                next = next.next;
            }
            curr.next = next;
            curr = next;
        }
        return null;
    }
}
