package com.ankur.interview.practice.trees.binarysearchtrees;

public class BSTClosest {

    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        int diff = Integer.MAX_VALUE-100;
        return closest(tree, target, diff);
    }

    private static int closest(BST tree, int target, int closest) {
        BST currentNode=tree;
        while(currentNode!=null){
            if(Math.abs(target-closest)> Math.abs(target-currentNode.value)){
                closest = currentNode.value;
            }if(target < currentNode.value){
                currentNode= currentNode.left;
            }else if (target >currentNode.value){
                currentNode= currentNode.right;
            }else{
                break;
            }
        }
        return closest;
    }

    public static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}

