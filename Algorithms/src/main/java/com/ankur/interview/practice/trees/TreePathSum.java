package com.ankur.interview.practice.trees;

//Java program to find sum of all numbers that are formed from root
//to leaf paths


class TreePathSum{
	Node root, prev;

	// Returns sum of all root to leaf paths. The first parameter is
	// root of current subtree, the second parameter is value of the
	// number formed by nodes from root to this node
	int treePathsSumUtil(Node node, int val)
	{
		// Base case
		if (node == null)
			return 0;

		// Update val
		val = (val * 10 + node.data);

		// if current node is leaf, return the current value of val
		if (node.left == null && node.right == null)
			return val;

		// recur sum of values for left and right subtree
		return treePathsSumUtil(node.left, val)
				+ treePathsSumUtil(node.right, val);
	}

	// A wrapper function over treePathsSumUtil()
	int treePathsSum(Node node)
	{
		// Pass the initial value as 0 as there is nothing above root
		return treePathsSumUtil(node, 0);
	}

	// Driver program to test above functions
	    public static void main(String args[])
	{
		TreePathSum tree = new TreePathSum();
		tree.root = new Node(6);
		tree.root.left = new Node(3);
		tree.root.right = new Node(5);
		tree.root.right.right = new Node(4);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(5);
		tree.root.left.right.right = new Node(4);
		tree.root.left.right.left = new Node(7);

		System.out.print("Sum of all paths is " +
								tree.treePathsSum(tree.root));
	}
}

