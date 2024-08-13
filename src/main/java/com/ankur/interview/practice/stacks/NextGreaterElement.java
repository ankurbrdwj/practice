package com.ankur.interview.practice.stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
/ return an array with next greater element in that index
   input =>  {2, 5, -3, -4, 6, 7, 2}
   expected =>  {5, 6, 6, 6, 7, -1, 5}

 */
public class NextGreaterElement {
  public int[] nextGreaterElement(int[] array) {
    int[] result = new int[array.length];
    Arrays.fill(result, -1);
    Deque<Integer> stack = new ArrayDeque<>();

    // Loop through the array twice to handle circular array
    for (int i = 2 * array.length - 1; i >= 0; i--) {
      int index = i % array.length;
      while (!stack.isEmpty() && stack.peek() <= array[index]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        result[index] = -1; // Set -1 for elements without next greater element
      } else if (result[index] == -1) {
        result[index] = stack.peek();
      }
      stack.push(array[index]);
    }
    return result;
  }
  public int[] nextGreaterIndex(int[] array) {
    int[] result = new int[array.length];
    Arrays.fill(result, -1);
    Deque<Integer> stack = new ArrayDeque<>();

    // Loop through the array twice to handle circular array
    for (int i = 2 * array.length - 1; i >= 0; i--) {
      int index = i % array.length;
      while (!stack.isEmpty() && stack.peek() <= array[index]) {
        stack.pop();
      }
      if (result[index] == -1 && !stack.isEmpty()) {
        result[index] = stack.peek();
      }
      stack.push(array[index]);
    }
    return result;
  }
}
