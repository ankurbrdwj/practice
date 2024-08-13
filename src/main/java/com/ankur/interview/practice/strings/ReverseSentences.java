package com.ankur.interview.practice.strings;

import java.util.Stack;

public class ReverseSentences {
  // ING Bank interview
  // String question reverse the words in sentence
  // without using any inbuild method like split or reverese
  public static void main(String[] args) {
    String input = "My name is anthony gonzalvez";
    String reversed = reverseSentence(input);
    System.out.printf(reversed);
  }

  private static String reverseSentence(String input) {
    String[] words = input.split(" ");
    StringBuilder builder = new StringBuilder();
    for (String word : words) {
      char[] runes = word.toCharArray();
      char[] reverseWord = reverseWord(runes);
      builder.append(reverseWord).append(" ");
    }
    return builder.toString();
  }

  private static char[] reverseWord(char[] runes) {
    char[] reverseWord = new char[runes.length];
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < runes.length; i++) {
      stack.push(Character.valueOf(runes[i]));
    }
    for (int i = 0; i < reverseWord.length; i++) {
      reverseWord[i] = stack.pop().charValue();
    }
    return reverseWord;
  }
}
