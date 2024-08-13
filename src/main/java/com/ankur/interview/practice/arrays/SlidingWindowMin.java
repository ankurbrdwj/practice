package com.ankur.interview.practice.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
/*
1. Minimum Window Substring
The question asks us to return the minimum substring from the string S (Source)
which has all the characters of the string T (Target).
Let us call a substring desirable if it has all the characters from T./
 */
public class SlidingWindowMin {
  public static void main(String[] args) {
    String source = "adgbbigccdaik";
    String target = "abc";
    String minWindow = getMinWindow(source, target);
    System.out.println(minWindow);
  }

  private static String getMinWindow(String source, String target) {
    int left = 0;
    int right = 0;
    int start = 0;
    int minLen = Integer.MAX_VALUE;

    Map<Character, Long> window = new HashMap<>();
    Map<Character, Long> required;
    required = target.chars().mapToObj(c -> (char) c)
      .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    int match = 0;
    while (right < source.length()) {
      Character c = source.charAt(right);
      window.compute(c, (k, v) -> (v == null) ? 1 : v + 1);
      if (required.containsKey(c)) {
        if (window.get(c).equals(required.get(c))) {
          match++;
        }
      }
      right++;
      while (match == required.size()) {
        // moving left index and update minlen
        if (right - left < minLen) {
          start = left;
          minLen = right - left;
        }
        Character c2 = source.charAt(left);
        if (required.containsKey(c2)) {
          window.put(c2, window.get(c2) - 1);
          if (window.get(c2) < required.get(c2)) {
            match--;
          }
        }
        left++;
      }
    }
    return minLen == Integer.MAX_VALUE ? "" : source.substring(start, start + minLen);

  }
}
