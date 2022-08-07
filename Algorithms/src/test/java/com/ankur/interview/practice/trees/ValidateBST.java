package com.ankur.interview.practice.trees;

public class ValidateBST {
  public static boolean validateBst(BST tree) {
    // Write your code here.
    // BST left is smaller then root and right is larger then root
    //helper function will have mins as Interger.Min and max as interger.max rhten
    //  compare teh root left right
    return isValidBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);

  }

  private static boolean isValidBST(BST root, int minValue, int maxValue) {
    if (root.value < minValue || root.value >= maxValue) {
      return false;
    }
    if (root.left != null && !isValidBST(root.left, minValue, root.value)) {
      return false;
    }
    if (root.right != null && !isValidBST(root.right, root.value, maxValue)) {
      return false;
    }
    return true;
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}

