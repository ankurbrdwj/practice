package com.ankur.interview.practice.trees.binarytrees;

import com.ankur.interview.practice.trees.binarytrees.ValidateThreeNodes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestValidateThreeNodes {
  @Test
  public void testThreeNodes(){
      var root = new ValidateThreeNodes.BST(5);
      root.left = new ValidateThreeNodes.BST(2);
      root.right = new ValidateThreeNodes.BST(7);
      root.left.left = new ValidateThreeNodes.BST(1);
      root.left.right = new ValidateThreeNodes.BST(4);
      root.right.left = new ValidateThreeNodes.BST(6);
      root.right.right = new ValidateThreeNodes.BST(8);
      root.left.left.left = new ValidateThreeNodes.BST(0);
      root.left.right.left = new ValidateThreeNodes.BST(3);

      var nodeOne = root;
      var nodeTwo = root.left;
      var nodeThree = root.left.right.left;
      boolean expected = true;
      boolean actual = new ValidateThreeNodes().validateThreeNodes(nodeOne, nodeTwo, nodeThree);
      Assertions.assertTrue(expected == actual);
    }
}

