package com.ankur.interview.practice.stacks;

import java.util.Deque;
import java.util.ArrayDeque;

public class LongestValidParentheses {

    /*
     * PROBLEM: Return the length of the longest valid parentheses substring.
     *
     * ─────────────────────────────────────────────────────────────────────
     * EXAMPLES
     * ─────────────────────────────────────────────────────────────────────
     *
     *   ")()())"  →  4   (the middle "()()" is valid)
     *   "(()"     →  2   (the last "()" is valid)
     *   "(()())"  →  6   (entire string is valid)
     *
     * ─────────────────────────────────────────────────────────────────────
     * KEY INSIGHT: STACK OF INDICES
     * ─────────────────────────────────────────────────────────────────────
     *
     *   Don't store characters — store INDICES.
     *   The stack always holds the index of the last UNMATCHED character.
     *   The bottom of the stack is a "base" sentinel — the index just before
     *   any current valid window starts.
     *
     *   Rule:
     *     '('  →  push its index onto the stack (potential match later)
     *     ')'  →  pop the top
     *               stack empty after pop?  →  this ')' is unmatched;
     *                                          push its index as new base
     *               stack not empty?        →  valid pair found;
     *                                          length = i - stack.peek()
     *
     *   The stack peek after a match is the index of the last unmatched
     *   character — so everything between that index and i is a valid window.
     *
     * ─────────────────────────────────────────────────────────────────────
     * TRACE  ")()())"
     * ─────────────────────────────────────────────────────────────────────
     *
     *   Seed stack with -1 (base sentinel — nothing valid can start before 0)
     *   stack: [-1]
     *
     *   i=0  char=')'
     *     pop -1 → stack empty → unmatched, push 0 as new base
     *     stack: [0]
     *
     *   i=1  char='('
     *     push 1
     *     stack: [0, 1]
     *
     *   i=2  char=')'
     *     pop 1 → stack not empty (peek=0)
     *     length = 2 - 0 = 2,  max=2
     *     stack: [0]
     *
     *   i=3  char='('
     *     push 3
     *     stack: [0, 3]
     *
     *   i=4  char=')'
     *     pop 3 → stack not empty (peek=0)
     *     length = 4 - 0 = 4,  max=4   ← spans indices 1..4 = "()()"
     *     stack: [0]
     *
     *   i=5  char=')'
     *     pop 0 → stack empty → unmatched, push 5 as new base
     *     stack: [5]
     *
     *   Answer: 4
     *
     * ─────────────────────────────────────────────────────────────────────
     * TRACE  "(()())"
     * ─────────────────────────────────────────────────────────────────────
     *
     *   stack: [-1]
     *
     *   i=0 '('  → push 0        stack: [-1, 0]
     *   i=1 '('  → push 1        stack: [-1, 0, 1]
     *   i=2 ')'  → pop 1, peek=0, len = 2-0 = 2,  max=2    stack: [-1, 0]
     *   i=3 '('  → push 3        stack: [-1, 0, 3]
     *   i=4 ')'  → pop 3, peek=0, len = 4-0 = 4,  max=4    stack: [-1, 0]
     *   i=5 ')'  → pop 0, peek=-1, len = 5-(-1) = 6, max=6 stack: [-1]
     *
     *   Answer: 6
     *
     * ─────────────────────────────────────────────────────────────────────
     * WHY  length = i - stack.peek()  ?
     * ─────────────────────────────────────────────────────────────────────
     *
     *   After matching ')' at index i, stack.peek() is the index of the
     *   nearest unmatched character to the LEFT of the current valid window.
     *   Everything from (peek+1) to i is matched and valid.
     *   Length = i - peek.
     *
     *   Example:  base=0, i=4
     *             valid window = indices 1,2,3,4  →  length = 4 - 0 = 4  ✓
     *
     * ─────────────────────────────────────────────────────────────────────
     * COMPLEXITY
     * ─────────────────────────────────────────────────────────────────────
     *   Time : O(n)  — single pass through the string
     *   Space: O(n)  — stack holds at most n indices
     */

    public static int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); // base sentinel

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // new base: this ')' is unmatched
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }
}