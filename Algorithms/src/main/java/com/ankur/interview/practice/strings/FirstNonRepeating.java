package com.ankur.interview.practice.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeating {

    public static int firstNonRepeatingCharacter(String string) {
        // Write your code here.
        Map<Integer,Integer> freq = new LinkedHashMap<>();
        char[] array = string.toCharArray();

        for(int i = 0 ; i<array.length;i++){
            int f = getFrequency(array[i],array);
            if(!freq.containsKey(i)){
                freq.put(i,f);
            }else{

            }
        }
        for(Map.Entry<Integer,Integer>  entry: freq.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }
    public static int getFrequency(char c , char[] array){
        int [] freq = new int[26];
        for(int i = 0;i<array.length;i++){
            int ascii = (int) array[i];
            freq[ascii-'a']++;
        }
        return freq[c-'a'];
    }

    public static void main(String[] args) {
        String string = "abcdafe";
        System.out.println(firstNonRepeatingCharacter(string));
    }
}
