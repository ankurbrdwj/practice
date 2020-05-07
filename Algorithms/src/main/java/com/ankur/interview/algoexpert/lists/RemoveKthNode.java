package com.ankur.interview.algoexpert.lists;

public class RemoveKthNode {

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList current = head;
        LinkedList next = head;
        int count = 0;
        LinkedList prev = next;
        while (count < k) {
            if (next == null) {
                return ;
            }
            next = next.next;
            count++;
        }

        if (next != null) {
            while (next != null) {
                next = next.next;
                prev = current;
                current = current.next;
            }
            // current is k
            if (current.next != null) {
                prev.next = current.next;
                current = prev;
            }else{// current is last element
                prev.next = null;
                current= prev;
            }
        } else {
            // k == n  && current is still head
            current = current.next;
            head = head.next;
        }
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}


