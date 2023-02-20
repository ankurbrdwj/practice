package com.ankur.interview.practice.trees.binarytrees;

public class FindSuccessor {
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
    public BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
    // Write your code here.
      if(node.right!=null) return getLeftMostChild(node.right);

      return getRightMostParent(node);
    }

    public static BinaryTree getLeftMostChild (BinaryTree root){
      BinaryTree runner = root;
      while(runner.left!=null)
        runner =runner.left;
      return runner;
    }

    public static BinaryTree getRightMostParent(BinaryTree root){
      BinaryTree runner = root;
      while(runner.parent!=null && runner.parent.right == runner){
        runner= runner.parent;
      }
      return runner.parent;
    }
  }


