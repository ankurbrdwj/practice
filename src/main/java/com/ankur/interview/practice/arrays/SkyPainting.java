package com.ankur.interview.practice.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class SkyPainting {
  /*
  / count the strokes in which new york building skyline can be painted
  booking.com interview
   */
  // you can also use imports, for example:
// import java.util.*;
    public int solution(int[] A) {
      // write your code in Java SE 8
      int strokes =1;
      Deque<Integer> stack = new ArrayDeque<>();
      stack.push(A[0]);
      int N = A.length;
      for(int i=1 ;i< N ;i++){
        if(A[i] == stack.peek()){
          continue;
        } else if (A[i] > stack.peek()){
          stack.push(A[i]);
          strokes++;
        } else {
          while(!stack.isEmpty() && A[i]<stack.peek()) {
            stack.pop();
          }
          if(!stack.isEmpty()&& A[i]==stack.peek()) {
            continue;
          }
          stack.push(A[i]);
          strokes++;
        }


      }
      return strokes;

    }
  }
