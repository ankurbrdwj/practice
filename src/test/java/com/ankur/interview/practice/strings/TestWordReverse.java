package com.ankur.interview.practice.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestWordReverse {
  @Test
  void testCase1(){
    String input = "the quick brown fox jumped over the lazy dog ";
    String result = WordReverse.reverseWordsInSentence(input);
    String expected = "";
    Assertions.assertEquals(expected,result);
  }
}
