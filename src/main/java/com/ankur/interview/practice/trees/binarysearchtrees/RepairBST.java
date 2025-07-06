package com.ankur.interview.practice.trees.binarysearchtrees;

import java.util.ArrayList;
import java.util.List;

public class RepairBST {
  private BST nodeOne;
  private BST nodeTwo;
  private BST previousNode;

  public BST repairBst(BST tree) {
    this.inOrderBST(tree);
    int tempNodeVal = nodeOne.value;
    nodeOne.value = nodeTwo.value;
    nodeTwo.value = tempNodeVal;
    return tree;
  }

  private void inOrderBST(BST node) {
    if (node == null) {
      return;
    }
    inOrderBST(node.left);// get to bottom left
    // we traverse bottom left, center, right by default previous is less than current
    // if more then its wrong
    if (this.previousNode != null && this.previousNode.value > node.value) {
      if (this.nodeOne == null) {
        this.nodeOne = this.previousNode;
      }
      this.nodeTwo = node;
    }
    this.previousNode = node;

    inOrderBST(node.right);
  }

  public static class BST {
    public BST left;
    public BST right;
    public Integer value;

    public BST(int value) {
      this.value = value;
    }
  }
}
