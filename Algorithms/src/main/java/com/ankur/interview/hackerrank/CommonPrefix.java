package com.ankur.interview.hackerrank;

public class CommonPrefix {
	// Array Of string find longest commonn prefix of string
	// ["abcd", "abc", "aba"] -> "ab"

	// a b c d
	// abc 1 1 1 0
	// aba 1 1 0 0

	public static void main(String... strings) {
		//String[] input = { "abcd", "abc", "aba", "abcde" };
		String[] input = { "xabcd", "xabc", "axbca", "axbcde" };
		int[][] array={{1,2,3},{3,4,5},{5,6,7},{7,8,9},{9,1,2},{2,3,4}};
		int row=array.length;
		int col=array[0].length;
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
		// find max length char
		String max = input[0];
		String x = null;
		for (int i = 0; i < input.length; i++) {
			if (input[i].length() > max.length()) {
				x = input[i];
				max = x;
			}
		}
		int flag = 0;
		int rows = input.length;
		int columns = x.length();
		int[][] mem = new int[input.length][x.length()];
		String result = "";
		char[] xAxis = x.toCharArray();
		
		for(int i=0;i<columns;i++){
			for(int j=0;j<rows;j++){
				char[] yAxis = input[j].toCharArray();
					if (yAxis[i]==xAxis[i]){
						result=result+xAxis[i];
					}
			}
		}
		for (int i = 0; i < rows; i++) {
			char[] yAxis = input[i].toCharArray();
			for (int j = 0; j < yAxis.length; j++) {
				mem[i][j] = xAxis[j] == yAxis[j] ? 1 : 0;
			}

		}
		for (int i = 0; i < columns; i++) {
			// char[] yAxis = input[i].toCharArray();
			for (int j = 0; j < rows; j++) {
				System.out.print(mem[j][i]);
				if (mem[j][i] == 1) {
					flag++;
				}
			}
			System.out.println();
			result = flag == input.length ? result + xAxis[i] : result;
			flag = 0;
		}

		System.out.println("Max common prefix is :" + result);
	}

}
