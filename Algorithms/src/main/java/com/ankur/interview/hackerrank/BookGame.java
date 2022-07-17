package com.ankur.interview.hackerrank;

import java.util.Scanner;

public class BookGame {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
*/
        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int k = s.nextInt();
        int i=0;
        long score = 0;
        while(i<k){
            int n=0;
            if(s.hasNextInt())
             n= s.nextInt();
            n= n%10;
            score  = Math.max(score+ n , score * n );
            i++;
        }
        score = score % (1000000007);
        System.out.println(score);
        s.close();

        // Write your code here

    }
}

