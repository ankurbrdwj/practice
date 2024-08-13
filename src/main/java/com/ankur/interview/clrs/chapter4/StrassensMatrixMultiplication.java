package com.ankur.interview.clrs.chapter4;

public class StrassensMatrixMultiplication {

	public int[][] squareMatrinMultuply(int[][] A, int[][] B){
		int n=A[0].length;
		int[][] C=	new int[n][n];
		for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					C[i][j]=0;
					for(int k=0;k<n;k++){
						C[i][j]=C[i][j]+A[i][k]*B[k][j];
					}
				}
		}
	return C;
}
	
	public int[][]squareMatrixMultiplyRecursive(int[][]A,int[][]B){
		int n=A[0].length;
		int[][] C=	new int[n][n];
		if(n==1){
			C[1][1]=A[1][1]*B[1][1];
			return C;
		}else{
			
			return C;
	}
	}
	
	
}
