package com.ankur.interview.practice.trees.binarytrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFlattenTree {

  @Test
  public void TestCase1() {
    FlattenBinaryTree.BinaryTree root = new FlattenBinaryTree.BinaryTree(1);
    insert(root, new int[] {2, 3, 4, 5, 6});
    root.left.right.left = new FlattenBinaryTree.BinaryTree(7);
    root.left.right.right = new FlattenBinaryTree.BinaryTree(8);
    FlattenBinaryTree.BinaryTree leftMostNode = FlattenBinaryTree.flattenBinaryTreeInOrder(root);
    List<Integer> leftToRightToLeft = leftToRightToLeft(leftMostNode);
    List<Integer> expected = new ArrayList<Integer>(
      Arrays.asList(4, 2, 7, 5, 8, 1, 6, 3, 3, 6, 1, 8, 5, 7, 2, 4)
    );
    Assertions.assertTrue(expected.equals(leftToRightToLeft));
  }

  @Test
  public void TestCase2() {
    FlattenBinaryTree.BinaryTree root = new FlattenBinaryTree.BinaryTree(1);
    insert(root, new int[] {2, 3, 4, 5, 6});
    root.left.right.left = new FlattenBinaryTree.BinaryTree(7);
    root.left.right.right = new FlattenBinaryTree.BinaryTree(8);
    FlattenBinaryTree.BinaryTree leftMostNode = FlattenBinaryTree.flattenBinaryTree(root);
    List<Integer> leftToRightToLeft = leftToRightToLeft(leftMostNode);
    List<Integer> expected = new ArrayList<Integer>(
      Arrays.asList(4, 2, 7, 5, 8, 1, 6, 3, 3, 6, 1, 8, 5, 7, 2, 4)
    );
    Assertions.assertTrue(expected.equals(leftToRightToLeft));
  }


  public void insert(FlattenBinaryTree.BinaryTree root, int[] values) {
    insert(root, values, 0);
  }

  public void insert(FlattenBinaryTree.BinaryTree root, int[] values, int i) {
    if (i >= values.length) {
      return;
    }
    Deque<FlattenBinaryTree.BinaryTree> queue = new ArrayDeque<FlattenBinaryTree.BinaryTree>();
    queue.addLast(root);
    while (queue.size() > 0) {
      FlattenBinaryTree.BinaryTree current = queue.pollFirst();
      if (current.left == null) {
        current.left = new FlattenBinaryTree.BinaryTree(values[i]);
        break;
      }
      queue.addLast(current.left);
      if (current.right == null) {
        current.right = new FlattenBinaryTree.BinaryTree(values[i]);
        break;
      }
      queue.addLast(current.right);
    }
    insert(root, values, i + 1);
  }

  public List<Integer> leftToRightToLeft(FlattenBinaryTree.BinaryTree leftMost) {
    List<Integer> nodes = new ArrayList<Integer>();
    FlattenBinaryTree.BinaryTree current = leftMost;
    while (current.right != null) {
      nodes.add(current.value);
      current = current.right;
    }
    nodes.add(current.value);
    while (current != null) {
      nodes.add(current.value);
      current = current.left;
    }
    return nodes;
  }
}

