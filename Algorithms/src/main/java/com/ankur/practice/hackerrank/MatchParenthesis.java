/**
 * 
 */
package com.ankur.interview.hackerrank;

import java.util.Iterator;

import com.ankur.interview.fundamentals.bagsqueuestacks.Stack;

/**
 * @author ankurbrdwj
 *
 */
public class MatchParenthesis {
private Stack<String> stack;
	/**
	 * 
	 */
	public MatchParenthesis() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatchParenthesis mp=new MatchParenthesis();
		mp.stack.push("c");mp.stack.push("6");mp.stack.push("h");mp.stack.push("2");mp.stack.push("(");
		mp.stack.push("cl");mp.stack.push("3");mp.stack.push("(");mp.stack.push("o");mp.stack.push("h");
		mp.stack.push("2");mp.stack.push(")");mp.stack.push("3");mp.stack.push(")");mp.stack.push("3");mp.stack.push(")");

		Iterator itr=mp.stack.iterator();
		while(itr.hasNext()){
			
		}
		
	}

}
