package com.ankur.interview.algoexpert.strings;

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
            if (sb1.charAt(l) != sb2.charAt(l)) {
                return  false;
            }else if(sb1.charAt(l+1) > sb2.charAt(l+1)){
                return false;
            }
            l=l+2;
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
}
