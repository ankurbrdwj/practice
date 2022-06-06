package com.ankur.interview.trees.binary;


	 
	/**
	 * <b>IDeserve <br>
	 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a>
	 * O(n) solution to construct binary tree from its parent array representation.
	 * @author Nilesh
	 */
	 
	public class CreateTreeFromParentArray {
	     
	    final static int INVALID_INDEX = -1;
	     
	    private class TreeNode 
	    {
	        int data;
	        TreeNode left;
	        TreeNode right;
	         
	        TreeNode(int data)
	        {
	            this.data = data;
	        }
	    }
	 
	    TreeNode root;
	    
	     
	    private void constructNode(int i, TreeNode[] constructed, int[] parent)
	    {
	        // node already created for this index 'i'
	        if (constructed[i] != null)
	        {
	            return;
	        }	         
	        // we need to create a root with value as this index 'i'
	        // there would be no parent node for root, 
	        // hence we returning after creating root node
	        if (parent[i] == -1)
	        {
	            constructed[i] = new TreeNode(i);
	            root = constructed[i];
	            return;
	        }
	        // first we create a parent node, then create current node itself 
	        // and finally attach current node to its parent
	        if (constructed[parent[i]] == null)
	        {
	            constructNode(parent[i], constructed, parent);
	        }
	        // create node reference using value as this index 'i'
	        constructed[i] = new TreeNode(i);
	        // attach node to its parent
	        if (constructed[parent[i]] != null) // sanity check
	        {
	            if (constructed[parent[i]].left == null)
	            {
	                constructed[parent[i]].left = constructed[i];
	            }
	            else
	            {
	                constructed[parent[i]].right = constructed[i];
	            }
	        }
	    }
	     
	     
	    public TreeNode constructTreeBottomUp(int[] parent)
	    {
	        TreeNode[] constructed = new TreeNode[parent.length]; 
	         
	        for (int i = 0; i < constructed.length; i++)
	        {
	            constructNode(i, constructed, parent);
	        }
	        return root;
	    }
	     
	     
	    private void constructTreeTopDownRec(TreeNode currentNode, int currentNodeValue, int[] parent)
	    {
	        // search for currentNodeValue in parent array
	        // if two values found, we create two children for currentNode
	        // if only one value found, then we create only left child
	        // if no value found, then this currentNode is leaf node.
	         
	        int indexFirstChild = -1, indexSecondChild = -1;
	        for (int i = 0; i < parent.length; i++)
	        {
	            if (currentNodeValue == parent[i])
	            {
	                if (indexFirstChild == -1)
	                {
	                    indexFirstChild = i;
	                }
	                else
	                {
	                    indexSecondChild = i;
	                    break;
	                }
	            }
	        }
	         
	        // no child found for this currentNode
	        if (indexFirstChild == -1) 
	        {
	            return;
	        }
	         
	        // create left child and left sub-tree rooted at left child 
	        currentNode.left = new TreeNode(indexFirstChild);
	        constructTreeTopDownRec(currentNode.left, indexFirstChild, parent);
	         
	        // if right child found then create node for it
	        // then create right sub-tree rooted at right child 
	        if (indexSecondChild != -1)
	        {
	            currentNode.right = new TreeNode(indexSecondChild);
	            constructTreeTopDownRec(currentNode.right, indexSecondChild, parent);
	        }
	    }
	     
	     
	    public TreeNode constructTreeTopDown(int[] parent)
	    {
	        // search for value -1, create root out of it 
	        // and call recursive sub-routine to create complete tree 
	        int rootIndex = INVALID_INDEX;
	        for (int i = 0; i < parent.length; i++)
	        {
	            if (parent[i] == -1)
	            {
	                rootIndex = i;
	                break;
	            }
	        }
	         
	        if (rootIndex != INVALID_INDEX)
	        {
	            this.root = new TreeNode(rootIndex);
	        }
	        constructTreeTopDownRec(root, rootIndex, parent);
	         
	        return root;
	    }
	 
	 
	    public void printInorder(TreeNode root)
	    {
	        if (root == null) return;
	         
	        printInorder(root.left);
	        System.out.print(root.data + ", ");
	        printInorder(root.right);
	    }
	     
	     
	    public static void main(String[] args)
	    {
	        CreateTreeFromParentArray solution = new CreateTreeFromParentArray();
	         
	        int[] parent = {1,5,5,2,2,-1,3};
	         
	        TreeNode root = solution.constructTreeBottomUp(parent);
	        // TreeNode root = solution.constructTreeTopDown(parent);
	 
	        /*
	                                5
	                           1         2
	                        0          3   4
	                                 6 
	        */
	        System.out.println("Inorder traversal for constructed tree is: ");
	        solution.printInorder(root);
	         
	    }
	}

