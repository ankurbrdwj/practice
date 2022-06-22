package com.ankur.interview.hackerrank;

public class Prefix {

	public static void main (String...strings){
		String[] input={"abracdabra","abraja","abramamb","abragab","abralabr"};
		String minString="";
		int min=input[0].length();
		for(int i=0;i<input.length;i++){
			if(input[i].length()<min){
				min=input[i].length();
				minString=input[i];
			}
		}
		int flag=0;
		int rows=input.length;
		int cols=minString.length();
		String result="";
		char[] xAxis=minString.toCharArray();
		for(int i=0;i<cols;i++){		
			for(int j=0;j<rows;j++){
				if (xAxis[i]==input[j].toCharArray()[i]){
					flag++;
				}
			}
			if(flag==input.length)
				result+=xAxis[i];
			else
				break;
			flag=0;
		}
		System.out.println("The Max prefix in this list is "+ result);
	}
}
