package com.ankur.interview.practice.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringExtension {

    /* Find if one string is extension of the other airbnb interview question
    / if s2 ia extension of s like s2: heellooo is extension of s1: hello hence return true
    but is s1: hello and s2: hhhhheeeeeeeloooooo th return false
     */

    // s2 is extension of s1 if:
    // - same sequence of character groups
    // - each group in s2 has count >= corresponding group in s1
    // "hello" -> groups: (h,1),(e,1),(l,2),(o,1)
    // "heellooo" -> groups: (h,1),(e,2),(l,2),(o,3)  -> extension: true
    // "hhhhheeeeeeeloooooo" -> groups: (h,5),(e,7),(l,1),(o,6) -> l=1 < 2: false
    public static boolean isStringExtension(String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j)) return false;
            char ch = s1.charAt(i);
            int count1 = 0, count2 = 0;
            while (i < s1.length() && s1.charAt(i) == ch) { count1++; i++; }
            while (j < s2.length() && s2.charAt(j) == ch) { count2++; j++; }
            if (count2 < count1) return false;
        }
        return i == s1.length() && j == s2.length();
    }

    public boolean isExtension(String s1, String s2) {
        StringBuilder sb1 = encodeString(s1);
        StringBuilder sb2 = encodeString(s2);
        int l = 0;
        while (l < sb1.length()) {
            if (sb1.charAt(l) != sb2.charAt(l)) {       // character should match
                return false;
            } else if (sb1.charAt(l + 1) > sb2.charAt(l + 1)) { // the frequency in order should match
                return false;
            }
            l = l + 2;
        }
        return true;
    }

    // Encodes a string into (char, frequency) pairs.
    // input:  "heellooo"
    // output: "h1e2l2o3"
    //
    // Trace with "heellooo":
    //
    //   l=0  array[l]='h'  r=0→1  freq=1  → append 'h','1'  l=1   result="h1"
    //   l=1  array[l]='e'  r=1→3  freq=2  → append 'e','2'  l=3   result="h1e2"
    //   l=3  array[l]='l'  r=3→5  freq=2  → append 'l','2'  l=5   result="h1e2l2"
    //   l=5  array[l]='o'  r=5→8  freq=3  → append 'o','3'  l=8   result="h1e2l2o3"
    //   l=8  == array.length → stop
    public StringBuilder encodeString(String input) {
        StringBuilder result = new StringBuilder();
        char[] array = input.toCharArray();
        int l = 0;              // current char
        while (l < array.length) {
            int currentFrequency = 0;
            int r = l;          // next char
            while (r < array.length && array[l] == array[r]) {
                currentFrequency++;         // repeated chars
                r++;
            }
            if (currentFrequency > 0) {
                result.append(input.charAt(l)).append(currentFrequency);
                l = l + currentFrequency;       // next after repeated
            } else if (array[l] != array[r]) {
                result.append(input.charAt(l)).append(1);
                l++;
            }
        }
        return result;
    }

    public static boolean stringExtension(String s1, String s2) {
        String first;
        String second;
        if (s1.length() > s2.length()) {
            first = s2;
            second = s1;
        } else {
            second = s2;
            first = s1;
        }
        Map<Character, Integer> freq1 = new LinkedHashMap<>();
        Map<Character, Integer> freq2 = new LinkedHashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            freq1.put(s1.charAt(i), freq1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            freq2.put(s2.charAt(i), freq2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s1.length(); i++) {
            char key = s1.charAt(i);
            if(freq1.size() != freq2.size() || !freq2.containsKey(key) || freq2.get(key)<freq1.get(key)){
                return false;
            }
        }
        return true;
    }
    public static boolean checkSequence(String a, String b) {
        //if length of the b = 0
        //then we return true
        if(b.length()==0)
            return true;

        //if length of a = 0
        //that means b is not present in
        //a so we return false
        if(a.length() == 0)
            return false;

        if(a.charAt(0) == b.charAt(0))
            return checkSequence(a.substring(1), b.substring(1));
        else
            return checkSequence(a.substring(1), b);
    }

    static boolean solve(String s1, String s2)
    {
        // Get the first character of both Strings
        String a = getString(s1.charAt(0)),
                b = getString(s2.charAt(0));

        // Now if there are adjacent similar character
        // remove that character from s1
        for (int i = 1; i < s1.length(); i++)
            if (s1.charAt(i) != s1.charAt(i - 1))
            {
                a += getString(s1.charAt(i));
            }

        // Now if there are adjacent similar character
        // remove that character from s2
        for (int i = 1; i < s2.length(); i++)
            if (s2.charAt(i) != s2.charAt(i - 1))
            {
                b += getString(s2.charAt(i));
            }

        // If both the Strings are equal
        // then return true
        if (a.equals(b))
            return true;

        return false;
    }

    static String getString(char x)
    {
        // String class has a constructor
        // that allows us to specify size of
        // String as first parameter and character
        // to be filled in given size as second
        // parameter.
        String s = String.valueOf(x);
        return s;
    }
    public static void main(String[] args) {
        String s1 = "Heeellllloooo";
        String s2 = "Hello";
        boolean result = solve(s1,s2);
        System.out.println(result);
    }
}
