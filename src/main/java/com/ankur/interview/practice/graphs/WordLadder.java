package com.ankur.interview.practice.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * Word Ladder (LeetCode 127) — BFS (Shortest Path in Unweighted Graph)
 *
 * Find shortest transformation sequence from beginWord to endWord where
 * each step changes exactly one letter and every intermediate word must
 * be in the wordList.
 *
 * Model as a graph: nodes = words, edges = one-letter differences.
 * BFS finds the shortest path. At each step try all 26 letter substitutions
 * for each position. Remove visited words from the set immediately to avoid
 * revisiting (more efficient than a separate visited set).
 *
 * Time  O(n * L²)  n = wordList size, L = word length (L per word * L positions * 26 letters)
 * Space O(n * L)
 *
 * Example: beginWord="hit", endWord="cog",
 *          wordList=["hot","dot","dog","lot","log","cog"] → 5
 *          (hit→hot→dot→dog→cog)
 * Return 0 if no path exists.
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int steps = 1;

        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                char[] chars = queue.poll().toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char orig = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == orig) continue;
                        chars[i] = c;
                        String next = new String(chars);
                        if (next.equals(endWord)) return steps + 1;
                        if (wordSet.remove(next)) queue.add(next);
                    }
                    chars[i] = orig;
                }
            }
            steps++;
        }
        return 0;
    }
}