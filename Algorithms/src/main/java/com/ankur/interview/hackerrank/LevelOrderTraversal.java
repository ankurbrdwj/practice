package com.ankur.interview.hackerrank;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	public void levelOrderNaiveApproach(com.ankur.interview.practice.trees.Node root){
		int h = height(root);
		for(int i=1;i<=h;i++){
 			printLevels(root,i);
 			System.out.println("");
 		}
 	}
 	public void printLevels(com.ankur.interview.practice.trees.Node root, int h){
 		if(root==null) return;
 		if(h==1) System.out.print(" " + root.data);
 		else{
 			printLevels(root.left,h-1);
 			printLevels(root.right,h-1);
 		}
       }
       public int height(com.ankur.interview.practice.trees.Node root){
 		if (root==null) return 0;
 		return 1 + Math.max(height(root.left),height(root.right));
 	}
 	public void levelOrderQueue(com.ankur.interview.practice.trees.Node root){
 		Queue q = new LinkedList();
 		int levelNodes =0;
		if(root==null) return;
 		q.add(root);
 		while(!q.isEmpty()){
 			levelNodes = q.size();
 			while(levelNodes>0){
				com.ankur.interview.practice.trees.Node n = (com.ankur.interview.practice.trees.Node)q.remove();
				System.out.print(" " + n.data);
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
				levelNodes--;
			}
			System.out.println("");
		}
	}
	public static void main (String[] args) throws Exception
	{
		com.ankur.interview.practice.trees.Node root = new com.ankur.interview.practice.trees.Node(5);
		root.left = new com.ankur.interview.practice.trees.Node(10);
		root.right = new com.ankur.interview.practice.trees.Node(15);
		root.left.left = new com.ankur.interview.practice.trees.Node(20);
		root.left.right = new com.ankur.interview.practice.trees.Node(25);
		root.right.left = new com.ankur.interview.practice.trees.Node(30);
		root.right.right = new com.ankur.interview.practice.trees.Node(35);

		LevelOrderTraversal i  = new LevelOrderTraversal();
		System.out.println(" Output by Naive Approach : ");
		i.levelOrderNaiveApproach(root);
		System.out.println(" Output by Better Approach : ");
		i.levelOrderQueue(root);
	}
}
