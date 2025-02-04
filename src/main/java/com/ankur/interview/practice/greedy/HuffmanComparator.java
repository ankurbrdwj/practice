package com.ankur.interview.practice.greedy;

import java.util.Comparator;

// Comparator class for the priority queue
class HuffmanComparator implements Comparator<HuffmanNode> {
  public int compare(HuffmanNode a, HuffmanNode b) {
    return a.frequency - b.frequency; // Sort by frequency
  }
}
