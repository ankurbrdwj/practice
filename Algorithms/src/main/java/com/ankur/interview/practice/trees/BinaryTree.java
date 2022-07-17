/**
 *
 */
package com.ankur.interview.practice.trees;

/**
 * @author ankurbrdwj
 *
 */
public class BinaryTree {


	public Node root;
	public BinaryTree() {
		// TODO Auto-generated constructor stub
		root=new Node();
	}

	public BinaryTree(Node node){
		this();
		root.data=node.data;
		root.left=node.left;
		root.right=node.right;
	}

	public int height(Node node){
		if(node==null)
			return 0;

		int lheight=height(node.left);
		int rheight=height(node.right);

		return Math.max(lheight, rheight)+1;
	}

	public int  level(Node root,int data){
		return depth(root,data,1)+1;
	}

	private int depth(Node node, int data, int i) {
		// TODO Auto-generated method stub
		if(root==null)
			return 0;
		if(node.data==data)
			return i;
		return Math.max(depth(node.left, data, i+1),depth(node.right,data,i+1))	;
	}

	public int size(Node root){
		if(root==null)
			return 0;
		else
	 return(size(root.left)+1+size(root.right));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
