package com.ankur.interview.codility;

import java.math.BigDecimal;
import java.util.*;

public class Billables {
  public static String[] solution(String S, String[] B) {
    PriorityQueue<BigDecimal> pq = new PriorityQueue<BigDecimal>(Collections.reverseOrder());
    for(String s :B){
      pq.add(new BigDecimal(s));
    }
    Map<BigDecimal,Integer> map = new HashMap<>();
    for(int i=0;i<B.length;i++){
      map.put(new BigDecimal(B[i]),i);
    }
    BigDecimal runner = new BigDecimal(S);
for(int i=0;i<pq.size();i++){
      BigDecimal bd = pq.poll();
      int index = map.get(bd);
      BigDecimal item = new BigDecimal(B[index]);
      BigDecimal sum = pq.stream().reduce(new BigDecimal(0), BigDecimal::add);
      runner=  runner.multiply(item.divide(sum));
      B[index] = runner.toString();
    }
    // write your code in Java SE 8
    return B;

  }

  public static void main(String[] args) {
    String[] B= new String[]{"0.05","1.00"};
    String S= "1.00";
    System.out.println(solution(S,B));
  }
}
