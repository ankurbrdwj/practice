/**
 * 
 */
package com.ankur.interview.beyond;

import com.ankur.interview.util.PrintArray;

/**
 * @author ankurbrdwj
 *
 */
public class Knapsack2 {

	/**
	 * 
	 */
	public Knapsack2() {
		// TODO Auto-generated constructor stub
	}
	 // A utility function that returns maximum of two integers
    static int max(int a, int b) { return (a > b)? a : b; }
      
   // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack(int W, int weight[], int value[], int n)
    {
         int i, j;
     int K[][] = new int[n+1][W+1];
      
     // Build table K[][] in bottom up manner
     for (i = 0; i <= n; i++)
     {
         for (j = 0; j <= W; j++)
         {
             if (i==0 || j==0){
                  K[i][j] = 0;
             System.out.printf("%5d",K[i][j]);
             }
             else if (weight[i-1] <= j){
                   K[i][j] = max(value[i-1] + K[i-1][j-weight[i-1]],  K[i-1][j]);
                   System.out.printf("%5d",K[i][j]);
             }else{
                   K[i][j] = K[i-1][j];
                   System.out.printf("%5d",K[i][j]);
         }
         }
         System.out.println();    
      }
     PrintArray.printArray(K);
      return K[n][W];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Knapsack2 ks=new Knapsack2();
		int[] values = { 2, 3, 5, 7, 9 };
		int[] w = { 1, 2, 4, 6, 8 };
		int W = 12;
	int m=	Knapsack2.knapSack(W,w,values,5);
	//PrintArray.printArray(m);
	}

}
