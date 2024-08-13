package com.ankur.interview.practice.arrays;

public class Skyline {
  // Paint the skyline https://codegolf.stackexchange.com/questions/179464/covering-a-skyline-with-brush-strokes

  public static int brushCount(int[] buildings)
  {
    int count=0;
    for(int i=0; i<=buildings.length-1; i++){
      if((i+1)<(buildings.length)){
        if(buildings[i]>buildings[i+1]){
          count += buildings[i]-buildings[i+1];
        }
      }else{
        count += buildings[i];
      }
    }
    return count;
  }

  public static void main(String[] args) {
    // int [] A= {1,3,2,1,2,1,5,3,3,4,2};
    int [] A= {5,8};

    System.out.println(brushCount(A));
  }
}
