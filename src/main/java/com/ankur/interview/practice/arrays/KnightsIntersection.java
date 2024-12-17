package com.ankur.interview.practice.arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class KnightsIntersection {
  /*
  / on infinite chessboard find if knights can intersect each other
  i knight at [0,0] can move in given 8 possible squares
  int[] possible moves = int[ [-2,1], [-1,2], [1,2], [2,1], [2,-1], [1,-2],[-1,-2], [-2,-1]]
  input
  horseA = [0,0]
  horseB = [4,2]
  out put :
  integer minimum number of turns
  output is suggesting minimum hops like shortest path that suggest bfs
   */
  public static int knightConnection(int[] knightA, int[] knightB) {
    // Write your code here.
    int[][] possibleMoves =generatePossibleKnightMoves(knightA);
    Queue<List<Integer>> queue = new ArrayDeque<List<Integer>>();
    Set<String> visited = new HashSet<String>();
    queue.add(Arrays.asList(knightA[0], knightA[1], 0));
    List<Integer> knightAList = Arrays.stream(knightA).boxed().collect(Collectors.toList());
    visited.add(knightAList.toString());

    while (true) {
      List<Integer> currentPosition = queue.remove(); // knightA position in first iteration
      if (currentPosition.get(0) == knightB[0] && currentPosition.get(1) == knightB[1]) {
        return (int) Math.ceil((double) currentPosition.get(2) / 2);
      }
      for (int i = 0; i < possibleMoves.length; i++) {
        ArrayList<Integer> nextPosition = new ArrayList<Integer>();
        nextPosition.add(currentPosition.get(0) + possibleMoves[i][0]);
        nextPosition.add(currentPosition.get(1) + possibleMoves[i][1]);

        String positionString = nextPosition.toString();
        if (!visited.contains(positionString)) {
          nextPosition.add(currentPosition.get(2) + 1);
          queue.add(nextPosition);
          visited.add(positionString);
        }
      }
    }
  }
  public static int[][] generatePossibleKnightMoves(int[] knightA) {
    int[][] baseMoves = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    int[][] possibleKnightAMoves = new int[8][2];

    for (int i = 0; i < 8; i++) {
      possibleKnightAMoves[i][0] = knightA[0] + baseMoves[i][0];
      possibleKnightAMoves[i][1] = knightA[1] + baseMoves[i][1];
    }

    return possibleKnightAMoves;
  }
}
