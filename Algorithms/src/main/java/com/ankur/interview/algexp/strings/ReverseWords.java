package com.ankur.interview.algexp.strings;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {
    public static String reverseWordinString(String string) {
        // Write your code here.
        List<String> wordList = new ArrayList<String>();
        char[] a = string.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == ' ') {
                wordList.add(builder.toString());
                builder = new StringBuilder();
            } else {
                builder.append(a[i]);
            }
        }
        wordList.add(builder.toString());
        int l = 0;
        int r = wordList.size() - 1;
        while (l < r) {
            swap(l, r, wordList);
            l++;
            r--;
        }
        StringBuilder result = new StringBuilder();
        wordList.stream()
                .forEach(item -> result.append(item).append(" "));
        return result.toString();
    }

    public static void swap(int l, int r, List<String> wordList) {
        String temp = wordList.get(l);
        wordList.set(l, wordList.get(r));
        wordList.set(r, temp);
    }

    public static void main(String[] args) {
        System.out.println(reverseWordinString("AlgoExpert is the best!"));
    }
}
