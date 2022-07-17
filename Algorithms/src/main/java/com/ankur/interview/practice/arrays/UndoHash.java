package com.ankur.interview.practice.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class UndoHash {
  /*
  /Given a string "ABC#DD#E", for every # consider it as a back space. Output the final string.
  For example, in the above string answer will be "ABDE". SImilary "A##BB#E##F" will output "F" (Use stack)
This was extended saying if you see @ consider it as a redo, how do you implement it.
For example, A#@BB#E#F will output "ABF"
/*
This was extended saying if you see @ consider it as a redo, how do you implement it.
For example, A#@BB#E#F will output "ABF"/
 */

  public static String hashBackspace(String input) {
    Deque<Character> stack = new ArrayDeque<>();
    Deque<Character> redo = new ArrayDeque<>();
    char[] array = input.toCharArray();
    for (Character c : array
    ) {
      if ('#' == c && !stack.isEmpty()) {
        redo.push(stack.pop());
      } else if ('@' == c) {
        stack.push(redo.pop());
      } else {
        stack.push(c);
      }
    }
    StringBuilder sb = new StringBuilder();
    Deque<Character> stack2 = new ArrayDeque<>();
    while (!stack.isEmpty()) {
      stack2.push(stack.pop());
    }
    while (!stack2.isEmpty()) {
      sb.append(stack2.pop());
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String input = "A#@BB#E#F";
    System.out.println(hashBackspace(input));
  }
}
