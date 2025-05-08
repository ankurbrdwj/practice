package com.ankur.interview.practice.trees.binarytrees;

import java.util.Stack;
import jogamp.opengl.glu.nurbs.Bin;

public class CompareTreeTraversals {
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  boolean stackLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
    Stack<BinaryTree> tree1Stack = new Stack<>();
    tree1Stack.push(tree1);
    Stack<BinaryTree> tree2Stack = new Stack<>();
    tree2Stack.push(tree2);

    while (tree1Stack.size() > 0 && tree2Stack.size() > 0) {
      BinaryTree tree1Leaf = getNextLeaf(tree1Stack);
      BinaryTree tree2Leaf = getNextLeaf(tree2Stack);
      if (tree1Leaf.value != tree2Leaf.value) {
        return false;
      }
    }
    return (tree1Stack.size() == 0) && (tree2Stack.size() == 0);
  }

  private BinaryTree getNextLeaf(Stack<BinaryTree> treeStack) {
    BinaryTree current = treeStack.pop();
    while (!isLeafNode(current)) {
      if (current.right != null) {
        treeStack.push(current.right);
      }
      if (current.left != null) {
        treeStack.push(current.left);
      }
      current = treeStack.pop();
    }
    return current;
  }

  private boolean isLeafNode(BinaryTree node) {
    return (node.left == null) && (node.right == null);
  }


  public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
    // Write your code here.
    BinaryTree tree1LinkedList = connectLeafNodes(tree1, null, null)[0];
    BinaryTree tree2LinkedList = connectLeafNodes(tree1, null, null)[0];
    BinaryTree list1CurrentNode = tree1LinkedList;
    BinaryTree list2CurrentNode = tree2LinkedList;

    while (list1CurrentNode != null && list2CurrentNode != null) {
      if (list1CurrentNode.value != list2CurrentNode.value) {
        return false;
      }
      list1CurrentNode = list1CurrentNode.right;
      list2CurrentNode = list2CurrentNode.left;
    }

    return list1CurrentNode == null && list2CurrentNode == null;
  }

  private BinaryTree[] connectLeafNodes(BinaryTree currentNode, BinaryTree head,
                                        BinaryTree previousNode) {
    if (currentNode == null) {
      return new BinaryTree[] {head, previousNode};

    }
    if (isLeafNode(currentNode)) {
      if (previousNode == null) {
        head = currentNode;
      } else {
        previousNode.right = currentNode;
      }
      previousNode = currentNode;
    }
    BinaryTree[] nodes = connectLeafNodes(currentNode.left, head, previousNode);
    BinaryTree leftHead = nodes[0];
    BinaryTree previousLeftNode = nodes[1];
    return connectLeafNodes(currentNode.right, leftHead, previousLeftNode);
  }

}
