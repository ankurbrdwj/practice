package com.ankur.interview.practice.strings;

import java.util.Scanner;

/*
Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures/
1.  int has 32 bits and chars a to z are 26
2.  get relative position of char from a and set (OR) that position bit to 1 via << shift left mask
3.  if already set to 1 then 1 AND 1 will be more then 0
 */
public class UniqueChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String reply;
        do {
            System.out.println("\nEnter string to check unique chars : ");
            String input = scanner.next();
            char[] array = input.toCharArray();
            int checker = 0;
            boolean result = hasUniqueChars(checker, array);
            System.out.println("Does " + input + " has unique characters ? : " + result);
            System.out.println("Wanna try another one Y/N : ");
            reply = scanner.next();
        } while (reply.equalsIgnoreCase("Y"));
        scanner.close();
    }

    private static boolean hasUniqueChars(int checker, char[] array) {
        for (int i = 0; i < array.length; i++) {
            int val = array[i] - 'a';
            int relativeBitPosition = 1 << val;
            if ((checker & relativeBitPosition) > 0) {
                return false;
            }
            checker = checker | relativeBitPosition; //bitwise OR
        }
        return true;
    }
}
