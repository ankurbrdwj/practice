package com.ankur.interview.searching.bst;

import java.util.Deque;
import java.util.LinkedList;

public class TreeTraversals {

	    public void inOrder(Node root){
	        if(root == null){
	            return;
	        }
	        inOrder(root.left);
	        System.out.print(root.data + " ");
	        inOrder(root.right);
	    }
	    
	    public void preOrder(Node root){
	        if(root == null){
	            return;
	        }
	        System.out.print(root.data + " ");
	        preOrder(root.left);
	        preOrder(root.right);
	    }
	    
	    public void postOrder(Node root){
	        if(root == null){
	            return;
	        }
	        postOrder(root.left);
	        postOrder(root.right);
	        System.out.print(root.data + " ");
	    }

	    public void inOrderItr(Node root){
	        Deque<Node> stack = new LinkedList<Node>();
	        Node node = root;
	        while(true){
	            if(node != null){
	                stack.addFirst(node);
	                node = node.left;
	            }
	            else{
	                if(stack.isEmpty()){
	                    break;
	                }
	                node = stack.pollFirst();
	                System.out.println(node.data);
	                node = node.right;
	            }
	        }
	    }
	    
	    public void preOrderItr(Node root){
	        Deque<Node> stack = new LinkedList<Node>();
	        stack.addFirst(root);
	        while(!stack.isEmpty()){
	            root = stack.pollFirst();
	            System.out.print(root.data + " ");
	            if(root.right != null){
	                stack.addFirst(root.right);
	            }
	            if(root.left!= null){
	                stack.addFirst(root.left);
	            }
	        }
	    }
	    
	    public void postOrderItr(Node root){
	        Deque<Node> stack1 = new LinkedList<Node>();
	        Deque<Node> stack2 = new LinkedList<Node>();
	        stack1.addFirst(root);
	        while(!stack1.isEmpty()){
	            root = stack1.pollFirst();
	            if(root.left != null){
	                stack1.addFirst(root.left);
	            }
	            if(root.right != null){
	                stack1.addFirst(root.right);
	            }
	            stack2.addFirst(root);
	        }
	        while(!stack2.isEmpty()){
	            System.out.print(stack2.pollFirst().data + " ");
	        }
	    }
	    
	    public void postOrderItrOneStack(Node root){
	        Node current = root;
	        Deque<Node> stack = new LinkedList<Node>();
	        while(current != null || !stack.isEmpty()){
	            if(current != null){
	                stack.addFirst(current);
	                current = current.left;
	            }else{
	                Node temp = stack.peek().right;
	                if (temp == null) {
	                    temp = stack.poll();
	                    System.out.print(temp.data + " ");
	                    while (!stack.isEmpty() && temp == stack.peek().right) {
	                        temp = stack.poll();
	                        System.out.print(temp.data + " ");
	                    }
	                } else {
	                    current = temp;
	                }
	            }
	        }
	    }
	    
	    public static void main(String args[]){
			Node root = new Node(1);
			root.left=new Node(2);
			root.right=new Node(3);

			root.left.left = new Node(4);
			root.left.right = new Node(5);
			TreeTraversals tt=new TreeTraversals();
			tt.preOrderItr(root);
			System.out.println();
			tt.inOrderItr(root);
			System.out.println();
			tt.postOrderItr(root);
			System.out.println();
			tt.postOrder(root);
		}
	}


