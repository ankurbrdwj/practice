package com.ankur.interview.practice.bitmanipulation;

import java.util.Scanner;

/*
Flip Bit to Win: You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to
find the length of the longest sequence of ls you could create. eg 1775 sample input
& with 1
11011101111 & 00000000001 ==1 ? currLen++: //track current length of ones
11011101111 & 000000000010 ==0 : prevLen=0:prevLen=currLen //if next bit is 1 the store in previous length
currLen=0
Math.Max(currlen+prevLen,maxlen)
 */

public class FlipBit {

    private static int maxSequenceOfOnes(int input) {
        int currLength = 0, prevLength = 0, maxLen = 0;
        while (input != 0) {
            if ((input & 1) == 1) {
                currLength++;
            } else if ((input & 1) == 0) {
                if ((input & 2) == 0) {
                    prevLength = 0;
                } else {
                    prevLength = currLength;
                }
                currLength = 0;
            }
            maxLen = Math.max(currLength + prevLength, maxLen);
            input = input >> 1;
        }
        return maxLen + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(",|\\s+");
        String reply;
        do {
            System.out.println("\nEnter integer to check  max sequence of one  : ");
            String number = scanner.next();
            int input = Integer.valueOf(number);
            int result = maxSequenceOfOnes(input);
            System.out.println("Max sequence of 1's in " + Integer.toBinaryString(input) + " : " + result);
            System.out.println("Max sequence of 1's in " + Bitwise.printBinary(input) + " : " + result);
            System.out.println("Wanna try another one Y/N : ");
            reply = scanner.next();
        } while (reply.equalsIgnoreCase("Y"));
        scanner.close();
    }
}
