package com.ankur.interview.practice.trees.binarytrees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTreeTraversal {

    @Test
    public void TestCase1() {
      CompareTreeTraversals.BinaryTree tree1 = new CompareTreeTraversals.BinaryTree(1);
      tree1.left = new CompareTreeTraversals.BinaryTree(2);
      tree1.right = new CompareTreeTraversals.BinaryTree(3);
      tree1.left.left = new CompareTreeTraversals.BinaryTree(4);
      tree1.left.right = new CompareTreeTraversals.BinaryTree(5);
      tree1.right.right = new CompareTreeTraversals.BinaryTree(6);
      tree1.left.right.left = new CompareTreeTraversals.BinaryTree(7);
      tree1.left.right.right = new CompareTreeTraversals.BinaryTree(8);

      CompareTreeTraversals.BinaryTree tree2 = new CompareTreeTraversals.BinaryTree(1);
      tree2.left = new CompareTreeTraversals.BinaryTree(2);
      tree2.right = new CompareTreeTraversals.BinaryTree(3);
      tree2.left.left = new CompareTreeTraversals.BinaryTree(4);
      tree2.left.right = new CompareTreeTraversals.BinaryTree(7);
      tree2.right.right = new CompareTreeTraversals.BinaryTree(5);
      tree2.right.right.left = new CompareTreeTraversals.BinaryTree(8);
      tree2.right.right.right = new CompareTreeTraversals.BinaryTree(6);

      var expected = true;
      var actual = new CompareTreeTraversals().stackLeafTraversal(tree1, tree2);
      Assertions.assertTrue(expected == actual);
    }

  @Test
  public void TestCase2() {
    CompareTreeTraversals.BinaryTree tree1 = new CompareTreeTraversals.BinaryTree(1);
    tree1.left = new CompareTreeTraversals.BinaryTree(2);
    tree1.right = new CompareTreeTraversals.BinaryTree(3);
    tree1.left.left = new CompareTreeTraversals.BinaryTree(4);
    tree1.left.right = new CompareTreeTraversals.BinaryTree(5);
    tree1.right.right = new CompareTreeTraversals.BinaryTree(6);
    tree1.left.right.left = new CompareTreeTraversals.BinaryTree(7);
    tree1.left.right.right = new CompareTreeTraversals.BinaryTree(8);

    CompareTreeTraversals.BinaryTree tree2 = new CompareTreeTraversals.BinaryTree(1);
    tree2.left = new CompareTreeTraversals.BinaryTree(2);
    tree2.right = new CompareTreeTraversals.BinaryTree(3);
    tree2.left.left = new CompareTreeTraversals.BinaryTree(4);
    tree2.left.right = new CompareTreeTraversals.BinaryTree(7);
    tree2.right.right = new CompareTreeTraversals.BinaryTree(5);
    tree2.right.right.left = new CompareTreeTraversals.BinaryTree(8);
    tree2.right.right.right = new CompareTreeTraversals.BinaryTree(6);

    var expected = true;
    var actual = new CompareTreeTraversals().compareLeafTraversal(tree1, tree2);
    Assertions.assertTrue(expected == actual);
  }
  }

