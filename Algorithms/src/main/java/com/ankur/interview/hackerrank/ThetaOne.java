/**
 * 
 */
package com.ankur.interview.hackerrank;

import java.util.*;

/**
 * @author ankurbrdwj
 *
 */
public class ThetaOne {
private HashMap<Integer,Integer> table;
private List<Integer> array;

	/**
	 * 
	 */
	public ThetaOne() {
		// TODO Auto-generated constructor stub
		array=new ArrayList<Integer>();
		table=new HashMap<Integer,Integer>();
	}
	public void add(Integer i){
		if(table.get(i)!=null)
			return;
		
			array.add(i);
			table.put(i, array.size()-1);
		}
public void remove(Integer i){
	Integer index=table.get(i);
	if (index==null)
		return;
	
	table.remove(i);
	int size=array.size();
	Integer last=array.get(size-1); 
	Collections.swap(array, i, size-1);
	
	array.remove(size-1);
	table.put(last, index);
	
}
public Integer random(){
	Random rand=new Random();
	int index=rand.nextInt(array.size());
	return table.get(index);
}
Integer search(Integer x){
return table.get(x);	
}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThetaOne  to=new ThetaOne();
		to.add(3);
		to.add(4);
		to.add(5);
		to.add(6);
		to.add(7);
		System.out.println(to.random());
		to.remove(4);
		System.out.println();
		Object one=new Object();
		one.hashCode();

	}

}
