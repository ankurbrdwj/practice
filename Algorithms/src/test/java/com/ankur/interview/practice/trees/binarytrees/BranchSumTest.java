package com.ankur.interview.practice.trees.binarytrees;
import com.ankur.interview.practice.trees.binarytrees.BranchSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
public class BranchSumTest {

    public class TestBinaryTree extends BranchSum.BinaryTree {
      TestBinaryTree(int value) {
        super(value);
      }

      TestBinaryTree insert(List<Integer> values) {
        return insert(values, 0);
      }

      TestBinaryTree insert(List<Integer> values, int i) {
        if (i >= values.size()) return null;

        List<TestBinaryTree> queue = new ArrayList<TestBinaryTree>();
        queue.add(this);
        while (queue.size() > 0) {
          TestBinaryTree current = queue.get(0);
          queue.remove(0);
          if (current.left == null) {
            current.left = new TestBinaryTree(values.get(i));
            break;
          }
          queue.add((TestBinaryTree) current.left);
          if (current.right == null) {
            current.right = new TestBinaryTree(values.get(i));
            break;
          }
          queue.add((TestBinaryTree) current.right);
        }
        insert(values, i + 1);
        return this;
      }
    }

    @Test
    public void TestCase1() {
      TestBinaryTree tree = new TestBinaryTree(1).insert(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10));
      List<Integer> expected = new ArrayList<Integer>(Arrays.asList(15, 16, 18, 10, 11));
      Assertions.assertTrue(BranchSum.branchSums(tree).equals(expected));
    }

}
