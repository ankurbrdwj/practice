package com.ankur.interview.hackerrank.goldmansachs;

import com.ankur.interview.practice.trees.binarytrees.BinaryTree;
import com.ankur.interview.practice.trees.binarytrees.Node;

import java.util.LinkedList;

public class BSTSUM {
    public static void main(String[] args) {
        Node root= new Node(20);

    }
    public static int[] twoTreeSum(BinaryTree first, BinaryTree second, int sum) {
        int[] inFirst = new int[first.size(first.root)];
        int[] inSecond = new int[second.size(second.root)];
        inOrderItr(first.root, inFirst);
        inOrderItr(second.root, inSecond);
        int l = 0;
        int r = inSecond.length - 1;
        while (l < r) {
            int currentSum = inFirst[l] + inSecond[r];
            if (currentSum == sum) {
                return new int[]{inFirst[l] + inSecond[r]};
            } else if (currentSum < sum) {
                l++;
            } else if (currentSum > sum) {
                r--;
            }
        }
        return new int[0];
    }

    public static void inorder(Node root, int[] a, int i) {
        if (root == null)
            return;
        inorder(root.left, a, i);
        a[i++] = root.data;
        inorder(root.right, a, i);
    }

    public static void inOrderItr(Node root, int[] a) {
        LinkedList<Node> queue = new LinkedList<>();
        Node node = root;
        int i = 0;
        while (true) {
            if (root != null) {
                queue.addFirst(node);
                node = node.left;
            } else {
                if (queue.isEmpty()) {
                    break;
                }
                node = queue.pollFirst();
                a[i++] = node.data;
                node = node.right;
            }
        }
    }
}

