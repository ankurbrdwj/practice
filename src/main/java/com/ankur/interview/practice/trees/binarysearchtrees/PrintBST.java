package com.ankur.interview.practice.trees.binarysearchtrees;


public class PrintBST {
  private static Node<Integer> test1() {
    Node<Integer>
      root = new Node<>(2);
    Node<Integer>
      n11 = new Node<>(7);
    Node<Integer>
      n12 = new Node<>(5);
    Node<Integer>
      n21 = new Node<>(2);
    Node<Integer>
      n22 = new Node<>(6);
    Node<Integer>
      n23 = new Node<>(3);
    Node<Integer>
      n24 = new Node<>(6);
    Node<Integer>
      n31 = new Node<>(5);
    Node<Integer>
      n32 = new Node<>(8);
    Node<Integer>
      n33 = new Node<>(4);
    Node<Integer>
      n34 = new Node<>(5);
    Node<Integer>
      n35 = new Node<>(8);
    Node<Integer>
      n36 = new Node<>(4);
    Node<Integer>
      n37 = new Node<>(5);
    Node<Integer>
      n38 = new Node<>(8);

    root.left = n11;
    root.right = n12;

    n11.left = n21;
    n11.right = n22;
    n12.left = n23;
    n12.right = n24;

    n21.left = n31;
    n21.right = n32;
    n22.left = n33;
    n22.right = n34;
    n23.left = n35;
    n23.right = n36;
    n24.left = n37;
    n24.right = n38;

    return root;
  }

  static  Node<Integer> test2() {
    Node<Integer>
      root = new Node<>(2);
    Node<Integer>
      n11 = new Node<>(7);
    Node<Integer>
      n12 = new Node<>(5);
    Node<Integer>
      n21 = new Node<>(1);
    Node<Integer>
      n22 = new Node<>(6);
    Node<Integer>
      n23 = new Node<>(9);
    Node<Integer>
      n31 = new Node<>(5);
    Node<Integer>
      n32 = new Node<>(8);
    Node<Integer> n33 = new Node<>(4);

    root.left = n11;
    root.right = n12;

    n11.left = n21;
    n11.right = n22;

    n12.right = n23;
    n22.left = n31;
    n22.right = n32;

    n23.left = n33;

    return root;
  }

  public static void main(String[] args) {

    PrintTree.printNode(test1());
    PrintTree.printNode(test2());

  }
}
