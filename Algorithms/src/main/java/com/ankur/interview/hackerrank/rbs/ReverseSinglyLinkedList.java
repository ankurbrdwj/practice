package com.ankur.interview.hackerrank.rbs;

public class ReverseSinglyLinkedList {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6, 8, 9, 11, 13, 15};
        ListNode list = createSinglyList(a);
        printSinglyList(list);
        ListNode head = reverseSinglyListItr(list);
        printSinglyList(head);
    }

    private static ListNode reverseSinglyListItr(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static void printSinglyList(ListNode head) {
        ListNode ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    private static ListNode createSinglyList(int[] a) {
        ListNode head = null;
        for (int i = a.length - 1; i >= 0; i--) {
            ListNode temp = new ListNode(a[i]);
            temp.next = head;
            head = temp;
        }
        return head;
    }
}

class ListNode {
    ListNode next;
    int data;

    public ListNode(int i) {
        this.data = i;
        this.next = null;
    }

    public ListNode() {
        this.next = null;
    }
}