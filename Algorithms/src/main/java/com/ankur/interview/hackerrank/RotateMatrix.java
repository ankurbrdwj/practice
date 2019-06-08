package com.ankur.interview.hackerrank;

import java.util.Arrays;

public class RotateMatrix {

	public RotateMatrix() {
		// TODO Auto-generated constructor stub
	}

	public static void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer; 
			for (int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
	}
	static int sum(int[] numbers) {
		 int length=numbers[0];
		    int sum=0;
		    for(int i=1;i<numbers.length;i++){
		    	sum=sum+numbers[i];
		    }
			return sum;
	    }
	public static void main(String... args){
		int[][] matrix={{1,2,3,4},{5,6,7,8},{9,0,1,2},{3,4,5,6}};
		for(int i=0;i<4;i++)
		System.out.println(Arrays.toString(matrix[i])+"\n");
		rotate(matrix,4);
		for(int i=0;i<4;i++)
		System.out.println(Arrays.toString(matrix[i])+"\n");	
int[] numbers={5,1,2,3,4,5};

	int sum=sum(numbers);
	System.out.println(sum);
}
}