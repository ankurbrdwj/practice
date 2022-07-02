package com.ankur.interview.practice.arrays;

import java.util.Arrays;

public class MinChangePossible {

    public static int minChangeNotPossible(int[] a){
        Arrays.sort(a);
        int currentchange = 0; // starting 0 even if there si difference on 1 then we have the mincoin
        for(int coin:a){
            if(coin>currentchange+1){ //there is gap in sum and current coin
                return currentchange+1;
            }
            currentchange = currentchange+ coin; // keep adding

        }

        return currentchange+1; // return all sum +1
    }

    public static void main(String[] args) {
        int[] a={1,2,4};
        System.out.println(minChangeNotPossible(a));
    }
}
