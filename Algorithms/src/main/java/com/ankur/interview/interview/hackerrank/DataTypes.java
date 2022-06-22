package com.ankur.interview.hackerrank;

import java.util.Scanner;

public class DataTypes {

	public DataTypes() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int i = 4;
		double d = 4.0;
		String s = "HackerRank ";

		Scanner scan = new Scanner(System.in);
		/* Declare second integer, double, and String variables. */
		int j = 0;
		double k = 0;
		String l = "";
		/*
		 * Read and save an integer, double, and String to your variables.*/
		  j=Integer.valueOf(scan.nextLine());
		  k=Double.valueOf(scan.nextLine()); 
		  l=String.valueOf(scan.nextLine());
		 
		 /* Print the sum of both integer variables on a new line.
		 */
		System.out.println(j + i);

		/* Print the sum of the double variables on a new line. */
		System.out.println(k + d);

		/*
		 * Concatenate and print the String variables on a new line; the 's'
		 * variable above should be printed first.
		 */
		System.out.println(s + l);
		scan.close();
	}
}
