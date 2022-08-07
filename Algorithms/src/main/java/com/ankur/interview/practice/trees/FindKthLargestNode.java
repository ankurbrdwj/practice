package com.ankur.interview.practice.trees;

public class FindKthLargestNode {
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  static class TreeInfo {
    private int nodesVisited;
    private int currentNodeValue;

    public TreeInfo(int nodesVisited, int currentNodeValue) {
      this.nodesVisited = nodesVisited;
      this.currentNodeValue = currentNodeValue;
    }
  }

  public int findKthLargestValueInBst(BST tree, int k) {
    // Write your code here.
    TreeInfo info = new TreeInfo(0, -1);
    getKthLargestNode(tree, k, info);
    return info.currentNodeValue;
  }

  private void getKthLargestNode(BST root, int k, TreeInfo info) {
    if (root == null || info.nodesVisited >= k) {
      return;
    }
    // reverse inorder will be right root , root left
    getKthLargestNode(root.right, k, info);
    // root
    if (info.nodesVisited < k) {
      info.nodesVisited++;
      info.currentNodeValue = root.value;
    }
    // left
    getKthLargestNode(root.left, k, info);

  }
}
