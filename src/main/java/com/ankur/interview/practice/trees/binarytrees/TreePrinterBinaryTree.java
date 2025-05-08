package com.ankur.interview.practice.trees.binarytrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class TreePrinterBinaryTree {
    public static void printNode(RightSiblingTree.BinaryTree root) {
      int maxLevel = maxLevel(root);
      printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<RightSiblingTree.BinaryTree> nodes, int level, int maxLevel) {
      if (nodes.isEmpty() || isAllElementsNull(nodes)) return;

      int floor = maxLevel - level;
      int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
      int firstSpaces = (int) Math.pow(2, floor) - 1;
      int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

      printWhitespaces(firstSpaces);

      List<RightSiblingTree.BinaryTree> newNodes = new ArrayList<>();
      for (RightSiblingTree.BinaryTree node : nodes) {
        if (node != null) {
          System.out.print(node.value);
          newNodes.add(node.left);
          newNodes.add(node.right);
        } else {
          System.out.print(" ");
          newNodes.add(null);
          newNodes.add(null);
        }
        printWhitespaces(betweenSpaces);
      }
      System.out.println();

      for (int i = 1; i <= edgeLines; i++) {
        for (RightSiblingTree.BinaryTree node : nodes) {
          printWhitespaces(firstSpaces - i);
          if (node == null) {
            printWhitespaces(edgeLines + edgeLines + i + 1);
            continue;
          }
          if (node.left != null)
            System.out.print("/");
          else
            printWhitespaces(1);
          printWhitespaces(i + i - 1);
          if (node.right != null)
            System.out.print("\\");
          else
            printWhitespaces(1);
          printWhitespaces(edgeLines + edgeLines - i);
        }
        System.out.println();
      }

      printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
      for (int i = 0; i < count; i++)
        System.out.print(" ");
    }

    private static int maxLevel(RightSiblingTree.BinaryTree node) {
      if (node == null) return 0;
      return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List<RightSiblingTree.BinaryTree> list) {
      for (RightSiblingTree.BinaryTree node : list) {
        if (node != null) return false;
      }
      return true;
    }
  }
