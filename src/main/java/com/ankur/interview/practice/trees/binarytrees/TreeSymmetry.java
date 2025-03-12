package com.ankur.interview.practice.trees.binarytrees;

public class TreeSymmetry {
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  boolean isTreeSymmetrical(BinaryTree tree) {
    return isTreeMirrored(tree.left, tree.right);
  }

  private boolean isTreeMirrored(BinaryTree left, BinaryTree right) {
    // if all good then recurse
    if (left != null && right != null && left.value == right.value) {
      return isTreeMirrored(left.left, right.right) && isTreeMirrored(left.right, right.left);
    }
    // else
    return left == right;
  }
}
