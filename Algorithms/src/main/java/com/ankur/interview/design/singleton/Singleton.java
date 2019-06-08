/**
 * 
 */
package com.ankur.interview.design.singleton;

/**
 * @author ankurbrdwj
 *
 */
public class Singleton {

	private static Singleton instance=null;
	/**
	 * 
	 */
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
public static Singleton getInstance(){
	if(instance==null){
		return new Singleton();
	}
	return instance;
}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
