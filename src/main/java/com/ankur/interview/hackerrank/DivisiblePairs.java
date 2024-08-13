package com.ankur.interview.hackerrank;

import java.util.Scanner;

public class DivisiblePairs {

	
	public static void main(String...strings){
		  Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int a[] = new int[n];
	       // Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	        for(int i=0; i < n; i++){
	            a[i] = in.nextInt();
		}
	        int count = 0;
			for(int i=0;i<a.length;i++){
	        	for(int j=i+1;j<a.length;j++){
	        		if((a[i]+a[j])%k==0){
	        			//map.put(i, j);
	        		count++;
	        		}
	        	}
	        }
	        System.out.println(count);
	        //System.out.println(map.size());
	}
}
