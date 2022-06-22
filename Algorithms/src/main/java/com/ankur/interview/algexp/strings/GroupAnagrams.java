package com.ankur.interview.algexp.strings;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(List<String> words) {
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

    static String sortString(String str) {
        int letters[] = new int[256];

        for (char x : str.toCharArray()) {
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
}

