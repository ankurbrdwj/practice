package com.ankur.interview.practice.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestZipLinkedList {
   @Test
    public void TestCase1() {
      TestLinkedList head = new TestLinkedList(1);
      head.addMany(new int[] {2, 3, 4, 5, 6});
      List<Integer> expected =
        new ArrayList<Integer>(Arrays.asList(1, 6, 2, 5, 3, 4));
      var actual = getNodesInArray(new ZipLinkedList().zipLinkedList(head));
      Assertions.assertTrue(expected.equals(actual));
    }

    public List<Integer> getNodesInArray(ZipLinkedList.LinkedList linkedList) {
      var nodes = new ArrayList<Integer>();
      var current = linkedList;
      while (current != null) {
        nodes.add(current.value);
        current = current.next;
      }
      return nodes;
    }

    class TestLinkedList extends ZipLinkedList.LinkedList {
      public TestLinkedList(int value) {
        super(value);
      }

      public void addMany(int[] values) {
        ZipLinkedList.LinkedList current = this;
        while (current.next != null) {
          current = current.next;
        }
        for (int value : values) {
          current.next = new ZipLinkedList.LinkedList(value);
          current = current.next;
        }
      }
    }
  }
