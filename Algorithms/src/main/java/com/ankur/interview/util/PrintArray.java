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
		convertToBinary(4);
		Integer.toBinaryString(4);

	}
	public static boolean[] convertToBinary(int number) {
		int binExpo = 0;
		int bin = 1;
		while(bin < number) { //calculates the needed digits
			bin = bin*2;
			binExpo++;
		}
		bin = bin/2;
		boolean[] binary = new boolean[binExpo]; //array with the right length
		binExpo--;
		while(binExpo>=0) {
			if(bin<=number) {
				binary[binExpo] = true;
				number =number -bin;
				bin = bin/2;
			}else {
				binary[binExpo] = false;
			}
			binExpo--;
		}
		return binary;
	}
}
