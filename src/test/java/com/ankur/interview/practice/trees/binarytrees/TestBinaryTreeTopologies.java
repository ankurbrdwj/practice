package com.ankur.interview.practice.trees.binarytrees;

import com.ankur.interview.practice.trees.binarytrees.BinaryTreeTopologies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBinaryTreeTopologies {
  @Test
  void name() {

  }

  @Test
        public void TestCase1() {
            Assertions.assertTrue(BinaryTreeTopologies.numberOfBinaryTreeTopologies(0) == 1);
        }

        @Test
        public void TestCase2() {
            Assertions.assertTrue(BinaryTreeTopologies.numberOfBinaryTreeTopologies(1) == 1);
        }

        @Test
        public void TestCase3() {
            Assertions.assertTrue(BinaryTreeTopologies.numberOfBinaryTreeTopologies(2) == 2);
        }

        @Test
        public void TestCase4() {
            Assertions.assertTrue(BinaryTreeTopologies.numberOfBinaryTreeTopologies(3) == 5);
        }

        @Test
        public void TestCase5() {
            Assertions.assertTrue(BinaryTreeTopologies.numberOfBinaryTreeTopologies(4) == 14);
        }

        @Test
        public void TestCase6() {
            Assertions.assertTrue(BinaryTreeTopologies.numberOfBinaryTreeTopologies(5) == 42);
        }

        @Test
        public void TestCase7() {
            Assertions.assertTrue(BinaryTreeTopologies.numberOfBinaryTreeTopologies(6) == 132);
        }

        @Test
        public void TestCase8() {
            Assertions.assertTrue(BinaryTreeTopologies.numberOfBinaryTreeTopologies(7) == 429);
        }

        @Test
        public void TestCase9() {
            Assertions.assertTrue(BinaryTreeTopologies.numberOfBinaryTreeTopologies(8) == 1430);
        }

        @Test
        public void TestCase10() {
            Assertions.assertTrue(BinaryTreeTopologies.numberOfBinaryTreeTopologies(9) == 4862);
        }

        @Test
        public void TestCase11() {
            Assertions.assertTrue(BinaryTreeTopologies.numberOfBinaryTreeTopologies(10) == 16796);
        }

        @Test
        public void TestCase12() {
            Assertions.assertTrue(BinaryTreeTopologies.numberOfBinaryTreeTopologies(11) == 58786);
        }

        @Test
        public void TestCase13() {
            Assertions.assertTrue(BinaryTreeTopologies.numberOfBinaryTreeTopologies(12) == 208012);
        }

        @Test
        public void TestCase14() {
            Assertions.assertTrue(BinaryTreeTopologies.numberOfBinaryTreeTopologies(13) == 742900);
        }
    }
