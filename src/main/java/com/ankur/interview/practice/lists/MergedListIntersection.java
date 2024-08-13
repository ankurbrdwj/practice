package com.ankur.interview.practice.lists;


public class MergedListIntersection {

  public LinkedList intersection(LinkedList l1, LinkedList l2) {
    LinkedList leftRunner = l1;
    LinkedList rightRunner = l2;
    while (leftRunner != rightRunner) {
      if (leftRunner == null) {
        leftRunner = l2;
      } else {
        leftRunner = leftRunner.next;
      }
      if (rightRunner == null) {
        rightRunner = l1;
      } else {
        rightRunner = rightRunner.next;
      }
    }
    return leftRunner;
  }

  public LinkedList intersectionDiff(LinkedList l1, LinkedList l2) {
    LinkedList leftRunner = l1;
    LinkedList rightRunner = l2;
    int countOne = 0;
    int countTwo = 0;
    while (leftRunner != null) {
      leftRunner = leftRunner.next;
      countOne++;
    }
    while (rightRunner != null) {
      rightRunner = rightRunner.next;
      countTwo++;
    }
    int diff = Math.abs(countTwo - countOne);
    LinkedList biggerList;
    LinkedList smallerList;
    if (countOne > countTwo) {
      biggerList = l1;
      smallerList = l2;
    } else {
      biggerList = l2;
      smallerList = l1;
    }
    while (diff > 0) {
      biggerList = biggerList.next;
      diff--;
    }
    while (biggerList != smallerList) {
      biggerList = biggerList.next;
      smallerList = smallerList.next;
    }
    return biggerList;
  }

  public static void main(String[] args) {

  }

   static class LinkedList {
    int value;
    LinkedList next;

    LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }
}
