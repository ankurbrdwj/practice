package com.ankur.interview.practice.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class FreelancingProfit {
  /*
  / each job requires 1 day and se have deadlines and payments for each
   jobs = [
    {"deadline": 1, "payment": 1},
    {"deadline": 2, "payment": 2},
    {"deadline": 2, "payment": 2},
    {"deadline": 7, "payment": 1},
    {"deadline": 4, "payment": 3},
    {"deadline": 4, "payment": 5},
    {"deadline": 3, "payment": 1}]
  max deadline time is end of days we have
  we need max payment
  here its 5 and it takes 1 day to finish it should be finished before day 4
  so we definitely want it , but we have option to finish this in day 4
  before that we can take another tasks
  so we will sort by payments descending and fill our array in order of deadline value
   */
  public int freelanceMaxProfit(Map<String,Integer>[] jobs){
    int LENGHT_OF_WEEK=7;
    Arrays.sort(jobs, new Comparator<Map<String, Integer>>() {
      @Override
      public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
        return o2.get("payment").compareTo(o1.get("payment"));
      }
    });
    // pick and place as per deadline index
    int profit=0;
    boolean[] timeline = new boolean[LENGHT_OF_WEEK];
    for(int i =0;i< jobs.length;i++){
      Map<String,Integer> job = jobs[i];

      int deadline = job.get("deadline");
      int payment = job.get("payment");
      // we want to place max payment job in deadline-1 place
      int maxTime= Math.min(deadline,LENGHT_OF_WEEK);
      // try to fill other jobs less than maxTimeline
      for (int j=maxTime-1;j>=0;j--){
        // we want to keep checking if the spot is filled in array
        if(!timeline[j]){
          timeline[j]=true;
          profit += payment;
          break;
        }
      }
    }
    return profit;

  }
}
