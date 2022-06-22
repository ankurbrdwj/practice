package com.ankur.interview.hackerrank;

import java.util.Arrays;
import java.util.HashMap;

public class ZeroSum {

	public ZeroSum() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
        int arr[] = {4, 2, 4, 5, 2, 3, 1};
        int[] arr1={-3,3,2,2,4,4,-5,5};
        if (printZeroSumSubarray(arr1))
            System.out.println("Found a subarray with 0 sum");
        else
            System.out.println("No Subarray with 0 sum"); 
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
        	if(arr[i]==arr[i+1]){
        		System.out.println(arr[i]+": at index :"+i+" :has dupilicate :"+arr[i+1]+": at index :"+(i+1));
        	}
        }
    }            

	 static Boolean printZeroSumSubarray(int arr[])
	    {
	        // Creates an empty hashMap hM
	        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
	         
	        // Initialize sum of elements
	        int sum = 0;        
	         
	        // Traverse through the given array
	        for (int i = 0; i < arr.length; i++)
	        {   
	            // Add current element to sum
	            sum += arr[i];
	             
	            // Return true in following cases
	            // a) Current element is 0
	            // b) sum of elements from 0 to i is 0
	            // c) sum is already present in hash map
	            if (arr[i] == 0 || sum == 0 || hM.get(sum) != null)                            
	               return true;
	             
	            // Add sum to hash map
	            hM.put(sum, i);
	        }    
	         
	        // We reach here only when there is no subarray with 0 sum
	        return false;
	    }        
}
