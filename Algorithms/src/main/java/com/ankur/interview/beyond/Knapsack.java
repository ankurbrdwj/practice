package com.ankur.interview.beyond;

import com.ankur.interview.util.PrintArray;

public class Knapsack {

	public Knapsack() {
		// TODO Auto-generated constructor stub
	}

	public int[][] getMaxValue(int[] values,int[]w,int W) {
		// Input:
		// Values (stored in array v)
		// Weights (stored in array w)
		// Number of distinct items (n)
		// Knapsack capacity (W)
		/*int[] values = { 2, 3, 5, 7, 9 };
		int[] w = { 1, 2, 4, 6, 8 };
		int W = 12;*/
		int n = w.length;
		int[][] m = new int[n+1][W+1];
		for (int j = 0; j < W; j++) {
			m[0][j] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < W; j++) {
				if (w[i] > j)
					m[i][j] = m[i - 1][j];
				else
					m[i][j] = Math.max(m[i - 1][j], m[i - 1][j - w[i]] + values[i]);
			}
		}
		return m;
	}
	public static void main(String... strings){
		Knapsack ks=new Knapsack();
		int[] values = { 2, 3, 5, 7, 9 };
		int[] w = { 1, 2, 4, 6, 8 };
		int W = 12;
	int[][] m=	ks.getMaxValue(values, w, W);
	PrintArray.printArray(m);
	}
}
