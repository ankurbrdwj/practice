package com.ankur.interview.practice.lists;

public class Duplicates {

    // list is sorted
    public static SinglyLinkedList removeDuplicates(SinglyLinkedList root) {
        SinglyLinkedList curr = root;
        while (curr != null) {
            SinglyLinkedList next = curr.next;
            while (next != null && next.value == curr.value) {
                next = next.next;
            }
            curr.next = next;// copy the entire list in new pointer curr
            curr = next;
        }
        return curr;
    }
}
