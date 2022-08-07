package com.ankur.interview.practice.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TestTreeFromPreOrderArray {


  // This file is initialized with a code version of this
// question's sample test case. Feel free to add, edit,
// or remove test cases in this file as you see fit!

  public List<Integer> getDfsOrder(TreeFromPreOrderArray.BST node, List<Integer> values) {
    values.add(node.value);
    if (node.left != null) {
      getDfsOrder(node.left, values);
    }
    if (node.right != null) {
      getDfsOrder(node.right, values);
    }
    return values;
  }

  @Test
  public void TestCase1() {
    List<Integer> preOrderTraversalValues =
      new ArrayList<Integer>(Arrays.asList(10, 4, 2, 1, 3, 17, 19, 18));
    TreeFromPreOrderArray.BST tree = new TreeFromPreOrderArray.BST(10);
    tree.left = new TreeFromPreOrderArray.BST(4);
    tree.left.left = new TreeFromPreOrderArray.BST(2);
    tree.left.left.left = new TreeFromPreOrderArray.BST(1);
    tree.left.right = new TreeFromPreOrderArray.BST(3);
    tree.right = new TreeFromPreOrderArray.BST(17);
    tree.right.right = new TreeFromPreOrderArray.BST(19);
    tree.right.right.left = new TreeFromPreOrderArray.BST(18);
    List<Integer> expected = getDfsOrder(tree, new ArrayList<Integer>());
    var actual = new TreeFromPreOrderArray().reconstructBst(preOrderTraversalValues);
    List<Integer> actualValues = getDfsOrder(actual, new ArrayList<Integer>());
    Assertions.assertEquals(expected, actualValues);
  }
}

