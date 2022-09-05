package com.ankur.interview.practice.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBackspaceCompare {
  @Test
  public void testBackspaceString(){
    BackspaceString bs = new BackspaceString();
    String input1 = "y#fo##f" ;
    String input2 = "y#f#o##f";

    Assertions.assertTrue(bs.backspaceCompare(input1,input2));

  }
}
