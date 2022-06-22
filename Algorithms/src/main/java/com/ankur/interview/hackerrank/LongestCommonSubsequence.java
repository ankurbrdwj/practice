package com.ankur.interview.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {

	public LongestCommonSubsequence() {
		// TODO Auto-generated constructor stub
	}

	public static int[][] lcsLength(int[] x,int[] y){
	
		int m=x.length;int n=y.length;
		int[][]lcsLength=new int[x.length][y.length];
		
		return lcsLength;
	}
	public static Map<String,Character[][]>getLength(Character[] x,Character[] y){
		Map<String,Character[][]> map=new HashMap<String,Character[][]>();
		int m=x.length;int n=y.length;
		Character[][]b=new Character[m][n];
		Character[][] c=new Character[m][n];
		initialize(b);
		initialize(c);
		for(int i=1;i<m;i++)
			c[i][0]=0;
		for(int j=0;j<n;j++)
			c[0][j]=0;
		
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				if(x[i]==y[j]){
					c[i][j]=(char) (Character.getNumericValue(c[i-1][j-1])+1);
					b[i][j] = '\\';
				}else if(c[i-1][j]>=c[i][j-1]){
					c[i][j]=c[i-1][j];
					b[i][j]='|';
				}else{
					c[i][j]=c[i][j-1];
					b[i][j]='-';
				}
			}
		}
		map.put("tableb", b);
		map.put("tablec",c);
		System.out.println(Arrays.deepToString(b));
		System.out.println(Arrays.deepToString(c));

		return map;
		
	}

	private static void initialize(Character[][] b) {
		// TODO Auto-generated method stub
		for(int i=0;i<b.length;i++){
			for(int j=0;j<b[i].length;j++){
			b[i][j]='0';
			}
		}
	}

	private static void printTable(Character[][] b) {
		// TODO Auto-generated method stub
		System.out.println("=======================");
		for(int i=0;i<b.length;i++){
			for(int j=0;j<b[i].length;j++){
			System.out.println(b[i][j]+" " );	
			}
			System.out.println("\n");	
		}
		System.out.println("=======================");
	}
	public static void main(String... args){
		Character[] x={ 'A','B', 'C', 'B', 'D', 'A', 'B' };
		Character[] y={ 'B', 'D', 'C', 'A', 'B', 'A' };
		getLength(x, y);
	}
}
