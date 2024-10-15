package com.ankur.interview.practice.arrays;

public class BestSeatInARow {
  /*
  / Given a row of seats 0 and 1  find best seat with max space on both sides
    best seat will be is longest subarray of zero
   */
  public int bestSeat(int[] seats) {
    // Write your code here.
    int bestSeat =-1;
    int maxSpace=0;
    int left =0;
    while(left<seats.length){
      int right = left+1;
      while(right < seats.length && seats[right] == 0){
        right++;
      }
      int availableSpaces = right-left-1;
      if(availableSpaces > maxSpace){
        bestSeat=(left+right)/2;
        maxSpace=availableSpaces;
      }
      left = right;
    }
    return bestSeat;
  }
}
