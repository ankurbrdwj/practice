/**
 *
 */
package com.ankur.interview.practice.trees;

/**
 * @author ankurbrdwj
 *
 */
public class SerializeTree {
	int[] array;
	/**
	 *
	 */
	public SerializeTree() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] serialize(Node n, int [] array,int start) {

		if (n == null)
			return array;
		int i = start;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		array[i] = n.data;
		if (n.left != null)
			array[left] = n.left.data;
		if (n.right != null)
			array[right] = n.right.data;
		//i++;
		serialize(n.left,array,left);
		serialize(n.right,array,right);
		return array;
	}

	public static Node deSerialize(int[] array,Node root,int i) {

		int size=array.length;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if(left>size||right>size)
			return root;
		if(root==null)
			root=new Node(array[i]);
		if(root.left==null&&root.right==null){
				if(left<size)
					root.left=new Node(array[left]);
				if(right<size)
					root.right=new Node(array[right]);

		}
		deSerialize(array,root,left);
		deSerialize(array,root,right);

		return root;
	}
}
