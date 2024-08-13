package com.ankur.interview.practice.trees.binarytrees;

import java.util.List;

public class TreeFromPreOrderArray {
  /*
  / giveb pre order travesal array reat bst from it
  we will take lower andupper bounds and the check
   for the left child the valiues lies between lower bounds and root
   for the right child the vlaues lies between root and upper bound
   */
  public BST reconstructBst(List<Integer> preOrderTraversalValues) {
    // Write your code here.
    TreeInfo info = new TreeInfo(0);
    return reconstructBSTFromPreOrder(Integer.MIN_VALUE, Integer.MAX_VALUE, info, preOrderTraversalValues);
  }

  private BST reconstructBSTFromPreOrder(int lowerBound, int upperBound, TreeInfo info, List<Integer> preOrderTraversalValues) {
    if (info.rootIdx == preOrderTraversalValues.size()) {
      return null;
    }
    int currentNodeValue = preOrderTraversalValues.get(info.rootIdx);
    if (currentNodeValue < lowerBound || currentNodeValue >= upperBound) {
      return null;
    }
    info.rootIdx++;
    BST leftRoot = reconstructBSTFromPreOrder(lowerBound, currentNodeValue, info, preOrderTraversalValues);
    BST rightRoot = reconstructBSTFromPreOrder(currentNodeValue, upperBound, info, preOrderTraversalValues);
    BST bst = new BST(currentNodeValue);
    bst.left = leftRoot;
    bst.right = rightRoot;
    return bst;

  }

  static class TreeInfo {
    private int rootIdx;
    public TreeInfo(int rootIdx) {
      this.rootIdx = rootIdx;
    }
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }
}
