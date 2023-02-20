package com.ankur.interview.practice.trees.binarysearchtrees;


import java.util.ArrayList;
import java.util.List;

public class RightSmallerThan {
  static class BST {
    int value;
    int leftSubtreeCount;
    BST left;
    BST right;
      public BST(int value){
        this.value=value;
        this.left= null;
        this.right=null;
        this.leftSubtreeCount = 0;
      }

    public void insert(Integer value, int index, List<Integer> rightSmallerCounts) {
       insertHelper(value,index,rightSmallerCounts,0);
    }

    private void insertHelper(Integer value, int index, List<Integer> rightSmallerCounts,
                              int smallerAtInsertTime) {
    if(value<this.value){
      //this will go left
      leftSubtreeCount++;
      if(left == null){
      left  = new BST(value);
      rightSmallerCounts.set(index,smallerAtInsertTime);
      }else{ // add to left child
        left.insertHelper(value,index,rightSmallerCounts,smallerAtInsertTime);
      }
    }else{
      smallerAtInsertTime = smallerAtInsertTime + leftSubtreeCount;
      if(value>this.value){
        smallerAtInsertTime++;
      }
      if(right == null){
        right = new BST(value);
        rightSmallerCounts.set(index,smallerAtInsertTime);
      }else{
        right.insertHelper(value,index,rightSmallerCounts,smallerAtInsertTime);
      }
     }
    }
  }
  public static List<Integer> rightSmallerThan(List<Integer> array){
    List<Integer> rightSmallerCounts = new ArrayList<>();
    // base case
    if(array.isEmpty()) return rightSmallerCounts;
    rightSmallerCounts = new ArrayList<>(array);
    // will start inserting from the right
    int lastIdx= array.size()-1;
    rightSmallerCounts.set(lastIdx,0);
    BST bst = new BST(array.get(lastIdx));
    for(int i=array.size()-2;i>=0;i--){
      bst.insert(array.get(i),i,rightSmallerCounts);
    }
  return rightSmallerCounts;
  }
}
