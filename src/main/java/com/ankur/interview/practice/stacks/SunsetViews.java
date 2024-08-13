package com.ankur.interview.practice.stacks;

import java.util.*;
import java.util.stream.Collectors;

public class SunsetViews {
  /*
  return the indices of buildings that can see sunset
  east facing
   if building is taller than all building on it's right in array will see sunset
    height is max then all in right
   west facing
   if building is taller than all buildings to left then it will see sun set
   */
  public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
    int startIdx = buildings.length - 1;
    int step = -1;
    if ("EAST".equals(direction)) {
      startIdx = 0;
      step = 1;
    }
    int i= startIdx;
    ArrayList<Integer> stack = new ArrayList<>();
    while (i >= 0 && i < buildings.length) {
      int buildingHeight = buildings[i];
      while (stack.size()>0 && buildings[stack.get(stack.size()-1)] <= buildingHeight) {
        stack.remove(stack.get(stack.size()-1));
      }
      stack.add(i);
      i = i + step;
    }
    if ("WEST".equals(direction)) {
      Collections.reverse(stack);
    }
    return stack;
  }
  public static ArrayList<Integer> sunsetViews2(int[] buildings, String direction) {
    int startIdx = buildings.length - 1;
    int step = -1;
    if ("WEST".equals(direction)) {
      startIdx = 0;
      step = 1;
    }
    int i= startIdx;
    int runningMaxHeight = 0;
    ArrayList<Integer> stack = new ArrayList<>();
    while (i >= 0 && i < buildings.length) {
      int buildingHeight = buildings[i];
      if(buildingHeight >runningMaxHeight) {
        stack.add(i);
      }
      runningMaxHeight = Math.max(buildingHeight,runningMaxHeight);
      i = i + step;
    }
    if ("EAST".equals(direction)) {
      Collections.reverse(stack);
    }
    return stack;
  }
}
