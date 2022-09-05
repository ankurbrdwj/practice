package com.ankur.interview.practice.arrays;

import java.util.Iterator;
import java.util.Stack;

public class BackspaceString {
  public boolean backspaceCompare(String s, String t) {
    String result1 = getFormatted(s);
    String result2 = getFormatted(t);
    return result1.equals(result2);
  }

  public static String getFormatted(String input){
    StringBuilder result = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    for(char c :input.toCharArray()){
      if('#'==c){
        if(!stack.isEmpty())
        stack.pop();
      }else{
        stack.push(c);
      }
    }
    Iterator<Character> itr = stack.iterator();
    while(itr.hasNext()){
      result.append(itr.next());
    }
    return result.toString();
  }
}
