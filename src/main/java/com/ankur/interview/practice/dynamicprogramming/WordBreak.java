package com.ankur.interview.practice.dynamicprogramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    // Algorithm: Dynamic Programming (bottom-up)
    //
    // dp[i] = true means the first i characters of s (s[0..i-1]) can be
    //         fully segmented using words from wordDict.
    //
    // Transition:
    //   dp[i] = true  if there exists any split point j (0 ≤ j < i) where:
    //             dp[j] == true          ← prefix s[0..j-1] is already segmentable
    //             AND s[j..i-1] ∈ dict   ← the remaining slice is a dict word
    //
    //   In other words: "can I find a last word that ends exactly at position i,
    //   and everything before it is also segmentable?"
    //
    // Base case: dp[0] = true  (empty string needs no words → trivially segmentable)
    //
    // Answer: dp[s.length()]
    //
    // Time:  O(n²)  — n positions × n split points; HashSet lookup is O(word_len) ≈ O(1)
    // Space: O(n + d)  — dp array + HashSet of dict words
    //
    // ══════════════════════════════════════════════════════════════════
    // TRACE 1 — s="leetcode", dict={"leet","code"}   expected: true
    // ══════════════════════════════════════════════════════════════════
    //
    //   index:  0  1  2  3  4  5  6  7  8
    //   dp:    [T, F, F, F, ?, ?, ?, ?, ?]   ← T=base case
    //
    //   i=1: j=0: dp[0]=T, s[0..0]="l"    not in dict → dp[1]=F
    //   i=2: j=0: dp[0]=T, s[0..1]="le"   not in dict → dp[2]=F
    //   i=3: j=0: dp[0]=T, s[0..2]="lee"  not in dict → dp[3]=F
    //   i=4: j=0: dp[0]=T, s[0..3]="leet" ✓ in dict  → dp[4]=T
    //   i=5: j=0: "leetc" no; j=4: dp[4]=T, s[4..4]="c"    no → dp[5]=F
    //   i=6: j=0: "leetco" no; j=4: dp[4]=T, s[4..5]="co"  no → dp[6]=F
    //   i=7: j=0: "leetcod" no; j=4: dp[4]=T, s[4..6]="cod" no → dp[7]=F
    //   i=8: j=0: "leetcode" no; j=4: dp[4]=T, s[4..7]="code" ✓ → dp[8]=T
    //
    //   dp = [T, F, F, F, T, F, F, F, T]
    //   return dp[8] = true ✓
    //
    // ══════════════════════════════════════════════════════════════════
    // TRACE 2 — s="catsandog", dict={"cats","dog","sand","and","cat"}
    //           expected: false
    // ══════════════════════════════════════════════════════════════════
    //
    //   i=3: j=0: "cat"  ✓ → dp[3]=T
    //   i=4: j=0: "cats" ✓ → dp[4]=T
    //   i=7: j=3: dp[3]=T, s[3..6]="sand" ✓ → dp[7]=T
    //         j=4: dp[4]=T, s[4..6]="and"  ✓ → dp[7]=T  (two ways to reach i=7)
    //   i=8: j=7: dp[7]=T, s[7..7]="o"  not in dict
    //         j=4: dp[4]=T, s[4..7]="ando" not in dict
    //         j=3: dp[3]=T, s[3..7]="sando" not in dict
    //         → dp[8]=F
    //   i=9: j=7: dp[7]=T, s[7..8]="og"  not in dict
    //         j=4: dp[4]=T, s[4..8]="andog" not in dict
    //         → dp[9]=F
    //
    //   return dp[9] = false ✓  ("dog" starts at index 6 but dp[6] is F — no valid prefix)
    //
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict); // O(1) lookup
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // base case: empty prefix is always segmentable

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // if prefix s[0..j-1] is segmentable AND s[j..i-1] is a dict word
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // no need to check other split points for this i
                }
            }
        }

        return dp[n];
    }
}