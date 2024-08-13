package com.ankur.interview.practice.strings;

import java.util.ArrayList;
import java.util.List;
/*
is String a permutation odf palindrome/
 */
public class PermutationPalindrome {
    public static void main(String[] args) {
        String input = "abb";
        boolean isPermutation = findPalindromePermutationUsingArray(input.toCharArray());
        System.out.println(isPermutation);
        isPermutation = findPalindromePermutationUsingList(input.toCharArray());
        System.out.println(isPermutation);

    }

    private static boolean findPalindromePermutationUsingList(char[] charArray) {
        List<Character> list = new ArrayList<>();
        int size = charArray.length;
        for (int i = 0; i < size; i++) {
            if (list.contains(charArray[i])) {
                list.remove((Character) charArray[i]);
            } else {
                list.add(charArray[i]);
            }
        }
        if (size % 2 == 0 && list.size() == 0)
            return true;
        if (size % 2 == 1 && list.size() == 1)
            return true;
        return false;
    }

    private static boolean findPalindromePermutationUsingArray(char[] input) {
        char[] chars = new char[input.length];
        int size = input.length;
        for (int i = 0; i < size; i++) {
            int index = myLinearSearch(chars, input[i]);
            if (index >= 0) {
                chars[index] = 0;
            } else {
                chars[i] = input[i];
            }
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            if ((int) chars[i] != 0) {
                count++;
            }
        }
        if (size % 2 == 0 && count == 0) {
            return true;
        } else if (size % 2 == 1 && count == 1) {
            return true;
        }
        return false;
    }

    private static int myLinearSearch(char[] chars, char c) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                return i;
            }
        }
        return -1;
    }

}
