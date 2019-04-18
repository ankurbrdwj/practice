/**
 * 
 */
package com.ankur.interview.util;

/**
 * @author ankurbrdwj
 *
 */
public class PrintArray {

	/**
	 * 
	 */
	public PrintArray() {
		// TODO Auto-generated constructor stub
	}
public static void printArray(int[][] array){
	for(int i=0;i<array.length;i++){
		for(int j=0;j<array[i].length;j++){
			System.out.printf("%2d",array[i][j]);
		}
		System.out.println("");
	}
}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
