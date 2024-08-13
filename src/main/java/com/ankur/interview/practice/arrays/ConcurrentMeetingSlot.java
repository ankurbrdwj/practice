package com.ankur.interview.practice.arrays;

import java.util.PriorityQueue;

public class ConcurrentMeetingSlot {
  /*
  Given a two dimensional array arr[][] of dimensions N * 2 which contains the starting
  and ending time for N meetings on a given day. The task is to print a list of time slots
   during which most number of concurrent meetings can be held./
   Solution
   question is which meeting are not int concurrent slot ??
ones which end before start time and  ones which start after min end time

now check if this current meeting
 condition 1: start time is less then window end // dont keep the others in pq
 condition 2: end time is more then or equal to window end // 1st will take care of this

store such meetings in a pq
check for max length
reset start and end each time length changes

return start and end times
   */

  public static int[] getMostConcurrentMeetingSlot(int[][] meetings) {
    int max_start = 0;
    int max_end = 0;
    int maxLen = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    //pq.add(meetings[0][1]);

    for (int[] meeting : meetings) {
      while (!pq.isEmpty() && meeting[0] >= pq.peek()) {
        pq.poll();
      }
      pq.add(meeting[1]);

      if (pq.size() > maxLen) {
        maxLen = pq.size();
        max_start = meeting[0];
        max_end = pq.peek();
      }
      System.out.println(max_start + " " + max_end);}

    return new int[]{max_start, max_end};
  }

  public static void main(String[] args) {
    int[][] meetings =
      {{100, 300},{
      145, 215}, {
      200, 230}, {
      215, 300}, {
      215, 400}, {
      500, 600}, {
      600, 700}};
    System.out.println(getMostConcurrentMeetingSlot(meetings));
  }
}
