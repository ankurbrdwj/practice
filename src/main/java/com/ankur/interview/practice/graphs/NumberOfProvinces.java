package com.ankur.interview.practice.graphs;

import edu.princeton.cs.algorithms.UF;

public class NumberOfProvinces {

  public int findCircleNum(int[][] isConnected) {
    int N = isConnected.length;
    UF uf = new UF(N);
    for (int i = 0; i < isConnected.length; i++) {
      for (int j = 0; j < isConnected[i].length; j++) {
        if(isConnected[i][j]==1){
          uf.union(i,j);
        }
      }
    }
    return  uf.count();
  }
}
