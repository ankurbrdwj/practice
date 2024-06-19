package com.ankur.interview.practice.lists;

public class DetectLoop {
/*
/ m+k is where f and s meet m= length before loop , k= length after loop
m+k is multiple of length on loop m+k= anyint * loop
if f travels m+k that means it has covered the loop anyint times
they meet when f is k distance from start of loop , remaining distance from start of loop =m
detach  the s here and start from head for s ,
when both travel m they will meet at start of loop
#blind75
 */

  public static LinkedList findLoop(LinkedList head) {
    // Write your code here.
    LinkedList fp = head.next;//fast pointer
    LinkedList sp = head.next.next; //slowpointer
    while (fp != sp) {
      fp = fp.next;
      sp = sp.next.next;
    }
    sp = head;
    while (fp != sp) {
      fp = fp.next;
      sp = sp.next;
    }
    return fp;
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
