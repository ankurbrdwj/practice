package com.ankur.interview.practice.stacks;

import java.util.Deque;
import java.util.ArrayDeque;

public class ScoreOfParentheses {

    /*
     * PROBLEM: Score a balanced parentheses string.
     *   "()"    → 1
     *   AB      → score(A) + score(B)
     *   (A)     → 2 * score(A)
     *
     * ─────────────────────────────────────────────────────────────────────
     * KEY INSIGHT: STACK TRACKS SCORE AT EACH DEPTH
     * ─────────────────────────────────────────────────────────────────────
     *
     *   Think of each '(' as opening a new "layer".
     *   The stack holds the running score at each open layer.
     *   When ')' closes a layer, the score bubbles up to the parent layer.
     *
     *   '('  →  push 0        (new layer starts with score 0)
     *   ')'  →  pop top value v
     *              v == 0  →  this was "()"         → add 1 to new top
     *              v >  0  →  this was "(A)"        → add 2*v to new top
     *           shorthand:  add max(2*v, 1) to new top
     *
     *   Seed stack with 0 — the outermost layer's accumulator.
     *
     * ─────────────────────────────────────────────────────────────────────
     * TRACE  "(())"  → expected 2
     * ─────────────────────────────────────────────────────────────────────
     *
     *   stack: [0]          ← seed
     *
     *   '('  push 0         stack: [0, 0]    depth 1 opens
     *   '('  push 0         stack: [0, 0, 0] depth 2 opens
     *   ')'  pop v=0        stack: [0, 0]
     *        max(2*0,1)=1   stack: [0, 1]    "()" found, +1 at depth 1
     *   ')'  pop v=1        stack: [0]
     *        max(2*1,1)=2   stack: [2]       "(A)" found, 2*1=2 bubbles to root
     *
     *   Answer: 2  ✓
     *
     * ─────────────────────────────────────────────────────────────────────
     * TRACE  "()()"  → expected 2
     * ─────────────────────────────────────────────────────────────────────
     *
     *   stack: [0]
     *
     *   '('  push 0         stack: [0, 0]
     *   ')'  pop v=0        stack: [0]
     *        +1             stack: [1]       first "()" → 1
     *   '('  push 0         stack: [1, 0]
     *   ')'  pop v=0        stack: [1]
     *        +1             stack: [2]       second "()" → 1, total = 1+1 = 2
     *
     *   Answer: 2  ✓
     *
     * ─────────────────────────────────────────────────────────────────────
     * TRACE  "(()(()))"  → expected 6
     * ─────────────────────────────────────────────────────────────────────
     *
     *   stack: [0]
     *
     *   '('  push 0         stack: [0, 0]
     *   '('  push 0         stack: [0, 0, 0]
     *   ')'  pop v=0, +1    stack: [0, 1]       "()" at depth 2 → 1
     *   '('  push 0         stack: [0, 1, 0]
     *   '('  push 0         stack: [0, 1, 0, 0]
     *   ')'  pop v=0, +1    stack: [0, 1, 1]    "()" at depth 3 → 1
     *   ')'  pop v=1, +2    stack: [0, 3]       "(A)" wraps 1  → 2, depth2 = 1+2 = 3
     *   ')'  pop v=3, +6    stack: [6]           "(A)" wraps 3  → 6
     *
     *   Answer: 6  ✓
     *
     *   The string structure as a tree:
     *
     *          (        )         →  2 * inner
     *         / \
     *       ()  (  )              →  1  +  2 * inner
     *           |
     *           ()                →  1
     *
     *   Score = 2 * (1 + 2 * 1) = 2 * 3 = 6  ✓
     *
     * ─────────────────────────────────────────────────────────────────────
     * COMPLEXITY
     * ─────────────────────────────────────────────────────────────────────
     *   Time : O(n)  — single pass
     *   Space: O(n)  — stack depth equals max nesting depth
     */

    public static int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // seed: outermost layer accumulator

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0); // open new layer
            } else {
                int v = stack.pop();
                stack.push(stack.pop() + Math.max(2 * v, 1)); // bubble up
            }
        }

        return stack.pop();
    }
}