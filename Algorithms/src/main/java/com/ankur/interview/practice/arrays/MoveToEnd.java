package com.ankur.interview.practice.arrays;

import java.util.List;

import static java.util.Collections.swap;

public class MoveToEnd {
/*
/ if left pointer is equal to toMove and right isnt the swap else r--
 */
  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    int l =0 ;
     int r = array.size()-1;
     while(l<r) {
       if (array.get(l) == toMove) {
         if (array.get(r) == toMove) {
           r--;
         } else {
           swap(array, l, r);
         }
       } else {
         if (array.get(r) == toMove) {
           r--;
         } else {
           l++;
         }
       }
     }
    return array;
  }
}
