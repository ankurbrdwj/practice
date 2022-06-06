package com.ankur.interview.strings;

public class Palindrome {
    public static void main(String[] args) {
        String str = "babcbab";
        boolean result = isPalindrome(str);
        System.out.println(result);
    }

    public static boolean isPalindrome(String str) {
        char[] array = str.toCharArray();
        int lIndex = 0;
        int rIndex = array.length - 1;
        while(lIndex<rIndex){
            if(array[lIndex] != array[rIndex]){
                return false;
            }
            lIndex++;
            rIndex--;
        }
        return true;
    }
}
