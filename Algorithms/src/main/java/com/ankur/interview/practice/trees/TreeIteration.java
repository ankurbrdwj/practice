package com.ankur.interview.practice.trees;


import java.util.ArrayDeque;
import java.util.Deque;

public class TreeIteration {


    public static void inOrder(Node root) {
        System.out.println("=====InOrderTraversal=====");

        if (root == null) {
            return;
        }
        Deque<Node> stack = new ArrayDeque();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.printf(curr.data + " ");
            curr = curr.right;
        }
        System.out.println("========================");
    }

    public static void preOrder(Node root) {
        System.out.println("=====PreOrderTraversal=====");
        Deque<Node> stack = new ArrayDeque<>();
        if (root != null)
            stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.data + " ");
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        System.out.println("========================");
    }

    public static void postOrder(Node root) {
        System.out.println("=====PostOrderTraversal=====");
        Deque<Node> stack = new ArrayDeque<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                // curr is null here
                Node temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    curr = temp;
                }
            }
        }
        System.out.println("========================");
    }

    public static void main(String args[]) {

        /* creating a binary tree and entering
        the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        inOrder(tree.root);
        System.out.println();
        preOrder(tree.root);
        System.out.println();
        postOrder(tree.root);
    }
}
