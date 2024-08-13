package com.ankur.interview.practice.lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFindLoop {
  @Test
  public void TestCase1() {
    TestLinkedList test = new TestLinkedList(0);
    test.addMany(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
    test.getNthNode(10).next = test.getNthNode(5);
    Assertions.assertTrue(DetectLoop.findLoop(test) == test.getNthNode(5));
  }

  class TestLinkedList extends DetectLoop.LinkedList {
    public TestLinkedList(int value) {
      super(value);
    }

    public void addMany(int[] values) {
      DetectLoop.LinkedList current = this;
      while (current.next != null) {
        current = current.next;
      }
      for (int value : values) {
        current.next = new DetectLoop.LinkedList(value);
        current = current.next;
      }
    }

    public DetectLoop.LinkedList getNthNode(int n) {
      int counter = 1;
      DetectLoop.LinkedList current = this;
      while (counter < n) {
        current = current.next;
        counter++;
      }
      return current;
    }
  }
}
