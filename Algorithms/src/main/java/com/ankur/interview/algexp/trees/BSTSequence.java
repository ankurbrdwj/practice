package com.ankur.interview.algexp.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BSTSequence {
   static  class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public void getPossibleArrays(List<BST> possibilities,String result){
        if(possibilities.size() == 0){
            System.out.printf(result);
            System.out.println();
            return;
        }
        for(int i=0;i<possibilities.size();i++) {
            BST curr = possibilities.get(i);
            possibilities.remove(i);
            List<BST> newPossibilities = getChildren(curr);
            newPossibilities.addAll(possibilities);
            getPossibleArrays(newPossibilities, result + " " + curr.value);
            possibilities.add(curr);
        }
    }

    private static List<BST> getChildren(BST root){
            List<BST> result= new LinkedList<>();
            //while(root!=null){
                if(root.left!=null){
                    result.add(root.left);
                }   if(root.right!=null){
                    result.add(root.right);
                }
           // }
            return result;
   }

    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int N= scan.nextInt();
        for(int i=0 ; i<N ;i++) {
            int M = scan.nextInt();
            int R = scan.nextInt();
            BST root=new BST(R);
            BST curr = root;
            for(int j = 0;j < M; j=j+2){
                root.left = new BST(scan.nextInt());
                root.right=new BST(scan.nextInt());
            }
        }
    }
}
