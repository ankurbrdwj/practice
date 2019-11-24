package com.ankur.interview.arrays;

import java.io.IOException;
import java.util.Scanner;

public class SockMerchant {
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int max=0;
        for(int i=0;i<ar.length;i++){
            if(max<ar[i]){
                max=ar[i];
            }
        }
        int[] count =new int[max+1];
        int result=0;
        for(int i=0;i<ar.length;i++){
            count[ar[i]]++;
            if(count[ar[i]]==2){
                result++;
                count[ar[i]]=0;
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.valueOf(scanner.nextLine());
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);
        System.out.println(result);
        scanner.close();
    }
}

