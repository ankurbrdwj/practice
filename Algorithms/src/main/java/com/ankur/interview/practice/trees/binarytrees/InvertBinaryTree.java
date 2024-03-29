package com.ankur.interview.practice.trees.binarytrees;

public class InvertBinaryTree {

    public static void invertBinaryTree(BinaryTree tree) {
        // Write your code here.
        if (tree != null) {
            tree = swap(tree);
            invertBinaryTree(tree.left);
            invertBinaryTree(tree.right);
        }
    }

    private static BinaryTree swap(BinaryTree root) {
        BinaryTree temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
