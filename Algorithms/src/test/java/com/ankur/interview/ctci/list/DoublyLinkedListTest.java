package com.ankur.interview.ctci.list;

import com.ankur.interview.ctci.lists.DoublyLinkedList;
import com.ankur.interview.ctci.lists.Node;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DoublyLinkedListTest {

    private static DoublyLinkedList list = new DoublyLinkedList();

    @BeforeAll
    public static void setUp() {
        for (int i = 1; i < 11; i++) {
     /*       Node node = new Node(i);
			runner.setNext(node);
			node.setPrev(runner);
			runner = runner.getNext();
     */
            list.insertAtPosition(i, new Node(i));
        }
    }

    @Test
    void testContainsNodeWithValue() {
        assertTrue(list.containsNodeWithValue(4));
    }

    @Test
    public void testRemoveNode() {
        list.remove(list.head.getNext());
        list.remove(list.head);
        assertFalse(list.containsNodeWithValue(1));
    }

    @Test
    public void testRemoveNodeWithValue() {
        list.removeNodesWithValue(1);
        assertFalse(list.containsNodeWithValue(1));
    }

    @Test
    public void testInsertBefore() {
        list.insertBefore(list.head, list.head.getNext().getNext().getNext());
        assertTrue(list.head.getData() == 3);
    }

    @Test
    public void testInsertAfter() {
        list.insertAfter(list.tail, list.tail.getPrev());
        assertTrue(list.tail.getData() == 9);
    }

    @Test
    public void testInsertAtPosition() {
        list.insertAtPosition(1, list.head.getNext());
        list.insertAtPosition(1, list.head.getNext());
        assertTrue(list.head.getData() == 2);
    }

    @Test
    public void testNthFromLast() {
        Node node = list.nthFromLast(list.head, 2);
        assertTrue(node.getData() == 9);
    }

}
