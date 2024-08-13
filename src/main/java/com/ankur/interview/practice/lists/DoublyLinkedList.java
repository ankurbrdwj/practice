package com.ankur.interview.practice.lists;

public class DoublyLinkedList {
    public Node head;
    public Node tail;

    public void setHead(Node node) {
        // Write your code here.
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            return;
        }
        this.insertBefore(this.head, node);
    }

    public void setTail(Node node) {
        // Write your code here.
        if (this.tail == null) {
            this.setHead(node);
            return;
        }
        this.insertAfter(this.tail, node);
    }

    public void insertBefore(Node curr, Node nodeToInsert) {
        if (nodeToInsert == this.head && nodeToInsert == this.tail) {
            return;
        }
        this.remove(nodeToInsert);
        nodeToInsert.prev = curr.prev;
        nodeToInsert.next = curr;
        if (curr.prev == null) {
            this.head = nodeToInsert;
        } else {
            curr.prev.next = nodeToInsert;
        }
        curr.prev = nodeToInsert;
    }

    public void insertAfter(Node curr, Node nodeToInsert) {
        if (nodeToInsert == this.head && nodeToInsert == this.tail) {
            return;
        }
        this.remove(nodeToInsert);
        nodeToInsert.prev = curr;
        nodeToInsert.next = curr.next;
        if (curr.next == null) {
            this.tail = nodeToInsert;
        } else {
            curr.next.prev = nodeToInsert;
        }
        curr.next = nodeToInsert;
    }

    //nodeToInsert is in the list already
    public void insertAtPosition(int position, Node nodeToInsert) {
        // Write your code here.
        int currentPosition = 1;
        if (position == -1) {
            this.setHead(nodeToInsert);
            return;
        }
        Node curr = this.head;
        while (curr != null && currentPosition != position) {
            curr = curr.next;
            currentPosition++;
        }
        if (curr != null) {
            this.insertBefore(curr, nodeToInsert);
        } else {
            this.setTail(nodeToInsert);
        }
    }

    public void removeNodesWithValue(int value) {
        // Write your code here.
        Node curr = this.head;
        while (curr != null) {
            Node nodeToRemove = curr;
            curr = curr.next;
            if (nodeToRemove.value == value)
                this.remove(nodeToRemove);
        }
    }

    public void remove(Node node) {
        // Write your code here.
        if (this.head == node) {
            this.head = this.head.next;
        }
        if (this.tail == node) {
            this.tail = this.tail.prev;
        }
        this.removeNodeBindings(node);
    }

    private void removeNodeBindings(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = null;
    }

    public boolean containsNodeWithValue(int value) {
        // Write your code here.
        Node curr = this.head;
        while (curr != null && curr.value != value) {
            curr = curr.next;
        }
        return curr != null;
    }
    // Do not edit the class below.
    public static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}

