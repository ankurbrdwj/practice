package com.ankur.interview.practice.trees.binarysearchtrees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFindAndSumBSTs {
    @Test
    public void TestCase1() {
      FindAndSumBST.BinaryTree root = new FindAndSumBST.BinaryTree(8);
      root.left = new FindAndSumBST.BinaryTree(2);
      root.left.left = new FindAndSumBST.BinaryTree(1);
      root.left.right = new FindAndSumBST.BinaryTree(10);
      root.right = new FindAndSumBST.BinaryTree(9);
      root.right.right = new FindAndSumBST.BinaryTree(5);
      int expected = 13;
      int actual = new FindAndSumBST().findAndSumBsts(root);
      Assertions.assertTrue(expected == actual);
    }
  }


