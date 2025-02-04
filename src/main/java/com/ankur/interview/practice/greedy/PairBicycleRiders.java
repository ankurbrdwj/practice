package com.ankur.interview.practice.greedy;

import java.util.Arrays;

public class PairBicycleRiders {
  /*
  / Pair two groups of riders wither min speed or max speed out of total group
  red =[5,5,3,9,2]
  blue = [3,6,7,2,1]
  fastest = true;
  outpu = 32
   */

  public int tandemBicycle(
    int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest
  ) {
    // Write your code here.
    Arrays.sort(redShirtSpeeds);
    Arrays.sort(blueShirtSpeeds);
    if (fastest) {
      reverseInplaceSort(blueShirtSpeeds);
    }
    int speed=0;
    for (int i = 0; i < redShirtSpeeds.length; i++) {
    speed+=Math.max(redShirtSpeeds[i],blueShirtSpeeds[i]);
    }
    return speed;
  }

  private void reverseInplaceSort(int[] shirtSpeeds) {
int start=0;
int end= shirtSpeeds.length-1;
while(start<end){
  int temp= shirtSpeeds[start];
  shirtSpeeds[start]=shirtSpeeds[end];
  shirtSpeeds[end]= temp;
  start+=1;
  end-=1;
}
  }
}
