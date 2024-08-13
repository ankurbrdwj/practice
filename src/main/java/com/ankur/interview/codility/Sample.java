package com.ankur.interview.codility;

public class Sample {
  /*
  /Q2 : given and int in seconds convert it into String like week days hours minutes seconds
But you have to round off to two units only
7263 is 2h1m3s is too many units so round off to nearest smallest possible "2h2m"
86461 is 1 day 1 minutes 1 sec 1d1m1s should be rounded off to "1d2m"
   */
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
