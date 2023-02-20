/**
 *
 */
package com.ankur.interview.practice.trees.binarytrees;

/**
 * @author ankurbrdwj
 *
 */
public class TreeFromParrentArray {

	/**
	 *
	 */
	public TreeFromParrentArray() {
		// TODO Auto-generated constructor stub
	}
Node root;
	Node createTreeFromParentArray(int[] parent) {
		Node[] tree = new Node[parent.length];
		for (int i = 0; i < tree.length; i++) {
			createNode(i, parent, tree);
		}
		return root;
	}

	private void createNode(int i, int[] parent, Node[] tree) {
		// TODO Auto-generated method stub
		if (tree[i] != null) {
			return;
		}
		if (parent[i] == -1) {
			tree[i] = new Node(i);
			 root = tree[i];
			return;
		}
		if (tree[parent[i]] == null) {
			createNode(parent[i], parent, tree);
		}

		tree[i] = new Node(i);
		if (tree[parent[i]] != null) {
			if (tree[parent[i]].left == null) {
				tree[parent[i]].left = tree[i];
			} else {
				tree[parent[i]].right = tree[i];
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] parent = {1,5,5,2,2,-1,3};
		TreeFromParrentArray solution=new TreeFromParrentArray();
        Node root = solution.createTreeFromParentArray(parent);
        TreePrinter printer=new TreePrinter();
        printer.printNode(root);
	}

}
