package com.ankur.interview.practice.arrays;

import java.util.HashSet;

public class CountSquares {
  public static int countSquares(int[][] points) {
    // Write your code here.
    HashSet<String> pointsStringSet= new HashSet<>();
    for(int[] point:points){
      pointsStringSet.add(pointToString(point));
    }
    int count =0;
    for(int[] pointA:points){
      for(int[] pointB:points){
        if(pointA==pointB){
          continue;
        }
          double[] midPoint=new double[]{
            (pointA[0]+pointB[0]) /2.0 , (pointA[1]+pointB[1])/2.0};
          double xDistanceFromMid= pointA[0]-midPoint[0];
          double yDistanceFromMid= pointA[1]-midPoint[1];
           double[] pointC = new double[]{midPoint[0]+yDistanceFromMid ,midPoint[1]-xDistanceFromMid};
           double[] pointD =  new double[]{midPoint[0]-yDistanceFromMid, midPoint[1]+xDistanceFromMid};
           if(pointsStringSet.contains(dbPointToString(pointC))&& pointsStringSet.contains(dbPointToString(pointD))){
             count++;
           }
      }

    }

    return count/4;
  }

  private static String pointToString(int[] point) {
    return point[0] + ","+point[1];
  }

  private static String dbPointToString(double[] point) {
    if (point[0] % 1 == 0 && point[1] % 1 == 0)
    {
      return (int)point[0] + "," + (int)point[1];
    }
    return point[0] + "," + point[1];
  }
}
