package com.ankur.interview.practice.strings;

public class OneEditAway {
    public static void main(String[] args) {
        String first = "offer";
        String second = "bale";
        System.out.println(isOneEditAway(first,second));
    }

    private static boolean isOneEditAway(String first, String second) {
        int count =0;
        for(int i=0;i<first.length()&& i<second.length();i++){
            if(((int)first.charAt(i)^(int)second.charAt(i)) !=0 ){
                count++;
            }
        }
        return count <= 1;
    }
}
