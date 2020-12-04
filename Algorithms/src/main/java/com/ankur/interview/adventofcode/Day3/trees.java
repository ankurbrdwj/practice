package com.ankur.interview.adventofcode.Day3;

import java.util.Scanner;

public class trees {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int index =0;
        boolean isValid = false;
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if(index<input.length()-3) {
                for (int i = index; i < index + 3; i++) {
                    if (input.charAt(i) == '#')
                        count++;
                }
            }
            index=index+3;
        }
        System.out.println(count);
        //scanner.close();
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
