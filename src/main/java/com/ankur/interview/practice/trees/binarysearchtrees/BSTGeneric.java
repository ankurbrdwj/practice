package com.ankur.interview.practice.trees.binarysearchtrees;

import com.ankur.interview.princeton.stdlib.In;

public class BSTGeneric <T extends Comparable<? super T>>{
  Node<T> root;
  public BSTGeneric(){
  }
  public boolean isEmpty( ) {return root ==null; }
  public T find(T x){
    return find(x,root);
  }

  private T find(T x, Node<T> root) {
    if(root == null){
      return null;
    }
    int compareResult = x.compareTo(root.data);
    if(compareResult<0){
      return find(x,root.left);
    }else if(compareResult >0){
      return find(x,root.right);
    } else {
      return root.data;
    }
  }

  public void  insert( T x ) {
    root = insert(x,root);
  }

  private Node<T> insert(T x, Node<T> root) {
    if(root ==null){
      return new Node<T>(x,null,null);
    }
    int compareResult = x.compareTo(root.data);
    if(compareResult <0){
      return insert(x,root.left);
    }else if(compareResult>0){
      insert(x,root.right);
    } else;
    return root;
  }

  public void remove( T x ) {
    root = removeRecursive(x,root);
  }

  private Node<T> removeRecursive(T x, Node<T> root) {
    if (root == null)
      return root;

    int compareResult = x.compareTo(root.data);
    if (compareResult <  0) {
      root.left = removeRecursive(x,root.left);
    } else if (compareResult > 0) {
      root.right = removeRecursive(x, root.right);
    } else {
      // root has one subtree
      if (root.left == null) {
        return root.right;
      } else if (root.right == null)
        return root.left;
    // root has 2 subtree
      root.data = inOrderSuccessor(root.right);
      root.right = removeRecursive( root.data,root.right);
    }
    return root;
  }

  public T inOrderSuccessor(Node<T> root) {
    T minimum = root.data;
    while (root.left != null) {
      minimum = root.left.data;
      root = root.left;
    }
    return minimum;
  }
  public void clear(){}

  Node<Integer> sortedArrayToBST(int arr[], int start, int end) {

    /* Base Case */
    if (start > end) {
      return null;
    }

    /* Get the middle element and make it root */
    int mid = (start + end) / 2;
    Node<Integer> node = new Node<>(arr[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
    node.left = sortedArrayToBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
    node.right = sortedArrayToBST(arr, mid + 1, end);

    return node;
  }

  /* A utility function to print preorder traversal of BST */
  void preOrder(Node<T> node) {
    if (node == null) {
      return;
    }
    System.out.print(node.data + " ");
    preOrder(node.left);
    preOrder(node.right);
  }
}
