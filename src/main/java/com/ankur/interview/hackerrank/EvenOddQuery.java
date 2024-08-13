package com.ankur.interview.hackerrank;

import java.util.Scanner;

public class EvenOddQuery {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int queries = in.nextInt();
        String[] result = new String[queries];
        int[][] query =new int[queries][2];
        for (int j = 0; j < queries; j++) {
            int x = in.nextInt();
            int y = in.nextInt();
           query[j][0]=x;
           query[j][1]=y;
        }
        //in.close();
        result=find(array,query);
        for (String ans : result) {
            System.out.println(ans);
        }
    }

    private static String[] find(int[] array, int[][] queries) {
            String[] result = new String[queries.length];
            for(int j =0; j<queries.length;j++){
                double ans =solveInternal(array ,queries[j][0],queries[j][1]);
                if (ans % 2 != 0) {
                    result[j]="Odd";
                } else {
                    result[j]="Even";
                }
            }
       return result;
    }

    private static double solveInternal(int[] array, int x, int y) {
        if (x > y) return 1;
        double result= Math.pow(array[x-1], solveInternal(array, x + 1, y));
        return result;
    }
}
