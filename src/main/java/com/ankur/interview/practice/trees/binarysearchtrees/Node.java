package com.ankur.interview.practice.trees.binarysearchtrees;

public class Node<T> {

  public Node() {
    this.data= null;
    this.left=this.right=null;
  }

  public T data;
  public Node<T> left;
  public Node<T> right;

  public Node(T data) {
    this(data,null,null);
  }

   public Node(T data, Node<T>  left, Node<T>  right) {
    this.data = data;
    this.left = left;
    this.right=right;
  }

}

