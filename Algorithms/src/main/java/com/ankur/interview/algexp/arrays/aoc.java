package com.ankur.interview.algexp.arrays;

import java.util.Scanner;

public class aoc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        boolean isValid = false;
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if(!"".equalsIgnoreCase(input)) {
                String[] array = input.split(":");
                String[] array1 = array[0].split(" ");
                String[] array2 = array1[0].split("-");
                int min = Integer.parseInt(array2[0]);
                int max = Integer.parseInt(array2[1]);
                String c = array1[1];
                char x = c.charAt(0);
                if (getFreq(array[1].trim(), x, min, max)) {
                    count++;
                }
            }
        }
        System.out.println(count);
        scanner.close();
    }

    public static boolean getFreq(String input, char c, int min, int max) {
        char[] a = input.toCharArray();
        int[] freq = new int[26];
        for (int i = 0; i < a.length; i++) {
            freq[a[i] - 'a']++;
        }
        int index = c - 'a';
        if (freq[index] > min && freq[index] <= max)
            return true;
        else
            return false;
    }
}
