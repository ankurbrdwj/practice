package com.ankur.interview.practice.trees.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {

	public LevelOrderTraversal() {
		// TODO Auto-generated constructor stub
	}

	void level_order_insert(Node root, int[] arr, int start, int size)
	{
		int left = 2 * start + 1;
		int right = 2 * start + 2;
		if (left > size || right > size)
			return;
		if (root == null) {
			root = new Node(arr[start]);
		}

		if (root.left == null && root.right == null) {
			if (left < size)
				root.left = new Node(arr[left]);
			if (right < size)
				root.right = new Node(arr[right]);
		}
		level_order_insert(root.left, arr, left, size);
		level_order_insert(root.right, arr, right, size);
	}
  Node levelOrderInsert(int[] arr, int start, int size)
  {
    if (start >= size) return null;
    Node  root = new Node(arr[start]); // Create the current node
    int left = 2 * start + 1;
    int right = 2 * start + 2;
    // Recursively insert left and right children
    root.left = levelOrderInsert(arr, left, size);
    root.right = levelOrderInsert(arr, right, size);

    return root;
  }
	public static void main(String... args) {

		int A[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		LevelOrderTraversal lot = new LevelOrderTraversal();
		//lot.level_order_insert(root, A, 0, 10);
    Node root= lot.levelOrderInsert( A, 0, 10);
    TreePrinter.printNode(root);
	}

}
