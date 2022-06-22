package com.ankur.interview.clrs.chapter4;

import java.util.Arrays;

public class MaximumSubarray {
	
	static int[] findMaxSubArray(int[] input){
		
		int maxStartIndex = 0;
		int maxEndIndex = 0; 
		int maxCumulative = 0;
		int maxEntire = 0;
		int startIndex = 0;
		
		for(int i = 0; i < input.length; i++) {
			/*
			 * /check when Sum goes zero in case of negative integers its likely to happen
			 * the index and sum will restart from there 
			 */
		      if(0 >= maxCumulative +input[i]) {
		    	  startIndex = i+1;
		    	  maxCumulative = 0;
		      }
		      // else keep adding into sum
		      else {
		    	  maxCumulative += input[i];
		      }
		      // comparing with entire array max and storing the index
		      if(maxCumulative > maxEntire) {
		    	  maxEntire=maxCumulative ;
		        maxStartIndex = startIndex;
		        maxEndIndex = i;
		      }
		    }

		    if(maxStartIndex <= maxEndIndex) {
		      return Arrays.copyOfRange(input, maxStartIndex, maxEndIndex+1);
		    }

		    return null;
		  }

	public static void main(String... strings) {
		int[] input = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
	for(Integer item:findMaxSubArray(input))
		System.out.print(item+" ");
		
	}
	}

