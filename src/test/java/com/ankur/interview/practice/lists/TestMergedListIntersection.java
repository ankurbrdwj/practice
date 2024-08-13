package com.ankur.interview.practice.lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMergedListIntersection {
  @Test
  void testIntersection() {
    var l1 = new MergedListIntersection.LinkedList(2);
    l1.next = new MergedListIntersection.LinkedList(3);
    l1.next.next = new MergedListIntersection.LinkedList(1);
    l1.next.next.next = new MergedListIntersection.LinkedList(4);
    var l2 = new MergedListIntersection.LinkedList(8);
    l2.next = new MergedListIntersection.LinkedList(7);
    l2.next.next = new MergedListIntersection.LinkedList(6);
    l2.next.next.next = l1.next.next;

    var expected = l1.next.next;
    var actual = new MergedListIntersection().intersection(l1, l2);
    Assertions.assertTrue(expected == actual);
  }

  @Test
  void testIntersectionDiff() {
    var l1 = new MergedListIntersection.LinkedList(2);
    l1.next = new MergedListIntersection.LinkedList(3);
    l1.next.next = new MergedListIntersection.LinkedList(1);
    l1.next.next.next = new MergedListIntersection.LinkedList(4);
    var l2 = new MergedListIntersection.LinkedList(8);
    l2.next = new MergedListIntersection.LinkedList(7);
    l2.next.next = new MergedListIntersection.LinkedList(6);
    l2.next.next.next = l1.next.next;

    var expected = l1.next.next;
    var actual = new MergedListIntersection().intersectionDiff(l1, l2);
    Assertions.assertTrue(expected == actual);
  }
}
