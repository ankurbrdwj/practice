package com.ankur.interview.practice.trees.binarytrees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSymmetry {
  @Test
  void testTreeSymmetry(){

    TreeSymmetry.BinaryTree tree = new TreeSymmetry.BinaryTree(10);
    tree.left = new TreeSymmetry.BinaryTree(5);
    tree.right = new TreeSymmetry.BinaryTree(5);
    tree.left.left = new TreeSymmetry.BinaryTree(7);
    tree.left.right = new TreeSymmetry.BinaryTree(9);
    tree.right.left = new TreeSymmetry.BinaryTree(9);
    tree.right.right = new TreeSymmetry.BinaryTree(7);
    var expected = true;
    var actual = new TreeSymmetry().isTreeSymmetrical(tree);
    Assertions.assertTrue(expected == actual);
  }
}
