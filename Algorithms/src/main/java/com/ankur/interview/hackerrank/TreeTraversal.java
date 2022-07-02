/**
 *
 */
package com.ankur.interview.hackerrank;

/**
 * @author ankurbrdwj
 *
 */
public class TreeTraversal {


	public TreeTraversal() {
		// TODO Auto-generated constructor stub
		 root = null;
	}

	 com.ankur.interview.practice.trees.Node root;

	    /* Given a binary tree, print its nodes according to the
	      "bottom-up" postorder traversal. */
	    void printPostorder(com.ankur.interview.practice.trees.Node node)
	    {
	        if (node == null)
	            return;

	        // first recur on left subtree
	        printPostorder(node.left);

	        // then recur on right subtree
	        printPostorder(node.right);

	        // now deal with the node
	        System.out.print(node.data + " ");
	    }

	    /* Given a binary tree, print its nodes in inorder*/
	    void printInorder(com.ankur.interview.practice.trees.Node node)
	    {
	        if (node == null)
	            return;

	        /* first recur on left child */
	        printInorder(node.left);

	        /* then print the data of node */
	        System.out.print(node.data + " ");

	        /* now recur on right child */
	        printInorder(node.right);
	    }

	    /* Given a binary tree, print its nodes in preorder*/
	    void printPreorder(com.ankur.interview.practice.trees.Node node)
	    {
	        if (node == null)
	            return;

	        /* first print data of node */
	        System.out.print(node.data + " ");

	        /* then recur on left sutree */
	        printPreorder(node.left);

	        /* now recur on right subtree */
	        printPreorder(node.right);
	    }

	    // Wrappers over above recursive functions
	    void printPostorder()  {     printPostorder(root);  }
	    void printInorder()    {     printInorder(root);   }
	    void printPreorder()   {     printPreorder(root);  }

	    // Driver method
	    public static void main(String[] args)
	    {
	    	TreeTraversal tree = new TreeTraversal();
	        tree.root = new com.ankur.interview.practice.trees.Node(1);
	        tree.root.left = new com.ankur.interview.practice.trees.Node(2);
	        tree.root.right = new com.ankur.interview.practice.trees.Node(3);
	        tree.root.left.left = new com.ankur.interview.practice.trees.Node(4);
	        tree.root.left.right = new com.ankur.interview.practice.trees.Node(5);

	        System.out.println("Preorder traversal of binary tree is ");
	        tree.printPreorder();

	        System.out.println("\nInorder traversal of binary tree is ");
	        tree.printInorder();

	        System.out.println("\nPostorder traversal of binary tree is ");
	        tree.printPostorder();
	    }

}
