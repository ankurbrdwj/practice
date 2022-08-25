package com.ankur.interview.practice.strings;

import org.junit.jupiter.api.Test;

public class TestIntegerToEnglish {

  @Test
  public void testIntegerToEnglish(){
    Integer input = 1234;
    String output = "One thousand two hundred thirty four";
    String expected = IntegerToEnglish.convertIntToEnglish(input);
  }
}
