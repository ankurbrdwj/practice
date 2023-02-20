package com.ankur.interview.practice.trees.binarytrees;

public class HeightBalanced {
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public boolean heightBalancedBinaryTree(BinaryTree tree) {
    // Write your code here.
    TreeInfo result = getTreeInfo(tree);
    return result.isBalanced;
  }

  static class TreeInfo {
    int height;
    boolean isBalanced;

    public TreeInfo(int height, boolean isBalanced) {
      this.height = height;
      this.isBalanced = isBalanced;
    }
  }

  private TreeInfo getTreeInfo(BinaryTree root) {
    if (root == null) {
      return new TreeInfo(-1, true);
    }
    TreeInfo leftSubtree = getTreeInfo(root.left);
    TreeInfo rightSubtree = getTreeInfo(root.right);
    boolean isBalanced = leftSubtree.isBalanced && rightSubtree.isBalanced
      && Math.abs(leftSubtree.height - rightSubtree.height) <= 1;
    int height = Math.max(leftSubtree.height, rightSubtree.height) + 1;

    return new TreeInfo(height, isBalanced);
  }
}
