package com.ankur.interview.practice.strings;

public class CountPalindromicSubstrings {

    // Algorithm: Expand Around Center
    //
    // Key insight: every palindrome has a center.
    //   Odd-length  "aba"  → center is a single character  (1 center per char)
    //   Even-length "abba" → center is the gap between two chars (1 center per gap)
    //
    // For a string of length n there are 2n-1 possible centers:
    //   n  character centers  (odd palindromes)
    //   n-1 gap centers       (even palindromes)
    //
    // For each center, expand outward as long as s[left] == s[right].
    // Every successful expansion is one more palindrome — count it.
    //
    // Time:  O(n²) — n centers, each expands up to O(n)
    // Space: O(1)  — no extra storage
    //
    // ═══════════════════════════════════════════════════════
    // FULL TRACE — s = "aaa"    expected answer = 6
    // ═══════════════════════════════════════════════════════
    //
    //   Palindromic substrings:
    //     "a"  (index 0)
    //     "a"  (index 1)
    //     "a"  (index 2)
    //     "aa" (index 0-1)
    //     "aa" (index 1-2)
    //     "aaa"(index 0-2)
    //   Total = 6
    //
    //   i=0 ── ODD center at 'a'
    //     left=0, right=0 → s[0]='a'==s[0]='a' → count=1 (palindrome "a")
    //     expand: left=-1 → out of bounds, stop
    //     → contributed 1
    //
    //   i=0 ── EVEN center between index 0 and 1
    //     left=0, right=1 → s[0]='a'==s[1]='a' → count=2 (palindrome "aa")
    //     expand: left=-1 → out of bounds, stop
    //     → contributed 1
    //
    //   i=1 ── ODD center at 'a'
    //     left=1, right=1 → s[1]='a'==s[1]='a' → count=3 (palindrome "a")
    //     expand: left=0, right=2 → s[0]='a'==s[2]='a' → count=4 (palindrome "aaa")
    //     expand: left=-1 → out of bounds, stop
    //     → contributed 2
    //
    //   i=1 ── EVEN center between index 1 and 2
    //     left=1, right=2 → s[1]='a'==s[2]='a' → count=5 (palindrome "aa")
    //     expand: left=0, right=3 → right out of bounds, stop
    //     → contributed 1
    //
    //   i=2 ── ODD center at 'a'
    //     left=2, right=2 → s[2]='a'==s[2]='a' → count=6 (palindrome "a")
    //     expand: left=1, right=3 → right out of bounds, stop
    //     → contributed 1
    //
    //   i=2 ── EVEN center between index 2 and 3
    //     right=3 → immediately out of bounds, skip
    //     → contributed 0
    //
    //   Total count = 6 ✓
    //
    // ── Quick trace: s = "abc"   expected = 3 ──────────────
    //
    //   i=0 odd:  "a" → 1;  even: 'a'≠'b' → 0
    //   i=1 odd:  "b" → 1, expand 'a'≠'c' stop;  even: 'b'≠'c' → 0
    //   i=2 odd:  "c" → 1;  even: right OOB → 0
    //   Total = 3 ✓  (each single character is its own palindrome, no multi-char ones)
    //
    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expandAndCount(s, i, i);     // odd-length: center is character i
            count += expandAndCount(s, i, i + 1); // even-length: center is gap between i and i+1
        }
        return count;
    }

    // Expand outward from (left, right) while characters match.
    // Each matching expansion is a valid palindrome, so increment count each time.
    private static int expandAndCount(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}