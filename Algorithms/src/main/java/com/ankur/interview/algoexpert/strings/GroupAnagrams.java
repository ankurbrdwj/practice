package com.ankur.interview.algoexpert.strings;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(List<String> words) {
        List<List<String>> result = new ArrayList<>();
        List<String> copy = words.subList(0, words.size() - 1);
        for (String word : words) {
            List<String> list = getAnagrams(word, copy);
            if (list.size() != 0)
                result.add(list);
            list.forEach(copy::remove);
        }
        return result;
    }

    private static List<String> getAnagrams(String input, List<String> words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (isAnagram(input, word)) {
                list.add(word);
            }
        }
        return list;
    }

    private static boolean isAnagram(String word, String other) {
        int[] ascii1 = new int[256];
        int[] ascii2 = new int[256];
        char[] a = word.toCharArray();
        char[] b = other.toCharArray();
        for (int i = 0; i < a.length; i++) {
            ascii1[a[i]]++;
        }
        for (int i = 0; i < b.length; i++) {
            ascii2[b[i]]++;
        }
        for (int i = 0; i < 256; i++) {
            if (ascii1[i] != ascii2[i]) {
                return false;
            }
        }

        return true;
    }

    static String sortString(String str) {
        // Hash array to keep count of characters.
        int letters[] = new int[256];
        // Traverse string and increment
        // count of characters
        for (char x : str.toCharArray()) {
            // 'a'-'a' will be 0, 'b'-'a' will be 1,
            // so for location of character in count
            // array we will do str[i]-'a'.
            letters[x]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < letters[i]; j++) {
                sb.append((char) i);
            }
        }
        return sb.toString();
    }

    public static List<List<String>> getAnagrams(List<String> words) {
        // Write your code here.
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            String key = sortString(word);
            if (!map.containsKey(key)) {
                List<String> value = new ArrayList<>();
                value.add(word);
                map.put(key, value);
            } else {
                map.get(key).add(word);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        if (sortString("oyoy").equalsIgnoreCase(sortString("yoyo"))) {
            System.out.printf("true");
        }
        ;
    }
}
