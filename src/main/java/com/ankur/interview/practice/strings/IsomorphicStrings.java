package com.ankur.interview.practice.strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    /*
     * PROBLEM: Are s and t isomorphic? (characters in s can be replaced to get t)
     *
     * ─────────────────────────────────────────────────────────────────────
     * WHAT ISOMORPHIC MEANS
     * ─────────────────────────────────────────────────────────────────────
     *
     *   There must be a ONE-TO-ONE mapping between characters of s and t.
     *
     *   "egg" → "add"    e→a, g→d          ✓  bijection holds
     *   "foo" → "bar"    f→b, o→a, o→r?    ✗  'o' can't map to both 'a' and 'r'
     *   "bar" → "foo"    b→f, a→o, r→o?    ✗  'a' and 'r' both map to 'o' (not 1-to-1)
     *   "paper"→"title"  p→t, a→i, p→t, e→l, r→e  ✓
     *
     * ─────────────────────────────────────────────────────────────────────
     * WHY TWO MAPS?
     * ─────────────────────────────────────────────────────────────────────
     *
     *   One map (s→t) catches: one s-char mapping to two different t-chars.
     *   But it misses:          two different s-chars mapping to the same t-char.
     *
     *   "bar" → "foo":
     *     sToT: b→f, a→o, r→o   ← no conflict in sToT (all keys unique)
     *     tToS: f→b, o→a, o→r?  ← CONFLICT caught by tToS
     *
     *   So we need BOTH directions enforced simultaneously.
     *
     * ─────────────────────────────────────────────────────────────────────
     * TRACE  s="paper", t="title"
     * ─────────────────────────────────────────────────────────────────────
     *
     *   i=0  s='p' t='t'   sToT: {p→t}        tToS: {t→p}        ✓
     *   i=1  s='a' t='i'   sToT: {p→t, a→i}   tToS: {t→p, i→a}  ✓
     *   i=2  s='p' t='t'   sToT has p→t already, t matches ✓
     *                       tToS has t→p already, p matches ✓
     *   i=3  s='e' t='l'   sToT: {..., e→l}    tToS: {..., l→e}  ✓
     *   i=4  s='r' t='e'   sToT: {..., r→e}    tToS: {..., e→r}  ✓
     *   → true
     *
     * TRACE  s="bar", t="foo"
     * ─────────────────────────────────────────────────────────────────────
     *
     *   i=0  s='b' t='f'   sToT: {b→f}   tToS: {f→b}  ✓
     *   i=1  s='a' t='o'   sToT: {b→f, a→o}  tToS: {f→b, o→a}  ✓
     *   i=2  s='r' t='o'   sToT: 'r' not seen → try to add r→o
     *                       tToS: 'o' already mapped to 'a', but s='r' ≠ 'a'  ✗
     *   → false
     *
     * ─────────────────────────────────────────────────────────────────────
     * COMPLEXITY
     * ─────────────────────────────────────────────────────────────────────
     *   Time : O(n)
     *   Space: O(1)  — at most 256 distinct ASCII chars in each map
     */

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            // check s→t mapping
            if (sToT.containsKey(cs) && sToT.get(cs) != ct) return false;

            // check t→s mapping (catches two s-chars mapping to same t-char)
            if (tToS.containsKey(ct) && tToS.get(ct) != cs) return false;

            sToT.put(cs, ct);
            tToS.put(ct, cs);
        }
        return true;
    }
}