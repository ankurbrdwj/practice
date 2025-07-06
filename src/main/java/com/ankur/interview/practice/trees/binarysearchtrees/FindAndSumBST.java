package com.ankur.interview.practice.trees.binarysearchtrees;

import com.ankur.interview.practice.trees.binarytrees.FindKthLargestNode;

public class FindAndSumBST {

  /*
  Given a binary tree , I need to find all possible BST and SUM them
  1. BST has left strictly less than room and right equal to or greater than root
  2. So root is greater than all left node value we can track MaxValue
     Root is min or equal to all right nodes so track minValue
 tracking Sum of left and right + current
  reading children first helps -> go postOrder
   */
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  static class TreeInfo {
    int maxValue;
    int minValue;
    int sumAllBSTs;
    boolean isBST;
    int currentSum;
    int currentSize;

    public TreeInfo(int maxValue, int minValue, int sumAllBSTs, boolean isBST, int currentSum,
                    int currentSize) {
      this.maxValue = maxValue;
      this.minValue = minValue;
      this.sumAllBSTs = sumAllBSTs;
      this.isBST = isBST;
      this.currentSum = currentSum;
      this.currentSize = currentSize;
    }
  }

  public int findAndSumBsts(BinaryTree tree) {
    // Write your code here.

    return getTreeSums(tree).sumAllBSTs;
  }

  private TreeInfo getTreeSums(BinaryTree node) {
    if (node == null) {
      return new TreeInfo(Integer.MIN_VALUE, Integer.MAX_VALUE,0,true,0,0 );
    }
    TreeInfo leftTreeInfo=getTreeSums(node.left);
    TreeInfo rightTreeInfo=getTreeSums(node.right);

    boolean isBSTNow= node.value>leftTreeInfo.maxValue
       && node.value<=rightTreeInfo.minValue;
    boolean isBST= isBSTNow && leftTreeInfo.isBST && rightTreeInfo.isBST;
    int maxValue= Math.max(node.value,Math.max(leftTreeInfo.maxValue,rightTreeInfo.maxValue));
    int minValue= Math.min(node.value,Math.min(leftTreeInfo.minValue,rightTreeInfo.minValue));

    int bstSum=0;
    int bstSize=0;
    int sumTillNow= leftTreeInfo.sumAllBSTs+rightTreeInfo.sumAllBSTs;
    if(isBST){
      bstSum= node.value+leftTreeInfo.currentSum+rightTreeInfo.currentSum;
      bstSize= 1+leftTreeInfo.currentSize+rightTreeInfo.currentSize;
      if(bstSize>=3){
        sumTillNow=bstSum;
      }
    }
    return new TreeInfo(maxValue,minValue,sumTillNow,isBST,bstSum,bstSize);
  }
}
