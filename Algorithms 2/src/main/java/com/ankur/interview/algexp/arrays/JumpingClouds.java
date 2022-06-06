package com.ankur.interview.algexp.arrays;

public class JumpingClouds {
    static int jumpingOnClouds(int[] c) {
        int r = 0;

        int n = c.length;
        int i=0;
        while(i<n-1){
            if(i+1 <n && c[i+1]==1){
                i=i+2;
                r++;
            }else if(i+2<n && c[i+2]==1){
                i++;
                r++;
            }else{
                i=i+2;
                r++;
            }
        }
        return r;
    }

    public static void main(String[] args) {
int [] a= {0,0,1,0,0,1,0};
        System.out.println(jumpingOnClouds(a));
    }
}
