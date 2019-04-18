/**
 * 
 */
package com.ankur.interview.hackerrank;


/**
 * @author ankurbrdwj
 *
 */
public class SumCoins {

	/**
	 * 
	 */
	public SumCoins() {
		// TODO Auto-generated constructor stub
	}

	static int getCount(int[] A, int S) {
		
		if (S == 0)
			return 0;
		int result = Integer.MAX_VALUE;

		for (int i = 0; i < A.length; i++) {
			if (A[i] <= S) {
				int sub_res = getCount(A, S - A[i]);

				if (sub_res != Integer.MAX_VALUE && sub_res + 1 < result)
					result = sub_res + 1;
			}
		}
		return result;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int coins[] =  {3, 1,3, 5};
		int S=11;
		int number=getCount(coins, S);
		System.out.println(number);
		
		
	}

}
