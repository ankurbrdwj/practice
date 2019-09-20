package com.ankur.interview.hackerrank;

public class RotateMatrix {

	public RotateMatrix() {
		// TODO Auto-generated constructor stub
	}

	public static void rotate(int[][] matrix, int n) {
		for (int i = 0; i < n / 2; ++i) {
			for (int j = i; j < n - 1 - i; ++j) {
				int top = matrix[i][j]; // save top
				// left -> top
				matrix[i][j] = matrix[n - 1 - j][i];
				// bottom -> left
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				// right -> bottom
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				// top -> right
				matrix[j][n - 1 - i] = top; // right <- saved top
			}
		}
	}

	static void printMatrix(int arr[][],int N)
	{
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
				System.out.print( arr[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String... args){
		int[][] matrix={{1,2,3,4},{5,6,7,8},{9,0,1,2},{3,4,5,6}};
		printMatrix(matrix,4);
		rotate(matrix,4);
		printMatrix(matrix,4);

}
}