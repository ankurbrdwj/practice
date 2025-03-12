package com.ankur.interview.practice.trees.binarytrees;

public class SplitBinaryTree {

  public int splitBinaryTree(BinaryTree tree) {

    // get full tree sum , then check if half is possible
    int treeSum = getTreeSum(tree);
    if (treeSum % 2 != 0) {
      return 0;
    }

    int expectedTreeSum = treeSum / 2;
    boolean canSplit = trySubtrees(tree, expectedTreeSum).canSplit;
    return canSplit == true ? expectedTreeSum : 0;
  }

  private Pair trySubtrees(BinaryTree tree, int expectedTreeSum) {
    if (tree == null) {
      return new Pair(0, false);
    }

    Pair leftPair = trySubtrees(tree.left, expectedTreeSum);
    Pair rightPair = trySubtrees(tree.right, expectedTreeSum);
    int currentSum = tree.value + leftPair.currentTreeSum + rightPair.currentTreeSum;
    boolean canBeSplit = leftPair.canSplit || rightPair.canSplit || currentSum == expectedTreeSum;

    return new Pair(currentSum, canBeSplit);
  }

  static class Pair {
    int currentTreeSum;
    boolean canSplit;

    public Pair(int currentTreeSum, boolean canSplit) {
      this.currentTreeSum = currentTreeSum;
      this.canSplit = canSplit;
    }
  }

  int getTreeSum(BinaryTree root) {
    if (root == null) {
      return 0;
    }
    return root.value + getTreeSum(root.left) + getTreeSum(root.right);
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
