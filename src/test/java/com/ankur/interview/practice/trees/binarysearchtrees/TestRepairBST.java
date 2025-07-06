package com.ankur.interview.practice.trees.binarysearchtrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRepairBST {

  @Test
  public void TestCase1() {
    RepairBST.BST tree = new RepairBST.BST(2);
    tree.left = new RepairBST.BST(1);
    tree.right = new RepairBST.BST(3);
    tree.left.left = new RepairBST.BST(4);
    tree.right.right = new RepairBST.BST(0);
    List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4);
    List<Integer> actual =
      inOrderTraverse(new RepairBST().repairBst(tree), new ArrayList<Integer>());
    Assertions.assertEquals(actual, expected);
  }

  private static List<Integer> inOrderTraverse(
    RepairBST.BST tree, List<Integer> array
  ) {
    if (tree.left != null) {
      inOrderTraverse(tree.left, array);
    }
    array.add(tree.value);
    if (tree.right != null) {
      inOrderTraverse(tree.right, array);
    }
    return array;
  }
}

