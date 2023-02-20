package com.ankur.interview.practice.trees.binarytrees;

public class BinaryTreeTopologies {
    public static int numberOfBinaryTreeTopologies(int n) {
        // Write your code here.
        return numOfTopologies(n);
    }

    private static int numOfTopologies(int n) {
        if (n == 0) {
            return 1;
        }
        int numOfTrees = 0;
        for (int leftTrees = 0; leftTrees < n; leftTrees++) {
            int rightTrees = n - 1 - leftTrees;
            numOfTrees += numOfTopologies(leftTrees) * numOfTopologies(rightTrees);
        }
        return numOfTrees;
    }
}
