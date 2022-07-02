package com.ankur.interview.practice.strings;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StringPermutations {


    public static List<String> getStringPermutations(String input) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> sortedCharMap = new TreeMap();
        for (char item : input.toCharArray()) {
            sortedCharMap.compute(item, (k, v) -> { // bifunction
                if (v == null) {
                    return 1;
                } else {
                    return v + 1;
                }
            });
        }// unique char frequency count
        int[] count = new int[sortedCharMap.size()];
        // unique char string
        char[] str = new char[sortedCharMap.size()];
        // fill char and frequency
        int index = 0;
        for (Map.Entry<Character, Integer> entry : sortedCharMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        // char array derived from each branch
        char[] branch= new char[input.length()];
        // send then to tree recursive function with n! children and n depth
        permuteHelper( str,count,branch,0, result);
        return result;
    }

    private static void permuteHelper( char[] str, int[] count,char[] branch, int level, List<String> result) {

        if (level == branch.length) {
            result.add(new String(branch));
            return;
        } else {
            for (int j = 0; j < str.length; j++) {
                if(count[j]==0){
                    continue;
                }
                branch[level] = str[j];
                count[j]--;
                permuteHelper(str,count,branch,level+1,result);
                count[j]++;
            }
        }
    }
    public static void main(String args[]) {
        StringPermutations sp = new StringPermutations();
        getStringPermutations("AABC").forEach(s -> System.out.println(s));
    }

}
