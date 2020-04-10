package com.ankur.interview.algoexpert.strings;

import java.util.LinkedHashSet;

public class StringExtension {
    /* Find if one string is extion of the other airbnb interview question
    / if s2 ia extension of s like s2: heellooo is extension of s1: hello hence return true
     */
    public boolean isExtension(String s1, String s2) {
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        int j = 0;
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < array1.length; i++) {
            set.add(array1[i]);
        }
        for (Character item : set) {
            if (item != array2[j]) {
                return false;
            } else {
                while (item == array2[j] && j< array2.length-1) {
                    j++;
                }
            }
        }
        return true;
    }

}
