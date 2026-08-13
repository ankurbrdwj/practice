package com.ankur.interview.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /*
     * PROBLEM: Given n pairs of parentheses, generate all well-formed combinations.
     *   n=2 → ["(())", "()()"]
     *   n=3 → ["((()))", "(()())", "(())()", "()(())", "()()()"]
     *
     * ─────────────────────────────────────────────────────────────────────
     * MAPPING THE BACKTRACKING TEMPLATE
     * ─────────────────────────────────────────────────────────────────────
     *
     *   void backtrack(...) {
     *       if (baseCase)          → current.length() == 2 * n
     *           answer.add(...)    → add current string to result
     *           return;
     *
     *       for (choice : choices) → two choices at every step: '(' or ')'
     *           makeChoice         → current.append(char)
     *           backtrack(...)     → recurse with updated open/close count
     *           undoChoice         → current.deleteCharAt(last index)
     *   }
     *
     *   CONSTRAINTS that prune invalid branches BEFORE placing:
     *     add '('  only if  open < n          (still have opening brackets left)
     *     add ')'  only if  close < open      (can't close what isn't open)
     *
     * ─────────────────────────────────────────────────────────────────────
     * DECISION TREE  (n=2)
     * ─────────────────────────────────────────────────────────────────────
     *
     *                        ""
     *                   open=0, close=0
     *                         |
     *               only '(' allowed  (close < open is false)
     *                         |
     *                        "("
     *                   open=1, close=0
     *                    /           \
     *                  "("           ")"
     *              open=2,cl=0    open=1,cl=1
     *               /                   \
     *             ")"               only "(" allowed
     *          open=2,cl=1          (close=1 == open=1, can't add ')')
     *           /                         |
     *         ")"                        "("
     *      open=2,cl=2               open=2,cl=1
     *      length=4 ✓                     |
     *      → "(())"                      ")"
     *                                open=2,cl=2
     *                                length=4 ✓
     *                                → "()()"
     *
     *   Pruned branches (never explored):
     *     ')' at root          → close(0) < open(0) is false
     *     ')' when cl == open  → would create unmatched ')'
     *     '(' when open == n   → no brackets left to open
     *
     * ─────────────────────────────────────────────────────────────────────
     * COMPLEXITY
     * ─────────────────────────────────────────────────────────────────────
     *   Time : O(4^n / √n)  — nth Catalan number of valid sequences
     *   Space: O(n)          — recursion depth is at most 2*n
     */

    public static List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder current,
                                  int open, int close, int n) {
        // base case: used all n pairs
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // choice 1: add '(' if we still have opening brackets left
        if (open < n) { // '(' cannot be more then n ,
            current.append('(');              // makeChoice
            backtrack(result, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1); // undoChoice
        }

        // choice 2: add ')' if it won't become unmatched
        if (close < open) {
            current.append(')');              // makeChoice
            backtrack(result, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1); // undoChoice
        }
    }
}