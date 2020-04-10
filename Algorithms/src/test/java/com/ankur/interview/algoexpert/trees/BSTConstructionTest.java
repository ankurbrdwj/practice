package com.ankur.interview.algoexpert.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BSTConstructionTest {

        static BSTConstruction.BST test1;
        static BSTConstruction.BST test2;
        static BSTConstruction.BST test3;
        static BSTConstruction.BST test4;

        static {
            test1 = new BSTConstruction.BST(10);
            test1.insert(5).insert(15).insert(5).insert(2).insert(14).insert(22);
            test2 = new BSTConstruction.BST(10);
            test2.insert(15).insert(11).insert(22).remove(10);
            test3 = new BSTConstruction.BST(10);
            test3.insert(5).insert(7).insert(2).remove(10);
            test4 = new BSTConstruction.BST(10);
            test4
                    .insert(5)
                    .insert(15)
                    .insert(22)
                    .insert(17)
                    .insert(34)
                    .insert(7)
                    .insert(2)
                    .insert(5)
                    .insert(1)
                    .insert(35)
                    .insert(27)
                    .insert(16)
                    .insert(30)
                    .remove(22)
                    .remove(17);
        }

        private void inOrderTraverse(BSTConstruction.BST tree, List<Integer> array) {
            if (tree.left != null) {
                this.inOrderTraverse(tree.left, array);
            }
            System.out.printf(String.valueOf(tree.value)+" , ");
            array.add(tree.value);
            if (tree.right != null) {
                this.inOrderTraverse(tree.right, array);
            }
        }

        private boolean compare(List<Integer> array1, List<Integer> array2) {
            if (array1.size() != array2.size()) {
                return false;
            }
            for (int i = 0; i < array1.size(); i++) {
                if (!array1.get(i).equals(array2.get(i))) {
                    return false;
                }
            }
            return true;
        }

        @Test
        public void TestCase1() {
            Assertions.assertTrue(this.test1.left.value == 5);
        }

        @Test
        public void TestCase2() {
            Assertions.assertTrue(this.test1.right.right.value == 22);
        }

        @Test
        public void TestCase3() {
            Assertions.assertTrue(this.test1.right.left.value == 14);
        }

        @Test
        public void TestCase4() {
            Assertions.assertTrue(this.test1.left.right.value == 5);
        }

        @Test
        public void TestCase5() {
            Assertions.assertTrue(this.test1.left.left.value == 2);
        }

        @Test
        public void TestCase6() {
            Assertions.assertTrue(this.test1.left.left.left == null);
        }

        @Test
        public void TestCase7() {
            Assertions.assertTrue(this.test1.right.right.right == null);
        }

        @Test
        public void TestCase8() {
            Assertions.assertTrue(this.test1.contains(15) == true);
        }

        @Test
        public void TestCase9() {
            Assertions.assertTrue(this.test1.contains(2) == true);
        }

        @Test
        public void TestCase10() {
            Assertions.assertTrue(this.test1.contains(5) == true);
        }

        @Test
        public void TestCase11() {
            Assertions.assertTrue(this.test1.contains(10) == true);
        }

        @Test
        public void TestCase12() {
            Assertions.assertTrue(this.test1.contains(22) == true);
        }

        @Test
        public void TestCase13() {
            Assertions.assertTrue(this.test1.contains(23) == false);
        }

        @Test
        public void TestCase14() {
            List<Integer> expected = new ArrayList<Integer>(Arrays.asList(11, 15, 22));
            List<Integer> output = new ArrayList<Integer>();
            this.inOrderTraverse(this.test2, output);
            Assertions.assertTrue(this.compare(output, expected));
        }

        @Test
        public void TestCase15() {
            List<Integer> expected = new ArrayList<Integer>(Arrays.asList(2, 5, 7));
            List<Integer> output = new ArrayList<Integer>();
            this.inOrderTraverse(this.test3, output);
            Assertions.assertTrue(this.compare(output, expected));
        }

        @Test
        public void TestCase16() {
            List<Integer> expected =
                    new ArrayList<Integer>(Arrays.asList(1, 2, 5, 5, 7, 10, 15, 16, 27, 30, 34, 35));
            List<Integer> output = new ArrayList<>();
            this.inOrderTraverse(this.test4, output);
            Assertions.assertTrue(this.compare(output, expected));
        }

        @Test
        public void TestCase17() {
            Assertions.assertTrue(this.test4.right.right.value == 27);
        }

        @Test
        public void TestCase18() {
            Assertions.assertTrue(this.test4.right.right.left.value == 16);
        }
    }

