package com.ankur.interview.practice.greedy;

import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

public class HuffmanEncoding {
  // Generate the Huffman Tree and encode the characters
  public static Map<Character, String> generateHuffmanCodes(Map<Character, Integer> frequencyMap) {
    // Priority queue to store nodes of the Huffman tree
    PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new HuffmanComparator());

    // Create a leaf node for each character and add it to the priority queue
    for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
      pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
    }

    // Build the Huffman Tree
    while (pq.size() > 1) {
      HuffmanNode left = pq.poll();
      HuffmanNode right = pq.poll();

      // Merge the two nodes
      HuffmanNode newNode = new HuffmanNode('\0', left.frequency + right.frequency);
      newNode.left = left;
      newNode.right = right;

      pq.add(newNode);
    }

    // Root of the Huffman Tree
    HuffmanNode root = pq.poll();

    // Generate Huffman Codes
    Map<Character, String> huffmanCodes = new HashMap<>();
    generateCodesRecursive(root, "", huffmanCodes);
    return huffmanCodes;
  }

  // Recursive function to generate Huffman codes
  private static void generateCodesRecursive(HuffmanNode node, String code, Map<Character, String> huffmanCodes) {
    if (node == null) return;

    // If it's a leaf node, add the character and its code
    if (node.left == null && node.right == null) {
      huffmanCodes.put(node.character, code);
      return;
    }

    generateCodesRecursive(node.left, code + "0", huffmanCodes);
    generateCodesRecursive(node.right, code + "1", huffmanCodes);
  }

  // Main function
  public static void main(String[] args) {
    // Input: frequency map for characters
    Map<Character, Integer> frequencyMap = new HashMap<>();
    frequencyMap.put('a', 5);
    frequencyMap.put('b', 9);
    frequencyMap.put('c', 12);
    frequencyMap.put('d', 13);
    frequencyMap.put('e', 16);
    frequencyMap.put('f', 45);

    // Generate Huffman Codes
    Map<Character, String> huffmanCodes = generateHuffmanCodes(frequencyMap);

    // Output the Huffman codes
    System.out.println("Huffman Codes:");
    for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}
