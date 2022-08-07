package com.ankur.interview.practice.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestKthLargestNode {
  // This file is initialized with a code version of this
// question's sample test case. Feel free to add, edit,
// or remove test cases in this file as you see fit!
    @Test
    public void TestCase1() {
      FindKthLargestNode.BST root = new FindKthLargestNode.BST(15);
      root.left = new FindKthLargestNode.BST(5);
      root.left.left = new FindKthLargestNode.BST(2);
      root.left.left.left = new FindKthLargestNode.BST(1);
      root.left.left.right = new FindKthLargestNode.BST(3);
      root.left.right = new FindKthLargestNode.BST(5);
      root.right = new FindKthLargestNode.BST(20);
      root.right.left = new FindKthLargestNode.BST(17);
      root.right.right = new FindKthLargestNode.BST(22);
      int k = 3;
      int expected = 17;
      var actual = new FindKthLargestNode().findKthLargestValueInBst(root, k);
      Assertions.assertEquals(expected, actual);
    }
  }

