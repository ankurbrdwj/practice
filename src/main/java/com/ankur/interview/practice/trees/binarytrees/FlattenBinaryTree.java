package com.ankur.interview.practice.trees.binarytrees;

import com.ankur.interview.princeton.stdlib.BinaryIn;
import java.util.ArrayList;
import java.util.List;
import jogamp.opengl.glu.nurbs.Bin;

public class FlattenBinaryTree {
  /*
  / inorder traversal
   */
  public static BinaryTree flattenBinaryTreeInOrder(BinaryTree root) {
    List<BinaryTree> inOrderList = getNodesInOrder(root, new ArrayList<BinaryTree>());
    for (int i = 0; i < inOrderList.size() - 1; i++) {
      BinaryTree leftNode = inOrderList.get(i);
      BinaryTree rightNode = inOrderList.get(i + 1);
      leftNode.right = rightNode;
      rightNode.left = leftNode;
    }
    return inOrderList.get(0);
  }

  public static BinaryTree flattenBinaryTree(BinaryTree root) {
    BinaryTree leftMost = flattenTree(root)[0];
    return leftMost;
  }

  private static BinaryTree[] flattenTree(BinaryTree root) {
    BinaryTree leftMost;
    BinaryTree rightMost;
    if (root.left == null) {
      leftMost = root;
    } else {
      BinaryTree[] leftAndRightMostNodes = flattenTree(root.left);
      connectNodes(leftAndRightMostNodes[1], root);
      leftMost = leftAndRightMostNodes[0];
    }
    if (root.right == null) {
      rightMost = root;
    } else {
      BinaryTree[] leftAndRightMostNodes = flattenTree(root.right);
      connectNodes(root, leftAndRightMostNodes[0]);
      rightMost = leftAndRightMostNodes[1];
    }
    return new BinaryTree[] {leftMost, rightMost};
  }

  private static void connectNodes(BinaryTree left, BinaryTree right) {
    left.right = right;
    right.left = left;
  }


  private static List<BinaryTree> getNodesInOrder(BinaryTree root, List<BinaryTree> inOrderList) {
    if (root != null) {
      getNodesInOrder(root.left, inOrderList);
      inOrderList.add(root);
      getNodesInOrder(root.right, inOrderList);
    }
    return inOrderList;
  }

  static class BinaryTree {
    int value;
    BinaryTree left = null;
    BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
