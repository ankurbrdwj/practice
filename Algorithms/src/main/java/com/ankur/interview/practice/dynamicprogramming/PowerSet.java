package com.ankur.interview.practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {


    public static int[] toBinaryVarLength(int num) {
        String str = toBinary(num);
        int[] result = new int[str.length()];
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++)
            result[i] = Character.getNumericValue(c[i]);
        return result;
    }

    private static String toBinary(int num) {
        String str = "";
        while (num > 0) {
            int i = num % 2;
            str = i + str;
            num = num / 2;
        }
        return str;
    }

    public static int[] toBinaryFixedLength(int num, int len) {
        int[] result = new int[len];
        char[] c = toBinary(num).toCharArray();
        int i = c.length - 1;
        for (int j = result.length - 1; j >= 0; j--) {
            if (i >= 0) {
                result[j] = Character.getNumericValue(c[i]);
                i--;
            } else {
                result[j] = 0;
            }
        }
        /*} else {
            for (int i = 0; i < result.length; i++)
                if (c.length != 0 && c.length == result.length) {
                    result[i] = Character.getNumericValue(c[i]);
                }
        }*/
        return result;
    }

    private static void prepend(char[] s, int[] b) {
        int[] a = new int[s.length];
        for (Character i : s) {
            a[i] = Character.getNumericValue(s[i]);
        }
        int aLen = s.length;
        int bLen = b.length;
        int[] c = new int[aLen + bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
    }

    public static void main(String[] args) {

        int[] a = toBinaryVarLength(4);
        for (Integer i : a) {
            System.out.print(i);
        }
        int[] array = {1, 2, 3};
        List<List<Integer>> ans = getPowerSet(array);
        for (List<Integer> item : ans) {
            for (Integer i : item) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }

    }

    private static List<List<Integer>> getPowerSet(int[] array) {
        int row = (int) Math.pow(2, array.length);
        int col = array.length;
        int[][] bitset = new int[row][col];
        int arrayLength = toBinary(row).length();
        for (int i = 0; i < row; i++) {
            bitset[i] = toBinaryFixedLength(i, array.length);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < row; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                if (bitset[i][j] == 1) {
                    temp.add(array[j]);
                }
            }
            result.add(new ArrayList<>(temp));
        }
        return result;
    }
}
