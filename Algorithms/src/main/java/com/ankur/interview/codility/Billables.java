package com.ankur.interview.codility;

import java.math.BigDecimal;
import java.util.*;

public class Billables {
  /*
  /Q3 : Distribute price S in prices B such that
S: String "1.00"
String [] B = ["0.05","1.00"]

first take largest in array that is "1.00"
the B[1] will be replaced by = S * B[1] /(sum of B[i] and its smallest )
b[1] = 1.00 * 1.00 / (0.05 +1.00) => 1/1.05 = 0.95238~
  0.95238~ should be rounded off to 0.95 so B[1] = "0.95"
  b[0] = 0.05 *0.05 / 0.05

  S= 300.00
  b[]= ["300.00","200.00","100.00"]
  B[0] = 300 *300/600 =150
  B[1] = 150 *200/300 =100
  B[2] = 100 *100/100 =50  // this was 50 idk how ?
   */
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
