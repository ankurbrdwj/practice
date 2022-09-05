package com.ankur.interview.practice.strings;

import java.util.ArrayList;
import java.util.List;

public class AnagramIndexes {
  public static List<Integer> findAnagrams(String s, String p) {
    List<Integer> ans = new ArrayList<>();
    // map of char frequency 128 ia all char possible
    int[] map = new int[128];
    // count of total frequency of all char will not be more than length of window
    int count = p.length();
    for (final char c : p.toCharArray())
      ++map[c];
    // when map will be empty and count will be zero we will get our anagram
    int left = 0;
    int right = 0;
    while (right < s.length()) {
      int charFreq = map[s.charAt(right)];
      map[s.charAt(right)] = map[s.charAt(right)] -1;
      right++;
      if (charFreq >= 1) {
        count--;
      }
      if (count == 0) {
        ans.add(left);
      }
      // if reached window size then slide the window ahead and increase values

      int nextCharCount = map[s.charAt(left)];
      if (right - left == p.length() &&  map[s.charAt(left++)]++  >= 0) {
        count++;
        //map[s.charAt(left)]++;
        //left++;
      }
     /* left++;
      map[s.charAt(left)] = map[s.charAt(left)]+1;*/
    }
    return ans;
  }
}
 /* public static List<Integer> findAnagrams(String s, String p) {
    int wSize = p.length();
    char[] window = p.toCharArray();
    Arrays.sort(window);
    String key = String.valueOf(window);
    List<Integer> res= new ArrayList<>();
    for(int i=0;i<s.length()-wSize; i++){
      char[] temp = s.substring(i,i+wSize).toCharArray();
      Arrays.sort(temp);
      String value = String.valueOf(temp);
      if(value.equals(key)){
        res.add(i);
      }
    }
    return res;
  }*/

