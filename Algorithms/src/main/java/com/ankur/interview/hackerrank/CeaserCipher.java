/**
 * 
 */
package com.ankur.interview.hackerrank;

import java.util.Scanner;

/**
 * @author ankurbrdwj
 *
 */
public class CeaserCipher {

	/**
	 * 
	 */
	public CeaserCipher() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = in.next();
		int k = in.nextInt();
		int[] lArray = new int[26];
		int[] uArray = new int[26];
		int j = 97;
		for (int i = 0; i < 26; i++)
			lArray[i] = j++;
		j = 65;
		for (int i = 0; i < 26; i++)
			uArray[i] = j++;
		boolean upper = false;
		char[] cArray = s.toCharArray();
		for (int i = 0; i < cArray.length; i++) {
			int ascii = cArray[i];
			int a=0;
			while ( a < 26) {
				if (lArray[a] == ascii){
					cArray[i]=(char) (rotateArray(lArray,k)[a]);
					break;
				}
				if (uArray[a] == ascii) {
					upper = true;
					cArray[i]=(char) (rotateArray(uArray,k)[a]);
					break;
				}
				a++;
			}
			//cArray[i]=(char) (upper?rotateArray(uArray,k)[a]:rotateArray(lArray,k)[a]);
		}
		for(int i=0;i<cArray.length;i++)
		System.out.print(cArray[i]);
	}
public static int[] rotateArray(int[] array,int k){
	int[] result=array;
	for(int i=0;i<k;i++){
		int j,temp;
		 temp=result[0];
		int n=result.length;
		for( j=0;j<n-1;j++)
			result[j]=result[j+1];
		result[j]=temp;	
	}
	return result;
}
}
