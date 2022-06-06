/**
 * 
 */
package com.ankur.interview.hackerrank;

/**
 * @author ankurbrdwj
 *
 */
public class MatrixChainMin {
protected int[][]m;
protected int[][]s;
	/**
	 * 
	 */
	public MatrixChainMin() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] b = { { 7, 8, 9 }, { 4, 5, 6 }, { 1, 2, 3 } };
		int[][] c = { { 4, 5, 6 }, { 1, 2, 3 }, { 7, 8, 9 } };
		int[][] d = { { 1, 2, 3 }, { 7, 8, 9 }, { 4, 5, 6 } };
		int []p={20,50,30,10,40};
		//int [][] minChain=matrixChainOrder(p);
		MatrixChainMin mcm=new MatrixChainMin();
		mcm.matrixChainOrder(p);
		mcm.printOptimalParenthesizations();
	}
	
	private void matrixChainOrder(int[] p) {
		// TODO Auto-generated method stub
		int n=p.length-1;
		int q=0,j=0;
		m=new int[n][n];
		s=new int[n][n];
		for(int i=0;i<n;i++){
			m[i][i]=0;
		}
		for(int l=1;l<n;l++){
			for(int i=0;i<n-l;i++){
				 j = i+l;
				m[i][j]=Integer.MAX_VALUE;
				for(int k=i;k<j;k++){
					 q = m[i][k]+m[k+1][j]+p[i]*p[k+1]*p[j+1];
					if(q<m[i][j]){
						m[i][j]=q;
						s[i][j]=k;
					}
				}
			}
		}
	}
	 public void printOptimalParenthesizations() {
	        boolean[] inAResult = new boolean[s.length];
	        printOptimalParenthesizations(s, 0, s.length - 1, inAResult);
	    }
	 void printOptimalParenthesizations(int[][]s, int i, int j,  /* for pretty printing: */ boolean[] inAResult) {
	        if (i != j) {
	            printOptimalParenthesizations(s, i, s[i][j], inAResult);
	            printOptimalParenthesizations(s, s[i][j] + 1, j, inAResult);
	            String istr = inAResult[i] ? "_result " : " ";
	            String jstr = inAResult[j] ? "_result " : " ";
	            System.out.println(" A_" + i + istr + "* A_" + j + jstr);
	            inAResult[i] = true;
	            inAResult[j] = true;
	        }
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
}
