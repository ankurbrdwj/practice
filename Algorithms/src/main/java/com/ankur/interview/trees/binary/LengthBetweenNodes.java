/**
 * 
 */
package com.ankur.interview.trees.binary;

/**
 * @author ankurbrdwj
 *
 */
public class LengthBetweenNodes {

	/**
	 * 
	 */
	public LengthBetweenNodes() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeastCommonAncestor lca=new LeastCommonAncestor();
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		root.left.right.right = new Node(45);
		int x = Pathlength(root, root.left.left.data) - 1;
		int y = Pathlength(root, root.left.right.right.data) - 1;
		int lcaData = lca.findLCA(root, root.left.left, root.left.right.right).data;
		int lcaDistance = Pathlength(root, lcaData) - 1;
		int result=(x + y) - 2 * lcaDistance;
		System.out.println(result);
	}

	private static int Pathlength(Node root, int data) {
		// TODO Auto-generated method stub
		if (root != null) {
			int x = 0;
			if ((root.data == data) || (x = Pathlength(root.left, data)) > 0
					|| (x = Pathlength(root.right, data)) > 0) {
				// System.out.println(root.data);
				return x + 1;
			}
			return 0;
		}
return 0;
	}
	
}
