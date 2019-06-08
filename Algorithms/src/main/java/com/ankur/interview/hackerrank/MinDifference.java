package com.ankur.interview.hackerrank;
/**
 * 
 */

/**
 * @author ankurbrdwj
 *
 */
public class MinDifference {

	/**
	 * 
	 */
	public MinDifference() {
		// TODO Auto-generated constructor stub
	}

	static int min(int a, int b) {return (a < b)? a : b;}
	static int min(int arr[], int l, int h)
	{
	    int mn = arr[l];
	    for (int i=l+1; i<=h; i++)
	       if (mn > arr[i])
	         mn = arr[i];
	    return mn;
	}
	
	static int max(int arr[], int l, int h)
	{
	    int mx = arr[l];
	    for (int i=l+1; i<=h; i++)
	       if (mx < arr[i])
	         mx = arr[i];
	    return mx;
	}
	static int minRemovals(int arr[], int n)
	{
	    int array[][]=new int[n][n];
	    
	    int diag, i, j, mn, mx;
	 
	
	    for (diag = 0; diag < n; ++diag)
	    {
	        for (i = 0, j = diag; j < n; ++i, ++j)
	        {
	            mn = min(arr, i, j);
	            mx = max(arr, i, j);
	            array[i][j] = (2*mn > mx)? 0: min(array[i][j-1]+1,
	                                              array[i+1][j]+1);
	        }
	    }
	    return array[0][n-1];
	}
	 static int minArray(int[] arr) {
		int result= minRemovals(arr, arr.length);
		return result;


	    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr={3,5,3,3,3,3,3,3,3,1,6};
			System.out.println(minArray(arr));
	}

}
