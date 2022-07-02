/**
 *
 */
package com.ankur.interview.practice.trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ankurbrdwj
 *
 */
public class ArrayToTree {

	/**
	 *
	 */
	public ArrayToTree() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		Scanner scan = new Scanner(System.in);
		// scanf("%d\n", &t);
		t = scan.nextInt();
		while (t > 0) {
			// map<int, Node*> m;
			Map<Integer, Node> map = new HashMap<Integer, Node>();
			int n = scan.nextInt();
			// scanf("%d",&n);

			Node root = null;
			Node child;
			while (n > 0) {
				Node parent;
				int n1 = scan.nextInt();
				int n2 = scan.nextInt();
				char lr = scan.next().charAt(0);
				// scanf("%d %d %c", &n1, &n2, &lr);

				// if (m.find(n1) == m.end())
				if (!map.containsKey(n1)) {
					parent = new Node(n1);
					// m[n1] = parent;
					map.put(n1, parent);
					if (root == null)
						root = parent;
				} else
					// parent = m[n1];
					parent = map.get(n1);
				child = new Node(n2);
				if (lr == 'L')
					parent.left = child;
				else
					parent.right = child;
				// m[n2] = child;
				map.put(n2, child);
				n--;
			}
			System.out.println("\n");
			System.out.println("=================================");
			//int[] array = new int[n*2];
			BinaryTree bt=new BinaryTree(root);
			int size=bt.size(root);
			int[] array = new int[size];
			array=SerializeTree.serialize(root,array,0);
			System.out.println(Arrays.toString(array));
			System.out.println("=================================");
			Node node=SerializeTree.deSerialize(array,root,0);
			TreePrinter.printNode(root);
			t--;
		}
	}

	private static void printTree(Node parent) {
		// TODO Auto-generated method stub

	}

	public Node createCustomArrayTree(Node root, String[] arr, int start) {
		// TODO Auto-generated method stub
		int N = arr.length;
		int index = start;
		if (index >= arr.length)
			return root;
		if (root == null && index == 2) {
			root = new Node(Integer.parseInt(arr[index - 2]));
		}

		if ("L".equalsIgnoreCase(arr[index]) && index <= N) {
			// root.key=Integer.parseInt(arr[index-2]);
			root.left = new Node(Integer.parseInt(arr[index - 1]));
			root.left = createCustomArrayTree(root.left, arr, index + 1);

		}
		if ("R".equalsIgnoreCase(arr[index]) && index <= N) {
			// root.key=Integer.parseInt(arr[index-2]);
			root.right = new Node(Integer.parseInt(arr[index - 1]));
			root.right = createCustomArrayTree(root.right, arr, index + 1);

		}
		return createCustomArrayTree(root, arr, index + 1);
	}

	public void createTree() {
		int t;
		Scanner scan = new Scanner(System.in);
		// scanf("%d\n", &t);
		t = Integer.parseInt(scan.nextLine());
		while (t > 0) {
			// map<int, Node*> m;
			Map<Integer, Node> map = new HashMap<Integer, Node>();
			int n = Integer.parseInt(scan.nextLine());
			// scanf("%d",&n);

			Node root = null;
			Node child;
			while (n > 0) {
				Node parent;
				int n1 = scan.nextInt();
				int n2 = scan.nextInt();
				char lr = scan.next().charAt(0);
				// scanf("%d %d %c", &n1, &n2, &lr);

				// if (m.find(n1) == m.end())
				if (!map.containsKey(n1)) {
					parent = new Node(n1);
					// m[n1] = parent;
					map.put(n1, parent);
					if (root == null)
						root = parent;
				} else
					// parent = m[n1];
					parent = map.get(n1);
				child = new Node(n2);
				if (lr == 'L')
					parent.left = child;
				else
					parent.right = child;
				// m[n2] = child;
				map.put(n2, child);
				n--;
			}
			t--;
		}
	}
}
