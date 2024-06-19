package com.ankur.interview.practice.arrays;

public class Duplicate {
    public  static int firstsDuplicateValue(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int absValue =Math.abs(array[i]);
            if(array[absValue-1]<0){
                return absValue;
            }
            array[absValue-1] *= -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array ={2,1,5,2,3,3,4};
        firstsDuplicateValue(array);
    }
}
