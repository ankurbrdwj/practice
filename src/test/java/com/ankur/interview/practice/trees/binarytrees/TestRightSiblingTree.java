package com.ankur.interview.practice.trees.binarytrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRightSiblingTree {

    @Test
    public void TestCase1() {
      RightSiblingTree.BinaryTree root = new RightSiblingTree.BinaryTree(1);
      insert(root, new int[] {2, 3, 4, 5, 6, 7, 8, 9});
      root.left.right.right = new RightSiblingTree.BinaryTree(10);
      root.right.left.left = new RightSiblingTree.BinaryTree(11);
      root.right.right.left = new RightSiblingTree.BinaryTree(12);
      root.right.right.right = new RightSiblingTree.BinaryTree(13);
      root.right.left.left.left = new RightSiblingTree.BinaryTree(14);
      RightSiblingTree.BinaryTree mutatedRoot = RightSiblingTree.rightSiblingTree(root);
      List<Integer> actual = getDfsOrder(mutatedRoot);
      var expected = Arrays.asList(
        1, 2, 4, 8, 9, 5, 6, 11, 14, 7, 12, 13, 3, 6, 11, 14, 7, 12, 13
      );
      Assertions.assertTrue(expected.equals(actual));
    }

    public void insert(RightSiblingTree.BinaryTree root, int[] values) {
      insert(root, values, 0);
    }

    public void insert(RightSiblingTree.BinaryTree root, int[] values, int i) {
      if (i >= values.length) {
        return;
      }
      Deque<RightSiblingTree.BinaryTree> queue = new ArrayDeque<RightSiblingTree.BinaryTree>();
      queue.addLast(root);
      while (queue.size() > 0) {
        RightSiblingTree.BinaryTree current = queue.pollFirst();
        if (current.left == null) {
          current.left = new RightSiblingTree.BinaryTree(values[i]);
          break;
        }
        queue.addLast(current.left);
        if (current.right == null) {
          current.right = new RightSiblingTree.BinaryTree(values[i]);
          break;
        }
        queue.addLast(current.right);
      }
      insert(root, values, i + 1);
    }

    public List<Integer> getDfsOrder(RightSiblingTree.BinaryTree tree) {
      List<Integer> values = new ArrayList<Integer>();
      values.add(tree.value);
      if (tree.left != null) {
        values.addAll(getDfsOrder(tree.left));
      }
      if (tree.right != null) {
        values.addAll(getDfsOrder(tree.right));
      }
      return values;
    }
  }
