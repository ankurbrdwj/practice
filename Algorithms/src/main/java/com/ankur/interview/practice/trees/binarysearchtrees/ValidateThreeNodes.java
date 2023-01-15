package com.ankur.interview.practice.trees.binarysearchtrees;

import com.ankur.interview.princeton.stdlib.In;
import java.util.Objects;

public class ValidateThreeNodes {
  public static boolean validateNodeRecursive(Node<Integer> nodeOne, Node<Integer>  nodeTwo
    , Node<Integer>  nodeThree) {
      if(isDescendant(nodeOne,nodeTwo)){
        return isDescendant(nodeTwo,nodeThree);
      }
      if (isDescendant(nodeThree,nodeTwo)){
        return isDescendant(nodeTwo,nodeOne);
    }
    return false;
  }
    public static  boolean isDescendant(Node<Integer>  nodeOne,Node<Integer> root){
    if(root == null){
      return false;
    }
    if(Objects.equals(nodeOne.data, root.data)){
      return true;
    }
     if(nodeOne.data < root.data) return isDescendant(nodeOne, root.left);
     else return isDescendant(nodeOne, root.right);
    }

    public static void main(String[] args){
      int[] arr = {1,4,7,8,12,24,28,32,35,37,38};
      BSTGeneric<Integer> bst = new BSTGeneric<>();
      bst.root =bst.sortedArrayToBST(arr,0,arr.length-1);
      PrintTree.printNode(bst.root);
      Node<Integer> one = new Node<>(7);
      Node<Integer> two = new Node<>(8);
      Node<Integer> three = new Node<>(12);

      System.out.println(validateNodeRecursive(one,two,three));
    }
}
