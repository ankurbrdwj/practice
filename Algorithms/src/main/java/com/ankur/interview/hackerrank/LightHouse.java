package com.ankur.interview.hackerrank;

import java.util.Scanner;

public class LightHouse {
public static void main ( String... args){
	Scanner  scan=new Scanner(System.in);
	int n=Integer.parseInt(scan.nextLine());
	char[][] array=new char[n][n];
	for(int i=0;i<n;i++){
		char[] line=scan.nextLine().toCharArray();
		array[i]=line;
	}
	
  }
}
