package com.ankur.interview.practice.lists;
public class MergeSortedLinkedLists {
  // This is an input class. Do not edit.
  public static class LinkedList {
    int value;
    LinkedList next;

    LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
    // Write your code here.
    LinkedList l1 = headOne;
    LinkedList l2 = headTwo;
    LinkedList prev = null;
    printList(headOne,"headOne");
    printList(headTwo,"headTwo");
    printList(l1,"FirstPointer");
    printList(l2,"SecondPointer");
    System.out.println("=================================");
    while (l1 != null && l2 != null) {
      if (l1.value < l2.value) {
        System.out.println("First Pointer: "+l1.value +" is smaller than Second Pointer: "+ l2.value);
        if(prev!=null)
        System.out.println("Current smaller "+prev.value+"will become -->"+ l1.value);
        prev = l1;
        if( l1.next!=null)
        System.out.println("First Pointer "+l1.value+"will become -->"+ l1.next.value);
        l1 = l1.next;
      } else {
        System.out.println("Second Pointer: "+l2.value +" is smaller than First Pointer: "+ l1.value);
        if (prev != null) {
          System.out.println("## Reassigning smaller "+prev.value+".next to : -->"+ l2.value);
          prev.next = l2;
        }
        if(prev!=null)
          System.out.println("Current smaller "+prev.value+"will become -->"+ l2.value);
        prev = l2;
        if(l2.next!=null)
          System.out.println("Second Pointer "+l2.value+"will become -->"+ l2.next.value);
        l2 = l2.next;
        System.out.println("<< Reassigning smaller "+prev.value+".next to : -->"+ l1.value);
        prev.next = l1;
      }
      printList(prev,"smallerNode");
      printList(l1,"FirstPointer");
      printList(l2,"SecondPointer");
      printList(headOne,"headOne");
      printList(headTwo,"headTwo");
      System.out.println("=================================");
    }
    if(l1==null)
      prev.next=l2;
    System.out.println("=================================");
    printList(headOne,"headOne");
    printList(headTwo,"headTwo");
    return headOne.value<headTwo.value?headOne:headTwo;
  }

  public static void printList(LinkedList node, String headName) {
    LinkedList current = node;
    System.out.print(headName + "-->");
    while (current != null) {
      System.out.print(current.value + "-->");
      current = current.next;
    }
    System.out.println("");
  }

  static LinkedList createList(int arr[], int n) {
    LinkedList node = null;
    LinkedList p = null;

    int i;
    for (i = 0; i < n; ++i) {
      if (node == null) {
        node = p = new LinkedList(arr[i]);
      } else {
        p.next = new LinkedList(arr[i]);
        p = p.next;
      }
      p.next = null;
    }
    return node;
  }
  public static void main(String[] args) {
    LinkedList l1 = createList(new int[]{1,5,7,9},4);
    LinkedList l2 = createList(new int[]{2,3,6,8},4);
    printList(l1,"input1");
    printList(l2,"input2");
    mergeLinkedLists(l1,l2);
  }
}
