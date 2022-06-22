package com.ankur.interview.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DelhiOddEven {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner in = new Scanner(System.in);
        int noOfCars = in.nextInt();
        List<String> input = new ArrayList<>();
        for (int i = 0; i < noOfCars; i++) {
            input.add(in.next());
        }
        List<String> result = isAllowedOnSunday(noOfCars, input);
        for (String ans : result) {
            System.out.println(ans);
        }
    }

    private static List<String> isAllowedOnSunday(int noOfCars, List<String> input) {
        List<String> result = new ArrayList<>();
        for (int j = 0; j < noOfCars; j++) {
            int oddSum = 0, evenSum = 0;
            char[] array = input.get(j).toCharArray();
            for (int k = 0; k < array.length; k++) {
                if ((k + 1) % 2 != 0) {
                    oddSum = oddSum + Integer.parseInt(String.valueOf(array[k]));
                } else {
                    evenSum = evenSum + Integer.parseInt(String.valueOf(array[k]));
                }
            }
            if (oddSum % 3 == 0 || evenSum % 4 == 0) {
                result.add("Yes");
            } else {
                result.add("No");
            }
            oddSum = 0;
            evenSum = 0;
        }
        return result;
    }
}
