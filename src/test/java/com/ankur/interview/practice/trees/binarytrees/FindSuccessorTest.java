package com.ankur.interview.practice.trees.binarytrees;
import com.ankur.interview.practice.trees.binarytrees.FindSuccessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindSuccessorTest {
  // This file is initialized with a code version of this
// question's sample test case. Feel free to add, edit,
// or remove test cases in this file as you see fit!


    @Test
    public void TestCase1() {
      FindSuccessor.BinaryTree root = new FindSuccessor.BinaryTree(1);
      root.left = new FindSuccessor.BinaryTree(2);
      root.left.parent = root;
      root.right = new FindSuccessor.BinaryTree(3);
      root.right.parent = root;
      root.left.left = new FindSuccessor.BinaryTree(4);
      root.left.left.parent = root.left;
      root.left.right = new FindSuccessor.BinaryTree(5);
      root.left.right.parent = root.left;
      root.left.left.left = new FindSuccessor.BinaryTree(6);
      root.left.left.left.parent = root.left.left;
      FindSuccessor.BinaryTree node = root.left.right;
      FindSuccessor.BinaryTree expected = root;
      FindSuccessor.BinaryTree output = new FindSuccessor().findSuccessor(root, node);
      Assertions.assertTrue (expected == output);
    }
  }
