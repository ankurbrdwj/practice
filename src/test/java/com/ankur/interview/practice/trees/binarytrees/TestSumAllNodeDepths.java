package com.ankur.interview.practice.trees.binarytrees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSumAllNodeDepths {

    @Test
    public void TestCase1() {
      var root = new SumOfAllNodeDepths.BinaryTree(1);
      root.left = new SumOfAllNodeDepths.BinaryTree(2);
      root.left.left = new SumOfAllNodeDepths.BinaryTree(4);
      root.left.left.left = new SumOfAllNodeDepths.BinaryTree(8);
      root.left.left.right = new SumOfAllNodeDepths.BinaryTree(9);
      root.left.right = new SumOfAllNodeDepths.BinaryTree(5);
      root.right = new SumOfAllNodeDepths.BinaryTree(3);
      root.right.left = new SumOfAllNodeDepths.BinaryTree(6);
      root.right.right = new SumOfAllNodeDepths.BinaryTree(7);
      int actual = SumOfAllNodeDepths.getAllSubtreeDepthsRecursive(root);
      Assertions.assertEquals(26, actual);
    }
  }

