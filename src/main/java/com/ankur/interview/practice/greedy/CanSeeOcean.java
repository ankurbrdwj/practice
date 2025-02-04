package com.ankur.interview.practice.greedy;

import java.util.ArrayList;

public class CanSeeOcean {
  /* there is ocean on the right of the array of buildings
  / input = [4, 2 ,3 ,1]
  then 4 can see ocean , 2 cannot , 3 can , 1 can
  output = [0,2,3]
   */
  public static int[] haveOceanView(int[] input){
    // the rightmost always has a view
    int max = input[input.length-1];
    int count = 1;
    ArrayList<Integer> list = new ArrayList<>();
    list.add(input.length-1);
    for (int i = input.length-2; i >= 0; i--) {
        if(input[i]>max){
            max = input[i];
            list.add(i);
            count++;
        }
    }
    int[] output= new int[list.size()];

    for (int i =0 ; i<output.length; i++) {
        output[i] = list.get(list.size()-1-i);
    }
    return output;
  }

}
