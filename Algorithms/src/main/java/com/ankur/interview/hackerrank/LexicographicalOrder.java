/**
 * 
 */
package com.ankur.interview.hackerrank;

import java.util.Scanner;

/**
 * @author ankurbrdwj
 *
 */
public class LexicographicalOrder {

	/**
	 * 
	 */
	public LexicographicalOrder() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		for(int i=0;i<n;i++){
			char[] s=scan.next().toCharArray();
			char[] result=nextPermutation(s);
			System.out.println(result);
		}
	}
	static char[] nextPermutation(char[] array) {
	    int i = array.length - 1;
	    while (i > 0 && array[i - 1] >= array[i]) {
	        i--;
	    }

	    if (i <= 0) {
	        return "no answer".toCharArray();
	    }

	    int j = array.length - 1;

	    while (array[j] <= array[i - 1]) {
	        j--;
	    }

	    int temp = array[i - 1];
	    array[i - 1] = array[j];
	    array[j] = (char)temp;

	    j = array.length - 1;

	    while (i < j) {
	        temp = array[i];
	        array[i] = array[j];
	        array[j] = (char)temp;
	        i++;
	        j--;
	    }

	    return array;
	}

}
