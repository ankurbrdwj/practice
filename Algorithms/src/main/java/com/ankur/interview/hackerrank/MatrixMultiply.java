package com.ankur.interview.hackerrank;

public class MatrixMultiply {

	public MatrixMultiply() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String... args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] b = { { 7, 8, 9 }, { 4, 5, 6 }, { 1, 2, 3 } };
		int[][] c = matrixMultiply(a, b);
		printTable(c);
	}

	private static void printTable(int[][] opt) {
		// TODO Auto-generated method stub
		for (int i = 0; i < opt.length; i++) {
			for (int j = 0; j < opt[i].length; j++) {
				System.out.printf("%5d ", opt[i][j]);
			}
			System.out.println();
		}

	}

	private static int[][] matrixMultiply(int[][] a, int[][] b) {
		// TODO Auto-generated method stub
		int[][] c = new int[a.length][b.length];
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int k = 0; k < b.length; k++) {
					sum += a[i][k] * b[k][j];
				}
				c[i][j] = sum;
				sum = 0;
			}

		}
		return c;
	}

}
