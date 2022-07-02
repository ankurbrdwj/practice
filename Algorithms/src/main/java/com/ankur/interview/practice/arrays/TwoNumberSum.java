package com.ankur.interview.practice.arrays;

import java.util.Arrays;

public class TwoNumberSum {
        public static int[] twoNumberSum(int[] array, int targetSum) {
            // Write your code here.
            Arrays.sort(array);
            int l = 0;
            int r = array.length-1;
            int[] result = new int[2];
            while(l<r){
                int sum=array[l]+array[r];
                if(sum==targetSum){
                    result[0]= array[l];
                    result[1]= array[r];
                    return  result;
                }else if(sum<targetSum){
                    l++;
                }else if(sum > targetSum){
                    r--;
                }
            }
            return result;
        }
    }

