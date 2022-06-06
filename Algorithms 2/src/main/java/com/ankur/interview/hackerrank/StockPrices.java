package com.ankur.interview.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StockPrices implements Comparable{

	public StockPrices() {
		// TODO Auto-generated constructor stub
	}

	public HashMap<Integer, Integer[]> calcProfit(int[] stockvalues) {
		Integer[] dobuy = new Integer[stockvalues.length];
		int prof = 0;
		int m = 0;
		HashMap<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
		for (int i = stockvalues.length-1; i >=0 ; i--) {
			int ai = stockvalues[i];
			if (m <= ai) {
				dobuy[i] = 0;
				m = ai;
			}
			prof += m - ai;
		}
		map.put(prof, dobuy);
		return map;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StockPrices sp = new StockPrices();
		TreeMap<Integer, Node> trrmap=new TreeMap<Integer, Node>();
		int[] stockValues = { 1, 2, 100 };
		HashMap<Integer, Integer[]> map = sp.calcProfit(stockValues);
		for (Map.Entry<Integer, Integer[]> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "  ::  " + Arrays.toString(entry.getValue()));
		}
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
