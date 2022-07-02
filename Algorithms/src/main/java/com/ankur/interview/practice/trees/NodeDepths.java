package com.ankur.interview.practice.trees;

public class NodeDepths {
  public static int nodeDepths(BinaryTree root) {
    // get leaf nodes
    //all their depth
    // add
    int depth = 0;
    return nodeDepthsHelper(root, depth);
  }

  private static int nodeDepthsHelper(BinaryTree root, int depth) {
    if (root == null) {
      return 0;
    }
    return depth + nodeDepthsHelper(root.left, depth + 1) + nodeDepthsHelper(root.right, depth + 1);
  }

  static class BinaryTree {
    BinaryTree left;
    BinaryTree right;
    int value;

    public BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree(1);
    tree.left = new BinaryTree(2);
    tree.right = new BinaryTree(3);
    tree.left.left = new BinaryTree(4);
    tree.left.right = new BinaryTree(5);
    tree.right.left= new BinaryTree(6);
    tree.right.right = new BinaryTree(7);
    System.out.println(nodeDepths(tree));

  }
}
