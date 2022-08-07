package com.ankur.interview.practice.trees;

import java.util.List;

public class MinHeightBst {

  public static BST minHeightBst(List<Integer> array) {
    return constructMinHeighBST(array, null, 0, array.size() - 1);
  }

  private static BST constructMinHeighBST(List<Integer> array, BST root, int startIdx, int endIdx) {
    if (endIdx < startIdx) return null;
    int mid = startIdx + (endIdx - startIdx) / 2;
    int value = array.get(mid);
    if (root == null)
      root = new BST(value);
    else
      root.insert(value);
    constructMinHeighBST(array, root, startIdx, mid - 1);
    constructMinHeighBST(array, root, mid + 1, endIdx);
    return root;
  }

  private static BST constructMinHeighBST2(List<Integer> array, int startIdx, int endIdx) {
    if (endIdx < startIdx) return null;
    int mid = startIdx + (endIdx - startIdx) / 2;
    int value = array.get(mid);
    BST root = new BST(value);
    root.left = constructMinHeighBST2(array, startIdx, mid - 1);
    root.right = constructMinHeighBST2(array, mid + 1, endIdx);
    return root;
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

    public void insert(int value) {
      if (value < this.value) {
        if (left == null) {
          left = new BST(value);
        } else {
          left.insert(value);
        }
      } else {
        if (right == null) {
          right = new BST(value);
        } else {
          right.insert(value);
        }
      }
    }
  }
}
