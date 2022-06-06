package com.ankur.interview.hackerrank;

public class RemoveDuplicates {

	public RemoveDuplicates() {
		// TODO Auto-generated constructor stub
	}

	public static String removeDuplicates(String str) {
		if (str == null)
			return str;
		int len = str.length();
		if (len < 2)
			return str;
		String sbr=new String();
		for(int i=0;i<str.length();i++){
			String s=str.substring(i,i+1);
			//int index=str.indexOf(s);
			if(!sbr.contains(s))
				sbr+=s;
			else
				;
				//System.out.println("Duplicate Found at :"+index);
		}
return sbr;
	}
	
	public static void main(String... args){
		String input="hakunamatatatimbaktuchinchpokli";
		String output=removeDuplicates(input);
		System.out.println(output);
	}
}
