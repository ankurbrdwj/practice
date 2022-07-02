package com.ankur.interview.practice.trees;

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

	public static void main(String... args) {

		int A[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Node root = null;
		LevelOrderTraversal lot = new LevelOrderTraversal();
		lot.level_order_insert(root, A, 0, 10);
		List<Integer> list=new  ArrayList<Integer>();

	}

}
