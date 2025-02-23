package com.ankur.interview.practice.trees.binarytrees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestExpressionTree {

  @Test
  public void TestCase1() {
    EvaluateExpressionTree.BinaryTree tree = new EvaluateExpressionTree.BinaryTree(-1);
    tree.left = new EvaluateExpressionTree.BinaryTree(2);
    tree.right = new EvaluateExpressionTree.BinaryTree(-2);
    tree.right.left = new EvaluateExpressionTree.BinaryTree(5);
    tree.right.right = new EvaluateExpressionTree.BinaryTree(1);
    var expected = 6;
    var actual = new EvaluateExpressionTree().evaluateExpressionTree(tree);
    Assertions.assertTrue(expected == actual);
  }
}
