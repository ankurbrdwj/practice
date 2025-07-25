package com.ankur.interview.practice.popular;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StableIntern {
  public StableIntern() {
  }

  public static int[][] stableInternships(int[][] interns, int[][] teams) {
    // Write your code here.
    Map<Integer, Integer> chosenOnes = new HashMap<>();
    Deque<Integer> unmatchedInterns = new java.util.ArrayDeque<>();
    for (int i = 0; i < interns.length; i++) {
      unmatchedInterns.push(i);
    }
    List<Map<Integer, Integer>> teamsLookupMap = new ArrayList<>();
    for (int internId = 0; internId < teams.length; internId++) {
      Map<Integer, Integer> teamChoices = new HashMap<>();
      for (int rank = 0; rank < teams[internId].length; rank++) {
        teamChoices.put(teams[internId][rank], rank);
      }
      teamsLookupMap.add(teamChoices);
    }
    int[] preferenceLevelIndexes = new int[interns.length];
    while (!unmatchedInterns.isEmpty()) {
      int internNum = unmatchedInterns.pop();
      int[] internChoices = interns[internNum];
      int atIndex = preferenceLevelIndexes[internNum];
      int teamHeLikes = internChoices[atIndex];
      preferenceLevelIndexes[internNum] += 1;
      if (!chosenOnes.containsKey(teamHeLikes)) {
        chosenOnes.put(teamHeLikes, internNum);
        continue;
      }
      int previousIntern = chosenOnes.get(teamHeLikes);
      int previousInternRank = teamsLookupMap.get(teamHeLikes).get(previousIntern);
      int currentInternRank = teamsLookupMap.get(teamHeLikes).get(internNum);
      if (currentInternRank < previousInternRank) {
        unmatchedInterns.push(previousIntern);
        chosenOnes.put(teamHeLikes, internNum);
      } else {
        unmatchedInterns.push(internNum);
      }
    }
      int[][] matches = new int[interns.length][2];
      int index = 0;
      for (Map.Entry<Integer, Integer> chosenOne : chosenOnes.entrySet()) {
        matches[index][0] = chosenOne.getValue(); // intern number
        matches[index][1] = chosenOne.getKey(); // team number
        index++;
      }
      return matches;
    }
  }

