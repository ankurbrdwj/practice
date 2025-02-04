package com.ankur.interview.practice.greedy;

// Node class representing a node in the Huffman Tree
class HuffmanNode {
  char character;
  int frequency;
  HuffmanNode left, right;

  HuffmanNode(char character, int frequency) {
    this.character = character;
    this.frequency = frequency;
    this.left = null;
    this.right = null;
  }
}
