package com.ankur.interview.practice.stacks;

import java.util.ArrayList;

/*
/ array represents stack with last element as top
create pop methpd and append to add at end of array
peek method to return top element without removing
write function to sort the stack in place recursively where the first(bottom) element will be smallest ,
 last(top) element will be largest
      ArrayList<Integer> stack = new ArrayList<Integer>(Arrays.asList(-5, 2, -2, 4, 3, 1));
      ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(-5, -2, 1, 2, 3, 4));
1) empty the arraylist recursively
2) each stack frame will have top element with function stack memory
3) once the stack is empty function stacks will rollback
4) that's when you start inserting elements with insert function
5) In insert function only insert one element at time
6) If stack is empty we can insert or when top(last element) is less than valuetoinsert
7) if not , then remove top and call insert with valuetoinsert
8) then add top element
return stack answer


 */
public class ArrayAsStack {
  public ArrayList<Integer> sortRecursively(ArrayList<Integer> stack) {
    if (stack.size() == 0) {
      return stack;
    }
    int top = stack.remove(stack.size() - 1);
    sortRecursively(stack);
    insertRecursively(stack, top);
    return stack;
  }

  private void insertRecursively(ArrayList<Integer> stack, int value) {
    if (stack.size() == 0 || stack.get(stack.size() - 1) <= value) {
      stack.add(value);
      return;
    }
    int top = stack.remove(stack.size() - 1);
    insertRecursively(stack, value);
    stack.add(top);
  }

}
