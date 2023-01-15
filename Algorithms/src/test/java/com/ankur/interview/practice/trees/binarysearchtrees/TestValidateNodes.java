package com.ankur.interview.practice.trees.binarysearchtrees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestValidateNodes {

    @Test
    public void TestCase1() {
      var root = new Node<Integer>(5);
      root.left = new Node<Integer>(2);
      root.right = new Node<Integer>(7);
      root.left.left = new Node<Integer>(1);
      root.left.right = new Node<Integer>(4);
      root.right.left = new Node<Integer>(6);
      root.right.right = new Node<Integer>(8);
      root.left.left.left = new Node<Integer>(0);
      root.left.right.left = new Node<Integer>(3);

      var nodeOne = root;
      var nodeTwo = root.left;
      var nodeThree = root.left.right.left;
      boolean expected = true;
      boolean actual = ValidateThreeNodes.validateNodeRecursive(nodeOne, nodeTwo, nodeThree);
      Assertions.assertEquals(expected, actual);
    }
  }

