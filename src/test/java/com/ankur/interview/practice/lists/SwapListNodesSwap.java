package com.ankur.interview.practice.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SwapListNodesSwap {

    public SwapListNodes.LinkedList addMany(
      SwapListNodes.LinkedList ll, List<Integer> values
    ) {
      SwapListNodes.LinkedList current = ll;
      while (current.next != null) {
        current = current.next;
      }
      for (int value : values) {
        current.next = new SwapListNodes.LinkedList(value);
        current = current.next;
      }
      return ll;
    }

    public List<Integer> getNodesInArray(SwapListNodes.LinkedList ll) {
      List<Integer> nodes = new ArrayList<Integer>();
      SwapListNodes.LinkedList current = ll;
      while (current != null) {
        nodes.add(current.value);
        current = current.next;
      }
      return nodes;
    }

    @Test
    public void TestCase1() {
      SwapListNodes.LinkedList linkedList = new SwapListNodes.LinkedList(0);
      addMany(linkedList, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)));
      List<Integer> expectedNodes =
        new ArrayList<Integer>(Arrays.asList(1, 0, 3, 2, 5, 4));
      var actual = new SwapListNodes().nodeSwap(linkedList);
      Assertions.assertTrue(getNodesInArray(actual).equals(expectedNodes));
    }
  }
