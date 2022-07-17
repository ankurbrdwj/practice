package com.ankur.interview.practice.trees;

import java.util.ArrayList;
import java.util.List;

public class BranchSum {
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(BinaryTree root) {
    // Write your code here.
    List<Integer> sums = new ArrayList<>();
    calcSum(root, 0, sums);
    return sums;
  }


  private static void calcSum(BinaryTree node, int runningSum, List<Integer> sums) {
    if (node == null) {
      return;
    }
    int newSum = runningSum + node.value;
    if (node.left == null && node.right == null) {
      sums.add(newSum);
      return;
    }
    calcSum(node.left, newSum, sums);
    calcSum(node.right, newSum, sums);
  }

  public static void main(String[] args) {

  }
}
