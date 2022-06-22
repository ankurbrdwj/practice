package com.ankur.interview.algexp.strings;

import java.util.ArrayList;
import java.util.List;

public class Underscorify {
    public static String underscorifySubstring(String str, String substring) {
        // Write your code here.
        char[] a = str.toCharArray();
        StringBuilder word = new StringBuilder();
        int start = 0;
        int i = 0;
        int[] array = new int[a.length];
        List<Integer> list = new ArrayList<>();
        int k = 0;
        while (i < a.length) {
            word.append(a[i]);
            if (substring.equals(word.toString())) {
                array[k] = start;
                array[k + 1] = i;
                k = k + 2;
                list.add(start);
                list.add(i);
                word = new StringBuilder();
                start = i;
            }
            if (a[i] == ' ') {
                word = new StringBuilder();
                start = i;
            }
            i++;
        }
        List<Integer> copy = new ArrayList<>();
        int m = 0;
        while (m < list.size() - 1) {
            if (list.get(m).equals(list.get(m + 1))) {
                m = m + 2;
                continue;
            }
            copy.add(list.get(m));
            m++;
        }
        StringBuilder sb = new StringBuilder(str);
        int j = 0;
        for (Integer index : copy) {
            sb = sb.insert(index.intValue() + j, '_');
            j = j + 2;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //String result = underscorifySubstring("testthis is a testtest to see if testtesttest it works", "test");
        String result = underscorifySubstring2("testthis is a testtest to see if testtesttest it works", "test");
        System.out.println(result);
    }

    private static String underscorifySubstring2(String s, String test) {
        List<Integer[]> list = getLocations(s, test);
        list = collapse(list);
        return underscorify(s, list);
    }

    public static List<Integer[]> getLocations(String str, String subString) {
        List<Integer[]> list = new ArrayList<>();
        int start = 0;
        while (start < str.length()) {
            int next = str.indexOf(subString, start);
            if (next != -1) {
                Integer[] a = new Integer[]{next, next + subString.length()};
                list.add(a);
                start = next + 1;
            } else {
                break;
            }
        }
        return list;
    }

    public static List<Integer[]> collapse(List<Integer[]> list) {
        if (list.size() == 0) {
            return list;
        }
        List<Integer[]> newList = new ArrayList<>();
        newList.add(list.get(0));
        Integer[] prev = newList.get(0);
        for (int i = 1; i < list.size(); i++) {
            Integer[] current = list.get(i);
            if (current[0] <= prev[1]) {
                prev[1] = current[1]; // last current added will change
            } else {
                newList.add(current);
                prev = current;
            }
        }
        return newList;
    }

    public static String underscorify(String str, List<Integer[]> list) {
        int strIdx = 0;
        int locationIdx = 0;
        boolean inBetween = false;
        List<String> result = new ArrayList<>();
        int i = 0;
        while (strIdx < str.length() && locationIdx < list.size()) {
            if (strIdx == list.get(locationIdx)[i]) {
                result.add("_");
                inBetween = !inBetween;
                if (!inBetween) {
                    locationIdx++;
                }
                i = i == 1 ? 0 : 1;
            }
            result.add(String.valueOf(str.charAt(strIdx)));
            strIdx++;
        }
        if (locationIdx < list.size()) {
            result.add("_");
        } else if (strIdx < str.length()) {
            result.add(str.substring(strIdx));
        }
        return String.join("", result);
    }
}
