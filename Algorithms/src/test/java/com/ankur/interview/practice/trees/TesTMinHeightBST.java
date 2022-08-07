package com.ankur.interview.practice.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TesTMinHeightBST {
  @Test
  public void testMinBST() {
    List<Integer> array = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
    var tree = MinHeightBst.minHeightBst(array);

    Assertions.assertTrue(validateBst(tree));
    Assertions.assertEquals(4, getTreeHeight(tree));

    var inOrder = inOrderTraverse(tree, new ArrayList<Integer>());
    List<Integer> expected = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
    Assertions.assertTrue(expected.equals(inOrder));
  }

  static boolean validateBst(MinHeightBst.BST tree) {
    return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  static boolean validateBst(MinHeightBst.BST tree, int minValue, int maxValue) {
    if (tree.value < minValue || tree.value >= maxValue) {
      return false;
    }
    if (tree.left != null && !validateBst(tree.left, minValue, tree.value)) {
      return false;
    }
    if (tree.right != null && !validateBst(tree.right, tree.value, maxValue)) {
      return false;
    }
    return true;
  }

  static List<Integer> inOrderTraverse(MinHeightBst.BST tree, List<Integer> array) {
    if (tree.left != null) {
      inOrderTraverse(tree.left, array);
    }
    array.add(tree.value);
    if (tree.right != null) {
      inOrderTraverse(tree.right, array);
    }
    return array;
  }

  static int getTreeHeight(MinHeightBst.BST tree) {
    return getTreeHeight(tree, 0);
  }

  static int getTreeHeight(MinHeightBst.BST tree, int height) {
    if (tree == null) return height;
    int leftTreeHeight = getTreeHeight(tree.left, height + 1);
    int rightTreeHeight = getTreeHeight(tree.right, height + 1);
    return Math.max(leftTreeHeight, rightTreeHeight);
  }
}
