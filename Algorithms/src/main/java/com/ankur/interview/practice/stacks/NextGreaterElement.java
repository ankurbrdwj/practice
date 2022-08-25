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
    for (int i = 2 * array.length - 1; i >= 0; i--) {
      int index = i % array.length;
      while (!stack.isEmpty()) {
        if (stack.peek() < array[index]) {
          stack.pop();
        } else {
          result[index] = stack.peek();
          break;// when there is no greater elememt in stack
        }
      }
      stack.push(array[index]);
    }
    return result;
  }

  public int[] nextGreaterIndex(int[] array) {
    int[] result = new int[array.length];
    Arrays.fill(result, -1);
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < 2 * array.length; i++) {
      int cIndex = i % array.length;
      while (!stack.isEmpty() && array[stack.peek()] < array[cIndex]) {
        int top = stack.pop();
        result[top] = array[cIndex];
      }
      stack.push(cIndex);
    }
    return result;
  }
}
