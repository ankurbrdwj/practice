package com.ankur.interview.practice.trees.binarytrees;

import java.util.Stack;

public class MergeAndAddTwoTrees {
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2) {
    // Write your code here.
    if (tree1 == null) {
      return tree2;
    }
    if (tree2 == null) {
      return tree1;
    }
    tree1.value += tree2.value;
    tree1.left = mergeBinaryTrees(tree1.left, tree2.left);
    tree1.right = mergeBinaryTrees(tree1.right, tree2.right);
    return tree1;
  }

  public BinaryTree mergeBinaryTreesIterative(BinaryTree tree1, BinaryTree tree2) {
    // Write your code here.
    if(tree1 == null){
      return tree2 ;
    }
    // take two stacks
    Stack<BinaryTree> tree1Stack = new Stack<>();
    tree1Stack.push(tree1);
    Stack<BinaryTree> tree2Stack = new Stack<>();
    tree2Stack.push(tree2);
    // start infinite while loop
    while (!tree1Stack.isEmpty()) {
      BinaryTree tree1Node = tree1Stack.pop();
      BinaryTree tree2Node = tree2Stack.pop();

      // if right tree is null then continue no addition required
      if (tree2Node == null) {
        continue;
      }
      // add in tree1
      tree1Node.value = tree1Node.value + tree2Node.value;
      // if tree 1 left is finished
      if (tree1Node.left == null) {
        tree1Node.left = tree2Node.left;
      } else {
        tree1Stack.push(tree1Node.left);
        tree2Stack.push(tree2Node.left);
      }
      if (tree1Node.right == null) {
        tree1Node.right = tree2Node.right;
      } else {
        tree1Stack.push(tree1Node.right);
        tree2Stack.push(tree2Node.right);
      }
    }
    return tree1;
  }
}
