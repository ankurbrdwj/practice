package com.ankur.interview.algexp.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringExtension {

    /* Find if one string is extension of the other airbnb interview question
    / if s2 ia extension of s like s2: heellooo is extension of s1: hello hence return true
    but is s1: hello and s2: hhhhheeeeeeeloooooo th return false
     */

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
