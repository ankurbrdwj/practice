package com.ankur.interview.practice.arrays;

import java.util.*;
/*
/ find the days in which maximum employees can be trained
https://stackoverflow.com/questions/71988740/find-max-number-of-employees-to-attend-training
 */
public class EmployeeTraining {
  public static void main(String[] args) {
    String[] A= {"039","4","14","32","","34"};
    System.out.println(solutions(A));
  }

  public static int solutions(String[] input) {
    // create map of index in array and list of integer
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int index = 0;
    for(String s : input) {
      List<Integer> list = new ArrayList<>();

      for (int i =0; i < s.length(); i ++) {
        int k = Integer.parseInt(String.valueOf(s.charAt(i)));
        list.add(k);
      }
      map.put(index, list);
      ++index;
    }
    // count the days which are repeated
    Map<Integer, Long> dayFrequency = new HashMap<>();
    for(List<Integer> inputEntry : map.values()) {
      for(Integer day: inputEntry) {
        Long c = dayFrequency.get(day);
        if (c == null) {
          c =0L;
        }
        dayFrequency.put(day, c+1);
      }
    }

    Iterator<Long> it = dayFrequency.values().iterator();
    while (it.hasNext()) {
      Long c = it.next();
      if (c == 1L) {
        it.remove();
      }
    }
    //int mCount = 0;
    Map<String, Integer> map1 = new HashMap<>();
    Set<Integer> set = dayFrequency.keySet();
    for (String s: input) {
      for (int a : set) {
        if (s.contains(a+"")) {
          map1.put(s, a);
        }
      }
    }
    return (int) map1.entrySet().stream().count();
  }
}
