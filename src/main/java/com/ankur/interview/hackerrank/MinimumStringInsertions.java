package com.ankur.interview.hackerrank;

public class MinimumStringInsertions {

    public static int getMinInsertion(String input, int start, int end) {
        if (start > end) {
            return Integer.MAX_VALUE;
        }
        if (start == end) {
            return 0;
        }
        if (start == end - 1) {
            return input.charAt(start) == input.charAt(end) ? 0 : 1;
        }
        if (input.charAt(start) == input.charAt(end)) {
            return getMinInsertion(input, start + 1, end - 1);
        } else {
            return Math.min(getMinInsertion(input, start + 1, end), getMinInsertion(input, start, end - 1))+1;
        }
    }

    public static void main(String[] args) {
        String input= "BrilliantForever";
        int result = getMinInsertion(input,0,input.length()-1);
        System.out.println(result);
    }
}
