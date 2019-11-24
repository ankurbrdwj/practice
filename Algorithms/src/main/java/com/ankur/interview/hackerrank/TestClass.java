package com.ankur.interview.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

    public class TestClass {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter wr = new PrintWriter(System.out);
            int A_size = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().trim().split(" ");
            int[] A = new int[A_size];
            for (int i_A = 0; i_A < arr_A.length; i_A++) {
                A[i_A] = Integer.parseInt(arr_A[i_A]);
            }

            int[] out_ = BS(A);
            wr.print(out_[0]);
            for (int i_out_ = 1; i_out_ < out_.length; i_out_++) wr.print(" " + out_[i_out_]);


            wr.close();
            br.close();
        }

        static int[] BS(int[] A) {
            // Write your code here
            //Arrays.sort(A);
            int[] result =new int[A.length];
            for(int i=0;i<A.length;i++){
                result[i]=1;
            }
            for ( int i = 1; i < A.length; i++ ){
                for ( int j = 0; j < i; j++ )  {
                    if ( A[j] <= A[i] && result[i] >= result[j] + 1)
                        result[i] = result[j] + 1;
                }
            }
            return result;
        }
    }
