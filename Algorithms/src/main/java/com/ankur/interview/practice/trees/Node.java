package com.ankur.interview.practice.trees;

public class Node<T extends Comparable<?>> {

	public Node() {
		// TODO Auto-generated constructor stub
		this.data=0;
		this.left=this.right=null;
	}

	public int data;
	public Node left;
	public Node right;

	public Node(int data) {
		this.data = data;
		this.left=this.right=null;

	}
}
