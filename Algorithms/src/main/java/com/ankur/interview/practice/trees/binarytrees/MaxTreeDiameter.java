package com.ankur.interview.practice.trees.binarytrees;

public class MaxTreeDiameter {
  /*
  /diameter can be a function of height of subtree legs
  1) If I go through root the max diameter will go through full left height + full right height
  2) If you don't go via root the maxDiameter will be left height+ right height
   */
  public int maxTreeDiameter(BinaryTree root) {
    TreeInfo info = getTreeInfo(root);
    return info.diameter;
  }

  static class TreeInfo {
    int height;
    int diameter;

    public TreeInfo(int diameter, int height ) {
      this.height = height;
      this.diameter = diameter;
    }
  }

  private TreeInfo getTreeInfo(BinaryTree root) {
    if (root == null) {
      return new TreeInfo(0, 0);
    }
    TreeInfo leftTree = getTreeInfo(root.left);
    TreeInfo rightTree = getTreeInfo(root.right);
    int longestViaRoot = leftTree.height + rightTree.height;
    int maxDiameter = Math.max(leftTree.diameter,rightTree.diameter);
    int currDiameter = Math.max(longestViaRoot,maxDiameter);
    int height = Math.max(leftTree.height, rightTree.height) + 1;

    return new TreeInfo(currDiameter,height);
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
