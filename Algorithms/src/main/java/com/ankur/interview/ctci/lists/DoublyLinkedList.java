package com.ankur.interview.ctci.lists;

public class DoublyLinkedList {
    public Node head;
    public Node tail;

    public void setHead(Node node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.insertBefore(this.head, node);
        }
    }

    public void setTail(Node node) {
        if (this.tail == null) {
            this.setHead(node);
        } else {
            this.insertAfter(this.tail, node);
        }
    }

    public void insertBefore(Node node, Node nodeToInsert) {
        this.remove(nodeToInsert);
        nodeToInsert.setPrev(node.getPrev());
        nodeToInsert.setNext(node);
        if (node.getPrev() == null) {
            this.head = nodeToInsert;
        } else {
            node.getPrev().setNext(nodeToInsert);
        }
        node.setPrev(nodeToInsert);
    }

    public void insertAfter(Node node, Node nodeToInsert) {
        this.remove(nodeToInsert);
        nodeToInsert.setPrev(node);
        nodeToInsert.setNext(node.getNext());
        if (node.getNext() == null) {
            this.tail = nodeToInsert;
        } else {
            node.getNext().setPrev(nodeToInsert);
        }
        node.setNext(nodeToInsert);
    }

    // New Node will be added , node within the list will be shuffled
    public void insertAtPosition(int position, Node nodeToInsert) {

        Node runner = this.head;
        if (position == 1) {
            this.setHead(nodeToInsert);
        } else {
            int currentPosition = 1;
            while (runner != null && currentPosition < position) {
                runner = runner.getNext();
                currentPosition++;
            }
            if (runner != null) {
                this.insertBefore(runner, nodeToInsert);
            } else {
                this.setTail(nodeToInsert);
            }
        }
    }

    // remove all nodes with data = value
    public void removeNodesWithValue(int value) {
        Node node = this.head;//runner
        while (node != null) {
            Node nodeToRemove = node; // another runner
            node = node.getNext();
            if (nodeToRemove.getData() == value) {
                this.remove(nodeToRemove);
            }
        }
    }

    // this is an existing node in list
    // that needs to be removed
    public void remove(Node node) {
        if (this.head == node) {
            this.head = this.head.getNext();
        }
        if (this.tail == node) {
            this.tail = this.tail.getPrev();
        }
        this.removeNodeBindings(node);
    }

    private void removeNodeBindings(Node node) {
        //node was head
        if (node.getPrev() != null) {
            node.getPrev().setNext(node.getNext());
        } //node is tail
        if (node.getNext() != null) {
            node.getNext().setPrev(node.getPrev());
        }
        node.setPrev(null);
        node.setNext(null);
    }

    public boolean containsNodeWithValue(int value) {
        Node node = this.head; //runner
        while (node != null && node.getData() != value) {
            node = node.getNext();
        }
        return node != null;
    }

    public Node nthFromLast(Node head, int n) {
        Node current = head;
        Node next = head;
        int count = 0;
        while (count < n) {
            if (next == null) {
                System.out.println(n + " is greater than the no "
                        + " of nodes in the list");
                return null;
            }
            next = next.getNext();
            count++;
        }
        while (next != null) {
            next = next.getNext();
            current = current.getNext();
        }
        return current;
    }

}