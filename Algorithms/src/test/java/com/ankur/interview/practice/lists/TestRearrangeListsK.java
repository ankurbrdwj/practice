package com.ankur.interview.practice.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRearrangeListsK {
  @Test
  public void TestCase1() {
    var head = new SinglyLinkedList(3);
    head.next = new SinglyLinkedList(0);
    head.next.next = new SinglyLinkedList(5);
    head.next.next.next = new SinglyLinkedList(2);
    head.next.next.next.next = new SinglyLinkedList(1);
    head.next.next.next.next.next = new SinglyLinkedList(4);
    var result = RearrangeLinkedList.arrangeListAroundK(head, 3);
    var array = this.linkedListToArray(result);

    var expected = Arrays.asList(new Integer[] {0, 2, 1, 3, 5, 4});
    Assertions.assertTrue(expected.equals(array));
  }

  public List<Integer> linkedListToArray(SinglyLinkedList head) {
    var array = new ArrayList<Integer>();
    var current = head;
    while (current != null) {
      array.add(current.value);
      current = current.next;
    }
    return array;
  }
}

