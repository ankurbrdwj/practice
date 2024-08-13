package com.ankur.interview.practice.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestAnagramIndexes {
  /*
  /Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
   */
  @Test
  public void testIndexes() {
    String input = "cbaebabacd";
    String p = "abc";
    List<Integer> expected = new ArrayList<>();
    expected.add(0);
    expected.add(6);
    List<Integer> actual = AnagramIndexes.findAnagrams(input, p);
    Assertions.assertEquals(expected, actual);
  }
  @Test
  public void testIndexes2() {
    String input = "abab";
    String p = "ab";
    List<Integer> expected = new ArrayList<>();
    expected.add(0);
    expected.add(1);
    expected.add(2);

    List<Integer> actual = AnagramIndexes.findAnagrams(input, p);
    Assertions.assertEquals(expected, actual);
  }
}
