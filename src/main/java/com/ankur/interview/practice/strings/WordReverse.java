package com.ankur.interview.practice.strings;

import com.ankur.interview.princeton.fundamentals.bagsqueuestacks.Stack;

public class WordReverse {
  public static String reverseWordsInSentence(String input) {
    //String[] words = input.split("");
    StringBuilder build = new StringBuilder();
    char[] array = input.toCharArray();
    Stack<Character> stack= new Stack<>();
    for (int i = 0; i < array.length; i++) {
          if(array[i]!= ' '){
            stack.push(array[i]);
          } else if (array[i]== ' '|| i== array.length-1) {
            while(!stack.isEmpty()){
              build.append(stack.pop());
            }
            build.append(' ');
          }
    }
    return build.toString();
  }
}
