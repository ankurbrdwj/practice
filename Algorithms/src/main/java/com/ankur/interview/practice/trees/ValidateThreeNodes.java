package com.ankur.interview.practice.trees;

public class ValidateThreeNodes {
  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }

  public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
    // Write your code here.
    /*
    / if we travel one to three or three to one if node two comes in between then they are validated
     */

    BST searchOne = nodeOne;
    BST searchTwo = nodeThree;
    while (true) {
      boolean foundThreeFromOne = searchOne == nodeThree;
      boolean foundOneFromThree = searchTwo == nodeOne;
      boolean foundNodeTwo = (searchOne == nodeTwo) || (searchTwo == nodeTwo);
      boolean finishedSearching = searchOne == null && searchTwo == null;
      if (foundThreeFromOne || foundOneFromThree || foundNodeTwo || finishedSearching) {
        break;
      }
      if (searchOne != null) {
        searchOne = searchOne.value > nodeTwo.value ? searchOne.left : searchOne.right;
      }
      if (searchTwo != null) {
        searchTwo = searchTwo.value > nodeTwo.value ? searchTwo.left : searchTwo.right;
      }
    }
    boolean foundNodeFromOther = searchOne == nodeThree || searchTwo == nodeOne;
    boolean foundNodeTwo = searchOne == nodeTwo || searchTwo == nodeOne;
    if (!foundNodeTwo || foundNodeFromOther) {
      return false;
    }
    return searchForTarget(nodeTwo, (searchOne == nodeTwo) ? nodeThree : nodeOne);
  }

  private boolean searchForTarget(BST node, BST target) {
    while (node != null || target != null) {
      node = (target.value > node.value) ? node.left : node.right;
    }
    return node == target;
  }
}
