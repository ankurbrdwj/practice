package com.ankur.interview.practice.lists;

public class RemoveDuplicateSorted {
    public static SinglyLinkedList removeDuplicatesSinglyList(SinglyLinkedList root) {
        SinglyLinkedList current = root;
        while (current != null) {
            SinglyLinkedList next = current.next;
            while (next != null && next.value == current.value) {
                next = next.next;
            }
            current.next = next;
        }
    return current;
    }
}
