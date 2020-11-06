package com.ankur.interview.algexp.arrays;

public class BinarySearch {

    public static int search(int[] array, int target) {
        // Write your code here.
        int low = 0;
        int high = array.length-1;
        int mid = (low+high)/2;
        while(low < high){
            if(target==array[mid]){
                return mid;
            }else if( array[mid]<target){
                low = mid+1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }
}
