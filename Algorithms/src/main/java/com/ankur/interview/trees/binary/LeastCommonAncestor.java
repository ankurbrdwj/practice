/**
 * 
 */
package com.ankur.interview.trees.binary;

/**
 * @author ankurbrdwj
 *
 */
public class LeastCommonAncestor {

	/**
	 * 
	 */
	public LeastCommonAncestor() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
LeastCommonAncestor lca=new LeastCommonAncestor();
Node  root = new Node(1);
root.left = new Node(2);
root.right = new Node(3);
root.left.left = new Node(4);
root.left.right = new Node(5);
root.right.left = new Node(6);
root.right.right = new Node(7);
root.right.left.right = new Node(8);
Node leastCA=lca.findLCA(root, root.left.left,root.left.right );
System.out.println(leastCA.data);

	}
 Node findLCA(Node root,Node n1,Node n2){
	if(root==null){
		return null;
	}
	if(root.data==n1.data||root.data==n2.data){
		return root;
	}
	Node leftLCA=findLCA(root.left,n1,n2);
	Node rightLCA=findLCA(root.right,n1,n2);
	if(leftLCA!=null&&rightLCA!=null){return root;}
	if(leftLCA==null&&rightLCA==null){return null;}
	return leftLCA!=null?leftLCA:rightLCA;
}
}
