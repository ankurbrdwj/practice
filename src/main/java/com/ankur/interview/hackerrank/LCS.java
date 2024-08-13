package com.ankur.interview.hackerrank;

import com.ankur.interview.princeton.stdlib.StdOut;

public class LCS {

	public LCS() {
		// TODO Auto-generated constructor stub
	}

	// Compute length of LCS for all subproblems.
	public static String lcs(String x, String y) {
		int m = x.length(), n = y.length();
		int[][] opt = new int[m + 1][n + 1];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (x.charAt(i) == y.charAt(j)) {
					opt[i][j] = opt[i + 1][j + 1] + 1;
				} else {
					opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
				}
			}
		}
		printTable(opt);
		// Recover LCS itself.
		String lcs = "";
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (x.charAt(i) == y.charAt(j)) {
				lcs += x.charAt(i);
				i++;
				j++;
			} else if (opt[i + 1][j] >= opt[i][j + 1])
				i++;
			else
				j++;
		}
		return lcs;
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

	private static String reverselcs(String x,String y) {
		int m = x.length(), n = y.length();
		int[][] opt = new int[m + 1][n + 1];
		for (int i =1; i <=m; i++) {
			for (int j = 1; j<=n; j++) {
				if (i == 0 || j == 0)
			         opt[i][j] = 0;

			       else if (x.charAt(i-1) == y.charAt(j-1))
			       opt[i][j] = opt[i-1][j-1] + 1;

			       else
			         opt[i][j] = Math.max(opt[i-1][j], opt[i][j-1]);
			}
		}
		printTable(opt);
		// Recover LCS itself.
		String lcs = "";
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (x.charAt(i) == y.charAt(j)) {
				lcs += x.charAt(i);
				i++;
				j++;
			} else if (opt[i - 1][j] <= opt[i][j - 1])
				i++;
			else
				j++;
		}
		return lcs;
	}

	public static void main(String[] args) {
		String lcs = lcs("ABCDABA", "BDCABA");
		//String lcs = reverselcs("ABCDABA", "BDCABA");
		StdOut.println(lcs);
	}

}
