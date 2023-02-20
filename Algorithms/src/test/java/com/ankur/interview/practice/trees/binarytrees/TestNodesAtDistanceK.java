package com.ankur.interview.practice.trees.binarytrees;

import com.ankur.interview.practice.trees.binarytrees.TreeNodesAtDistanceK;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestNodesAtDistanceK {
  @Test
  public void testNodesAtDistanceK() {
    TreeNodesAtDistanceK.BinaryTree root = new TreeNodesAtDistanceK.BinaryTree(1);
    root.left = new TreeNodesAtDistanceK.BinaryTree(2);
    root.right = new TreeNodesAtDistanceK.BinaryTree(3);
    root.left.left = new TreeNodesAtDistanceK.BinaryTree(4);
    root.left.right = new TreeNodesAtDistanceK.BinaryTree(5);
    root.right.right = new TreeNodesAtDistanceK.BinaryTree(6);
    root.right.right.left = new TreeNodesAtDistanceK.BinaryTree(7);
    root.right.right.right = new TreeNodesAtDistanceK.BinaryTree(8);
    int target = 3;
    int k = 2;
    var expected = new ArrayList<Integer>(Arrays.asList(2, 7, 8));
    var actual = new TreeNodesAtDistanceK().findNodesDistanceK(root, target, k);
    Collections.sort(actual);
    Assertions.assertEquals(expected, actual);
  }
  @Test
  public void testNodesAtDistanceK2() {
    TreeNodesAtDistanceK.BinaryTree root = new TreeNodesAtDistanceK.BinaryTree(1);
    root.left = new TreeNodesAtDistanceK.BinaryTree(2);
    root.right = new TreeNodesAtDistanceK.BinaryTree(3);
    root.left.left = new TreeNodesAtDistanceK.BinaryTree(4);
    root.left.right = new TreeNodesAtDistanceK.BinaryTree(5);
    root.right.right = new TreeNodesAtDistanceK.BinaryTree(6);
    root.right.right.left = new TreeNodesAtDistanceK.BinaryTree(7);
    root.right.right.right = new TreeNodesAtDistanceK.BinaryTree(8);
    int target = 3;
    int k = 2;
    var expected = new ArrayList<Integer>(Arrays.asList(2, 7, 8));
    var actual = new TreeNodesAtDistanceK().findNodesDistanceK(root, target, k);
    Collections.sort(actual);
    Assertions.assertEquals(expected, actual);
  }
}
