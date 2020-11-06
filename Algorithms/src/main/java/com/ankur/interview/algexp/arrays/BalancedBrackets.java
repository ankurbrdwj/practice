package com.ankur.interview.algexp.arrays;
import java.util.*;
public class BalancedBrackets {

    public static boolean balancedBrackets(String str) {
        char[] a= str.toCharArray();
        Deque<Character> stack= new ArrayDeque<>();
        for(int i=0;i<a.length;i++){
            if(a[i]=='{' || (a[i]=='(') ||(a[i]=='[')){
                stack.push(a[i]);
            }else if (a[i]=='}' || (a[i]==')') ||(a[i]==']')) {
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
}
