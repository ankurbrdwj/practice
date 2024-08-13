/**
 * 
 */
package com.ankur.interview.hackerrank;

/**
 * @author ankurbrdwj
 *
 */
public class LoopList {

	/**
	 * 
	 */
	public LoopList() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Node root=new Node(8);
root.next=new Node(1);
root.next.next=new Node(9);
root.next.next.next=new Node(4);
root.next.next.next.next=new Node(2);
root.next.next.next.next.next=new Node(3);
root.next.next.next.next.next.next=new Node(7);
root.next.next.next.next.next.next.next=new Node(2);
root.next.next.next.next.next.next.next.next=new Node(9);
root.next.next.next.next.next.next.next.next.next=root.next.next.next.next.next;
//root.next.next.next.next.next.next.next.next.next.next=new Node(6);
Node node=loopStart(root);

	System.out.println(node.data);
	}

	private static Node loopStart(Node root) {
		// TODO Auto-generated method stub
		if(root==null){
			System.out.println("Empty List");
			return null;
		}
		Node slow=root;
		Node fast=slow;
		do{
			if(slow==null||fast==null||fast.next==null){
				System.out.println("No loop detected");
				return null;
			}
			slow=slow.next;
			fast=fast.next.next;
		}while(slow!=fast);
		slow=root;
		while(slow!=fast){
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}

}
