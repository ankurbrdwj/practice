package com.ankur.clrs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(intervals.size() == 0)
            return intervals;
        if(intervals.size() == 1)
            return intervals;

        Collections.sort(intervals, new IntervalComparator());

        Interval first = intervals.get(0);
        int start = first.start;
        int end = first.end;

        ArrayList<Interval> result = new ArrayList<Interval>();

        for(int i = 1; i < intervals.size(); i++){
            Interval current = intervals.get(i);
            if(current.start <= end){
                end = Math.max(current.end, end);
            }else{
                result.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            }

        }

        result.add(new Interval(start, end));

        return result;

    }
 public static void main(String... args){
    	Scanner scan=new Scanner(System.in);
    	ArrayList<Interval> intervals=new ArrayList<Interval>();
    	int n=Integer.parseInt(scan.nextLine());
    	for (int i=0;i<n;i++){
    		String[] line=scan.nextLine().split(" ");
    		intervals.add(new Interval(Integer.parseInt(line[0]),Integer.parseInt(line[1])));
    	}
    }
    
}
class IntervalComparator implements Comparator{
    public int compare(Object o1, Object o2){
        Interval i1 = (Interval)o1;
        Interval i2 = (Interval)o2;
        return i1.start - i2.start;
    }
}
    class Interval {
   int start;
      int end;
      Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }
    
   