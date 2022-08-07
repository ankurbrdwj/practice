package com.ankur.interview.practice.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

public class TestMaxTreeDiameter {

  @Test
  public void testMaxDiameter() {
// This file is initialized with a code version of this
// question's sample test case. Feel free to add, edit,
// or remove test cases in this file as you see fit!
        TestBinaryTree input = new TestBinaryTree(1);
        input.insert(new int[] {2, 3, 4, 5, 6, 7}, 0);
        var expected = 4;
        var actual = new MaxTreeDiameter().maxTreeDiameter(input);
    Assertions.assertEquals(expected, actual);
      }

      class TestBinaryTree extends MaxTreeDiameter.BinaryTree {
        public TestBinaryTree(int value) {
          super(value);
        }

        public void insert(int[] values, int i) {
          if (i >= values.length) {
            return;
          }
          ArrayDeque<MaxTreeDiameter.BinaryTree> queue = new ArrayDeque<MaxTreeDiameter.BinaryTree>();
          queue.addLast(this);
          while (queue.size() > 0) {
            MaxTreeDiameter.BinaryTree current = queue.pollFirst();
            if (current.left == null) {
              current.left = new MaxTreeDiameter.BinaryTree(values[i]);
              break;
            }
            queue.addLast(current.left);
            if (current.right == null) {
              current.right = new MaxTreeDiameter.BinaryTree(values[i]);
              break;
            }
            queue.addLast(current.right);
          }
          insert(values, i + 1);
        }
      }
    }

