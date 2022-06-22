/**
 * 
 */
package com.ankur.interview.hackerrank;

/**
 * @author ankurbrdwj
 *
 */
public class UniqueString {

	/**
	 * 
	 */
	public UniqueString() {
		// TODO Auto-generated constructor stub
	}

	public static int getCount(String txt,String pat){
		int M=pat.length();
		int N=txt.length();
		int distinct=0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(txt.charAt(i+j)!=pat.charAt(j))
					distinct++;
			//if(j==M) return i;
			}
		}
		return distinct;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String txt="sample";
		String pat="s";
		
		char[] array=txt.toCharArray();
		for(char c:array){
			int count=getCount(txt,String.valueOf(c));
			if(count>1)
				System.out.println("String does not have unique characters");
		}
		
		

}
}