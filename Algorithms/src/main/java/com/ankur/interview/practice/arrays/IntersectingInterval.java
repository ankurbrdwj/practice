package com.ankur.interview.practice.arrays;

import java.util.ArrayList;

public class IntersectingInterval {
    public static int[][] intervalIntersection(int[][] f, int[][] s) {
      ArrayList<int[]> result = new ArrayList<>() ;

      int i=0;int j=0;
      if(f == null || f.length ==0 && s ==null || s.length==0){
        return new int[1][];
      }
      while(i<f.length && j<s.length){
        int start = Math.max(f[i][0],s[j][0]);
        int end = Math.min(f[i][1],s[j][1]);
        if(start <= end)
          result.add(new int[]{start,end});
        if(f[i][1] < s[j][1]){
          i++;
        }else{
          j++;
        }
      }
      int[][] output = new int[result.size()][2];
      for(int k=0 ; k<result.size();k++){
        output[k]= result.get(k);
      }
      return output;
    }
  }
