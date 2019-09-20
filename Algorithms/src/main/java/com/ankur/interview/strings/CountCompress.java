package com.ankur.interview.strings;

public class CountCompress {
    public static void main(String[] args) {
        String input = "aaabbddccjeeffjea";
        System.out.println(compressByCount(input));
    }

    private static String compressByCount(String input) {
        int[] count = new int[256];
        for (int i = 0; i < input.length(); i++) {
            count[(int) input.charAt(i)]++;
        }
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < count.length; j++) {
            char item =(char)j;
            if(count[j] == 1){
                result.append(item);
            }if(count[j]>1){
                result.append(item).append(count[j]);
            }
        }
        return result.length() == input.length() ?input:result.toString();
    }
}
