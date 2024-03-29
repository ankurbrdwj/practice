package com.ankur.interview.practice.trees.binarysearchtrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintTree {
  public static <T> void printNode(Node<T> root) {
    int maxLevel = PrintTree.maxLevel(root);
    printNodeInternal(Collections.singletonList(root), 1, maxLevel);
  }

  private static <T> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
    if (nodes.isEmpty() || PrintTree.isAllElementsNull(nodes))
      return;
    int floor = maxLevel - level;
    int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
    int firstSpaces = (int) Math.pow(2, (floor)) - 1;
    int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
    PrintTree.printWhitespaces(firstSpaces);
    List<Node<T>> newNodes = new ArrayList<Node<T>>();
    for (Node<T> node : nodes) {
      if (node != null) {
        System.out.print(node.data);
        newNodes.add(node.left);
        newNodes.add(node.right);
      } else {
        newNodes.add(null);
        newNodes.add(null);
        System.out.print(" ");
      }
      PrintTree.printWhitespaces(betweenSpaces);
    }
    System.out.println("");
    for (int i = 1; i <= edgeLines; i++) {
      for (int j = 0; j < nodes.size(); j++) {
        PrintTree.printWhitespaces(firstSpaces - i);
        if (nodes.get(j) == null) {
          PrintTree.printWhitespaces(edgeLines + edgeLines + i + 1);
          continue;
        }
        if (nodes.get(j).left != null)
          System.out.print("/");
        else
          PrintTree.printWhitespaces(1);
        PrintTree.printWhitespaces(i + i - 1);
        if (nodes.get(j).right != null)
          System.out.print("\\");
        else
          PrintTree.printWhitespaces(1);
        PrintTree.printWhitespaces(edgeLines + edgeLines - i);
      }
      System.out.println("");
    }
    printNodeInternal(newNodes, level + 1, maxLevel);
  }

  private static void printWhitespaces(int count) {
    for (int i = 0; i < count; i++)
      System.out.print(" ");
  }

  private static <T> int maxLevel(Node<T> node) {
    if (node == null)
      return 0;

    return Math.max(PrintTree.maxLevel(node.left), PrintTree.maxLevel(node.right)) + 1;
  }

  private static <T> boolean isAllElementsNull(List<T> list) {
    for (Object object : list) {
      if (object != null)
        return false;
    }
    return true;
  }
}
