package com.ankur.interview.algexp.strings;


import java.util.Stack;

public class BalancedString {
    public static int longestBalancedSubstring(String string) {
        return 0;

    }

    public static int solution1(String string) {
        int maxLength = 0;
        for (int i = 0; i < string.length(); i++) {
            for (int j = i+2; j < string.length()+1; j +=2) {
                if (isBalanced(string.substring(i,j))){
                    int curreLength = j-i;
                    maxLength = Math.max(maxLength,curreLength);
                }
            }
        }
        return maxLength;

    }

    private static boolean isBalanced(String substring) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<substring.length();i++){
            char  c = substring.charAt(i);
            if(c=='('){
                stack.push(c);
            }else if(stack.size() >0){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.size() ==0;
    }

    public static int solution2(String string) {
        return 0;

    }

    public static int solution3(String string) {
        return 0;

    }

    public static void main(String[] args) {
        String input = "(())";
        solution1(input);
    }
}
