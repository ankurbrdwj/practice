package com.ankur.interview.practice.dyanamicprogramming;

import com.ankur.interview.practice.dynamicprogramming.JuicePackaging;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestJuicePackaging {

  @Test
  void testJuiceBottlingDP(){
    var input = new int[] {0,1,3};
    var expected = new int[] {2};
    var actual = new JuicePackaging().juiceBottlingDP(input);
    Assertions.assertEquals(expected.length, actual.size());
    for (int i = 0; i < actual.size(); i++) {
      Assertions.assertEquals(expected[i], (int) actual.get(i));
    }
  }
}
