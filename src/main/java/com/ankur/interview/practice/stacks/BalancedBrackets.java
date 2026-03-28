package com.ankur.interview.practice.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BalancedBrackets {

    public static boolean balancedBrackets(String str) {
        char[] a = str.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '{' || (a[i] == '(') || (a[i] == '[')) {
                stack.push(a[i]);
            } else if (a[i] == '}' || (a[i] == ')') || (a[i] == ']')) {
                if (stack.isEmpty())
                    return false;
                if (a[i] == '}' && stack.pop() != '{')
                    return false;
                if (a[i] == ')' && stack.pop() != '(')
                    return false;
                if (a[i] == ']' && stack.pop() != '[')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                characterStack.push(')');
            else if (c == '{')
                characterStack.push('}');
            else if (c == '[')
                characterStack.push(']');
            else if (c == ')' || c == '}' || c == ']') {
                if (c != characterStack.pop())
                    return false;
            }
        }
            return characterStack.isEmpty();
        }

        public static void main (String[] args){
            System.out.println(isValid("({my name is  [oops] i} forgot)"));
            System.out.println(isValid("({[]})"));
        }
    }
