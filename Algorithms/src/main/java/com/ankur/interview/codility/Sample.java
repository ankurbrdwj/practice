package com.ankur.interview.codility;

public class Sample {
    public static String solution(int X) {
      // write your code in Java SE 8
      long secInWeek = 604800;
      long week = X/secInWeek;
      long days= (X%secInWeek)/ 86400;
      long hours = ((X%secInWeek) % 86400) / 3600;
      long minutes = (((X%secInWeek) % 86400) % 3600) /60;
      long seconds = (((X % secInWeek) % 86400) % 3600) %60;

      String sb = "";
      sb = week !=0 ? sb+week+"w":sb;
      sb = days !=0 ? sb+days+"d":sb;
      sb = hours !=0 ? sb+hours+"h":sb;
      sb = minutes!=0?sb+minutes+"m":sb;
      sb = seconds !=0? sb+seconds+"s":sb;
      return sb;
    }
  public static void main(String[] args) {
    int X= 10;
    int[] arr= new int[]{2,3};
    System.out.println(solution(86461));
  }
}
