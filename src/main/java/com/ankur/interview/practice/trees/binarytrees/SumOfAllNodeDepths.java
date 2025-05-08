package com.ankur.interview.practice.trees.binarytrees;

public class SumOfAllNodeDepths {
  /*
  / get Summm of all subtrees depths sum
   */

  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }

  public static int getAllSubtreeDepthsRecursive(BinaryTree root) {
    if (root == null) {
      return 0;
    }
    int sumLeft = getAllSubtreeDepthsRecursive(root.left);
    int sumRight = getAllSubtreeDepthsRecursive(root.right);
    int sumNode = nodeSum(root, 0);
    return sumLeft+sumRight+sumNode;
  }

  private static int nodeSum(BinaryTree root, int depth) {
    if (root == null) {
      return 0;
    }
    return depth + nodeSum(root.left, depth + 1) + nodeSum(root.right, depth + 1);
  }
}
