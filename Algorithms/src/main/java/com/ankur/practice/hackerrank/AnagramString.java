package com.ankur.interview.hackerrank;

public class AnagramString {

	public AnagramString() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(new AnagramString().isAnargam("Ankur","Ankur"));
	}
public String isAnargam(String s1,String s2){
	int[] char1=new int[256];
	int[] char2=new int[256];
	if(s1.length()!=s2.length())
		return "Strings are not of equal length";
	char[] str1=s1.toCharArray();
	char[] str2=s2.toCharArray();
	for(int i=0;i<str1.length;i++){
		char1[str1[i]]++;
		char2[str2[i]]++;
	}
	for(int j=0;j<256;j++){
		if(char1[j]!=char2[j])
			return "Not Anagram";
	}
	
	return "Given Strings are Anagrams";

}

}
