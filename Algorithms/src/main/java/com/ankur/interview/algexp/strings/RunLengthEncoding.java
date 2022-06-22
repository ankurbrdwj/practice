package com.ankur.interview.algexp.strings;

public class RunLengthEncoding {

        public static String runLengthEncoding(String input) {
            // Write your code here.
            StringBuilder result = new StringBuilder();
            char[] array = input.toCharArray();
            int l = 0;              // current char
            while (l < array.length) {
                int currentFrequency = 0;
                int r = l;          // next char
                while (r < array.length && array[l] == array[r]) {
                    currentFrequency++;         // repeated chars
                    r++;
                }
                if (currentFrequency > 9) {
                    int f = currentFrequency;
                    while(f > 9){
                        result.append("9").append(input.charAt(l));
                        l = l + 9;
                        f = f - 9;
                    }
                    result.append(f).append(input.charAt(l));
                    l = l + f;       // next after repeated
                } else if(currentFrequency <= 9){
                    result.append(currentFrequency).append(input.charAt(l));
                    l = l + currentFrequency;
                } else if (array[l] != array[r]) {
                    result.append(currentFrequency).append(input.charAt(l));
                    l++;
                }
            }
            return result.toString();
        }

    public static void main(String[] args) {
        System.out.println(runLengthEncoding("........______=========AAAA   AAABBBB   BBB"));
    }
    }

