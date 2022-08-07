package com.ankur.interview.practice.trees;
import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestHeightBalanced {
  // This file is initialized with a code version of this
// question's sample test case. Feel free to add, edit,
// or remove test cases in this file as you see fit!

    @Test
    public void TestCase1() {
      HeightBalanced.BinaryTree root = new HeightBalanced.BinaryTree(1);
      root = new HeightBalanced.BinaryTree(1);
      root.left = new HeightBalanced.BinaryTree(2);
      root.right = new HeightBalanced.BinaryTree(3);
      root.left.left = new HeightBalanced.BinaryTree(4);
      root.left.right = new HeightBalanced.BinaryTree(5);
      root.right.right = new HeightBalanced.BinaryTree(6);
      root.left.right.left = new HeightBalanced.BinaryTree(7);
      root.left.right.right = new HeightBalanced.BinaryTree(8);
      boolean expected = true;
      var actual = new HeightBalanced().heightBalancedBinaryTree(root);
      Assertions.assertTrue(expected == actual);
    }
  }


