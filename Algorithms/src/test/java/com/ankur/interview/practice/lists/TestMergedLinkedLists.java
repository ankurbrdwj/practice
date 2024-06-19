package com.ankur.interview.practice.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMergedLinkedLists {
  MergeSortedLinkedLists.LinkedList addMany(
    MergeSortedLinkedLists.LinkedList ll, List<Integer> values
  ) {
    MergeSortedLinkedLists.LinkedList current = ll;
    while (current.next != null) {
      current = current.next;
    }
    for (int value : values) {
      current.next = new MergeSortedLinkedLists.LinkedList(value);
      current = current.next;
    }
    return ll;
  }

  public List<Integer> getNodesInArray(MergeSortedLinkedLists.LinkedList ll) {
    List<Integer> nodes = new ArrayList<Integer>();
    MergeSortedLinkedLists.LinkedList current = ll;
    while (current != null) {
      nodes.add(current.value);
      current = current.next;
    }
    return nodes;
  }

  @Test
  public void testMergeLinkedLists() {
    MergeSortedLinkedLists.LinkedList list1 = new MergeSortedLinkedLists.LinkedList(1);
    addMany(list1, new ArrayList<Integer>(Arrays.asList(2, 4, 6)));
    MergeSortedLinkedLists.LinkedList list2 = new MergeSortedLinkedLists.LinkedList(3);
    addMany(list2, new ArrayList<Integer>(Arrays.asList(5, 7, 8, 9, 10)));
    MergeSortedLinkedLists.LinkedList output =
      MergeSortedLinkedLists.mergeLinkedLists(list1, list2);
    MergeSortedLinkedLists.printList(output, "output");
    List<Integer> expectedNodes =
      new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    Assertions.assertTrue(getNodesInArray(output).equals(expectedNodes));
  }
}
