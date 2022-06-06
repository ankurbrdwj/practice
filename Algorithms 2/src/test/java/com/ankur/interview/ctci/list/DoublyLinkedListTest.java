package com.ankur.interview.ctci.list;

import com.ankur.interview.algexp.lists.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class DoublyLinkedListTest {
    private void expectEmpty(LinkedList.DoublyLinkedList linkedList) {
        Assertions.assertTrue(linkedList.head == null);
        Assertions.assertTrue(linkedList.tail == null);
    }

    private void expectHeadTail(
            LinkedList.DoublyLinkedList linkedList, LinkedList.Node head, LinkedList.Node tail) {
        Assertions.assertTrue(linkedList.head == head);
        Assertions.assertTrue(linkedList.tail == tail);
    }

    private void expectSingleNode(LinkedList.DoublyLinkedList linkedList, LinkedList.Node node) {
        Assertions.assertTrue(linkedList.head == node);
        Assertions.assertTrue(linkedList.tail == node);
    }

    private List<Integer> getNodeValuesHeadToTail(LinkedList.DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<Integer>();
        LinkedList.Node node = linkedList.head;
        while (node != null) {
            values.add(node.value);
            node = node.next;
        }
        return values;
    }

    private List<Integer> getNodeValuesTailToHead(LinkedList.DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<Integer>();
        LinkedList.Node node = linkedList.tail;
        while (node != null) {
            values.add(node.value);
            node = node.prev;
        }
        return values;
    }

    private void removeNodes(LinkedList.DoublyLinkedList linkedList, List<LinkedList.Node> nodes) {
        for (LinkedList.Node node : nodes) {
            linkedList.remove(node);
        }
    }

    private boolean compare(List<Integer> array1, int[] array2) {
        if (array1.size() != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.size(); i++) {
            if (array1.get(i) != array2[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void TestCase1() {
        LinkedList.DoublyLinkedList linkedList = new LinkedList.DoublyLinkedList();
        LinkedList.Node node = new LinkedList.Node(1);

        linkedList.setHead(node);
        expectSingleNode(linkedList, node);
        linkedList.remove(node);
        expectEmpty(linkedList);
        linkedList.setTail(node);
        expectSingleNode(linkedList, node);
        linkedList.removeNodesWithValue(1);
        expectEmpty(linkedList);
        linkedList.insertAtPosition(1, node);
        expectSingleNode(linkedList, node);
    }

    @Test
    public void TestCase2() {
        LinkedList.DoublyLinkedList linkedList = new LinkedList.DoublyLinkedList();
        LinkedList.Node first = new LinkedList.Node(1);
        LinkedList.Node second = new LinkedList.Node(2);
        List<LinkedList.Node> nodes = new ArrayList<LinkedList.Node>();
        nodes.add(first);
        nodes.add(second);

        linkedList.setHead(first);
        linkedList.setTail(second);
        expectHeadTail(linkedList, first, second);
        removeNodes(linkedList, nodes);
        expectEmpty(linkedList);
        linkedList.setHead(first);
        linkedList.insertAfter(first, second);
        expectHeadTail(linkedList, first, second);
        removeNodes(linkedList, nodes);
        linkedList.setHead(first);
        linkedList.insertBefore(first, second);
        expectHeadTail(linkedList, second, first);
        removeNodes(linkedList, nodes);
        linkedList.insertAtPosition(1, first);
        linkedList.insertAtPosition(2, second);
        expectHeadTail(linkedList, first, second);
        removeNodes(linkedList, nodes);
        linkedList.insertAtPosition(2, first);
        linkedList.insertAtPosition(1, second);
        expectHeadTail(linkedList, second, first);
    }

    @Test
    public void TestCase3() {
        LinkedList.DoublyLinkedList linkedList = new LinkedList.DoublyLinkedList();
        LinkedList.Node first = new LinkedList.Node(1);
        LinkedList.Node second = new LinkedList.Node(2);
        LinkedList.Node third = new LinkedList.Node(3);
        LinkedList.Node fourth = new LinkedList.Node(4);

        linkedList.setHead(first);
        Assertions.assertTrue(linkedList.containsNodeWithValue(1) == true);
        linkedList.insertAfter(first, second);
        Assertions.assertTrue(linkedList.containsNodeWithValue(2) == true);
        linkedList.insertAfter(second, third);
        Assertions.assertTrue(linkedList.containsNodeWithValue(3) == true);
        linkedList.insertAfter(third, fourth);
        Assertions.assertTrue(linkedList.containsNodeWithValue(4) == true);
        linkedList.removeNodesWithValue(3);
        Assertions.assertTrue(linkedList.containsNodeWithValue(3) == false);
        linkedList.remove(first);
        Assertions.assertTrue(linkedList.containsNodeWithValue(1) == false);
        linkedList.removeNodesWithValue(4);
        Assertions.assertTrue(linkedList.containsNodeWithValue(4) == false);
        linkedList.remove(second);
        Assertions.assertTrue(linkedList.containsNodeWithValue(2) == false);
    }

    @Test
    public void TestCase4() {
        LinkedList.DoublyLinkedList linkedList = new LinkedList.DoublyLinkedList();
        LinkedList.Node first = new LinkedList.Node(1);
        LinkedList.Node second = new LinkedList.Node(2);
        LinkedList.Node third = new LinkedList.Node(3);
        LinkedList.Node fourth = new LinkedList.Node(3);
        LinkedList.Node fifth = new LinkedList.Node(3);
        LinkedList.Node sixth = new LinkedList.Node(6);
        LinkedList.Node seventh = new LinkedList.Node(7);

        linkedList.setHead(first);
        linkedList.insertAfter(first, second);
        linkedList.insertAfter(second, third);
        linkedList.insertAfter(third, fourth);
        linkedList.insertAfter(fourth, fifth);
        linkedList.insertAfter(fifth, sixth);
        linkedList.insertAfter(sixth, seventh);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{1, 2, 3, 3, 3, 6, 7}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{7, 6, 3, 3, 3, 2, 1}));
        expectHeadTail(linkedList, first, seventh);
        linkedList.remove(second);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{1, 3, 3, 3, 6, 7}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{7, 6, 3, 3, 3, 1}));
        expectHeadTail(linkedList, first, seventh);
        linkedList.removeNodesWithValue(1);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{3, 3, 3, 6, 7}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{7, 6, 3, 3, 3}));
        expectHeadTail(linkedList, third, seventh);
        linkedList.removeNodesWithValue(3);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{6, 7}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{7, 6}));
        expectHeadTail(linkedList, sixth, seventh);
        linkedList.removeNodesWithValue(7);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{6}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{6}));
        expectHeadTail(linkedList, sixth, sixth);
    }

    @Test
    public void TestCase5() {
        LinkedList.DoublyLinkedList linkedList = new LinkedList.DoublyLinkedList();
        LinkedList.Node first = new LinkedList.Node(1);
        LinkedList.Node second = new LinkedList.Node(2);
        LinkedList.Node third = new LinkedList.Node(3);
        LinkedList.Node fourth = new LinkedList.Node(4);
        LinkedList.Node fifth = new LinkedList.Node(5);
        LinkedList.Node sixth = new LinkedList.Node(6);
        LinkedList.Node seventh = new LinkedList.Node(7);

        linkedList.setHead(first);
        linkedList.insertAfter(first, second);
        linkedList.insertAfter(second, third);
        linkedList.insertAfter(third, fourth);
        linkedList.insertAfter(fourth, fifth);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{1, 2, 3, 4, 5}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{5, 4, 3, 2, 1}));
        expectHeadTail(linkedList, first, fifth);
        linkedList.insertAfter(third, fifth);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{1, 2, 3, 5, 4}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{4, 5, 3, 2, 1}));
        expectHeadTail(linkedList, first, fourth);
        linkedList.insertAfter(third, first);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{2, 3, 1, 5, 4}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{4, 5, 1, 3, 2}));
        expectHeadTail(linkedList, second, fourth);
        linkedList.insertAfter(fifth, second);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{3, 1, 5, 2, 4}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{4, 2, 5, 1, 3}));
        expectHeadTail(linkedList, third, fourth);
        linkedList.insertAfter(second, first);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{3, 5, 2, 1, 4}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{4, 1, 2, 5, 3}));
        expectHeadTail(linkedList, third, fourth);
        linkedList.insertAfter(fourth, sixth);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{3, 5, 2, 1, 4, 6}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{6, 4, 1, 2, 5, 3}));
        expectHeadTail(linkedList, third, sixth);
        linkedList.insertAfter(second, seventh);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{3, 5, 2, 7, 1, 4, 6}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{6, 4, 1, 7, 2, 5, 3}));
        expectHeadTail(linkedList, third, sixth);
    }

    @Test
    public void TestCase6() {
        LinkedList.DoublyLinkedList linkedList = new LinkedList.DoublyLinkedList();
        LinkedList.Node first = new LinkedList.Node(1);
        LinkedList.Node second = new LinkedList.Node(2);
        LinkedList.Node third = new LinkedList.Node(3);
        LinkedList.Node fourth = new LinkedList.Node(4);
        LinkedList.Node fifth = new LinkedList.Node(5);
        LinkedList.Node sixth = new LinkedList.Node(6);
        LinkedList.Node seventh = new LinkedList.Node(7);

        linkedList.setHead(first);
        linkedList.insertBefore(first, second);
        linkedList.insertBefore(second, third);
        linkedList.insertBefore(third, fourth);
        linkedList.insertBefore(fourth, fifth);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{5, 4, 3, 2, 1}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{1, 2, 3, 4, 5}));
        expectHeadTail(linkedList, fifth, first);
        linkedList.insertBefore(third, first);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{5, 4, 1, 3, 2}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{2, 3, 1, 4, 5}));
        expectHeadTail(linkedList, fifth, second);
        linkedList.insertBefore(fifth, second);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{2, 5, 4, 1, 3}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{3, 1, 4, 5, 2}));
        expectHeadTail(linkedList, second, third);
        linkedList.insertBefore(fifth, fourth);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{2, 4, 5, 1, 3}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{3, 1, 5, 4, 2}));
        expectHeadTail(linkedList, second, third);
        linkedList.insertBefore(second, sixth);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{6, 2, 4, 5, 1, 3}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{3, 1, 5, 4, 2, 6}));
        expectHeadTail(linkedList, sixth, third);
        linkedList.insertBefore(first, seventh);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{6, 2, 4, 5, 7, 1, 3}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{3, 1, 7, 5, 4, 2, 6}));
        expectHeadTail(linkedList, sixth, third);
    }

    @Test
    public void TestCase7() {
        LinkedList.DoublyLinkedList linkedList = new LinkedList.DoublyLinkedList();
        LinkedList.Node first = new LinkedList.Node(1);
        LinkedList.Node second = new LinkedList.Node(2);
        LinkedList.Node third = new LinkedList.Node(3);
        LinkedList.Node fourth = new LinkedList.Node(4);
        LinkedList.Node fifth = new LinkedList.Node(5);
        LinkedList.Node sixth = new LinkedList.Node(6);
        LinkedList.Node seventh = new LinkedList.Node(7);

        linkedList.setHead(first);
        linkedList.insertAtPosition(1, second);
        linkedList.insertAtPosition(1, third);
        linkedList.insertAtPosition(1, fourth);
        linkedList.insertAtPosition(1, fifth);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{5, 4, 3, 2, 1}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{1, 2, 3, 4, 5}));
        expectHeadTail(linkedList, fifth, first);
        linkedList.insertAtPosition(2, first);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{5, 1, 4, 3, 2}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{2, 3, 4, 1, 5}));
        expectHeadTail(linkedList, fifth, second);
        linkedList.insertAtPosition(1, second);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{2, 5, 1, 4, 3}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{3, 4, 1, 5, 2}));
        expectHeadTail(linkedList, second, third);
        linkedList.insertAtPosition(2, fourth);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{2, 4, 5, 1, 3}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{3, 1, 5, 4, 2}));
        expectHeadTail(linkedList, second, third);
        linkedList.insertAtPosition(1, sixth);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{6, 2, 4, 5, 1, 3}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{3, 1, 5, 4, 2, 6}));
        expectHeadTail(linkedList, sixth, third);
        linkedList.insertAtPosition(5, seventh);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{6, 2, 4, 5, 7, 1, 3}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{3, 1, 7, 5, 4, 2, 6}));
        expectHeadTail(linkedList, sixth, third);
        linkedList.insertAtPosition(8, fourth);
        Assertions.assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{6, 2, 5, 7, 1, 3, 4}));
        Assertions.assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{4, 3, 1, 7, 5, 2, 6}));
        expectHeadTail(linkedList, sixth, fourth);
    }
}

