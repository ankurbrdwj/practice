package com.ankur.interview.practice.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AssignTasks {
  /*
  / assign tasks to k workers from list of tasks

   */
  public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
    ArrayList<ArrayList<Integer>> pairedTasks = new ArrayList<>();
    // map to remember indices because we will sort them
    Map<Integer, ArrayList<Integer>> map= mapTasksToIndices(tasks);
    ArrayList<Integer> sortedTasks = tasks;
    Collections.sort(sortedTasks);
    for (int i = 0; i < k; i++) {
      // take small task
      int task1 = tasks.get(i);
      // where is larger one ?
      int task2 = sortedTasks.get(sortedTasks.size()-1-i);
      // get their indices from the map
      ArrayList<Integer> task1IndicesList= map.get(task1);
      int task1Index=  task1IndicesList.remove(task1IndicesList.size()-1);

      ArrayList<Integer> task2IndicesList= map.get(task2);

      int task2Index=  task2IndicesList.remove(task2IndicesList.size()-1);
      ArrayList<Integer> taskPair= new ArrayList<>();
      taskPair.add(task1Index);
      taskPair.add(task2Index);
      pairedTasks.add(taskPair);
    }
    return pairedTasks;
  }

  Map<Integer, ArrayList<Integer>> mapTasksToIndices(ArrayList<Integer> tasks) {
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    for (int i = 0; i < tasks.size(); i++) {
      int taskDuration = tasks.get(i);
      if (map.containsKey(taskDuration)) {
        map.get(taskDuration).add(i);
      } else {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(i);
        map.put(taskDuration, list);
      }
    }
    return map;
  }
}
