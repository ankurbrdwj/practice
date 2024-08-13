package com.ankur.interview.practice.trees.binarytrees;

import java.util.ArrayList;

public class SerializeDeserializeBinaryTree {

	public SerializeDeserializeBinaryTree() {
		// TODO Auto-generated constructor stub
	}

	static ArrayList<String> list = new ArrayList<String>();
	static int ind = 0;

	// Encodes a tree to a single list.
	public static String serialize(Node root) {

		if (root == null) {
			list.add("#");
			return "";
		}

		list.add(root.data + "");
		serialize(root.left);
		serialize(root.right);

		return "";

	}

	// Decodes your encoded list to tree.
	public static Node deserialize(String data) {

		if (ind >= list.size() || list.get(ind).equals("#")) {
			ind++;
			return null;
		}
		// System.out.println(list.get(ind));
		Node root = new Node(Integer.parseInt(list.get(ind)));
		ind++;
		root.left = deserialize(data);
		root.right = deserialize(data);

		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node(1);

		// Here I store all the elements in a Array list where each null child
		// is stored as #.
		Node ret = deserialize(serialize(node));
	}

}
