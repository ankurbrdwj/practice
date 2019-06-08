/**
 * 
 */
package com.ankur.interview.hackerrank;

import java.util.Scanner;


/**
 * @author ankurbrdwj
 *
 */
public class NonRepeatingChar {

	/**
	 * 
	 */
	public NonRepeatingChar() {
		// TODO Auto-generated constructor stub
	}
public static	int[] getCharCountArray(char[] str)
	{
	   int[] count = new int[256];
	   int i;
	   for (i = 0; i<str.length;  i++)
	      count[i]++;
	   return count;
	}
public static	int firstNonRepeating(char[] str)
	{
	  int[] count = getCharCountArray(str);
	  int index = -1, i;
	 
	  for (i = 0;i<str.length;  i++)
	  {
	    if (count[i] == 1)
	    {
	      index = i;
	      break;
	    }   
	  }  	   
	  return index;
	}
	/**
	 * chemichel
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String input=scan.nextLine();
		char[] array=input.toCharArray();
		int[] count=new int[input.length()];
		int index=firstNonRepeating(array);
		if(index==-1)
			System.out.println("No Non repeating character");
		else
			System.out.println("The first Non Repeating character is "+ array[index]);
		
	}


}
