package com.ankur.interview.practice.popular;

public class WonderfulSubstrings {

    /*
     * PROBLEM: Count substrings where at most one letter has an odd frequency.
     *   Letters: 'a' to 'j' (10 letters only)
     *
     * ─────────────────────────────────────────────────────────────────────
     * STEP 1: REPRESENT PARITY AS A BITMASK
     * ─────────────────────────────────────────────────────────────────────
     *
     *   10 letters → 10-bit integer.
     *   Bit k = 1  means letter ('a'+k) has appeared ODD times so far.
     *   Bit k = 0  means letter ('a'+k) has appeared EVEN times so far.
     *
     *   Example for prefix "aab":
     *     a → seen 2 times → even → bit 0 = 0
     *     b → seen 1 time  → odd  → bit 1 = 1
     *     mask = 0b0000000010 = 2
     *
     *   Toggling: seeing a letter flips its bit  (XOR with 1 << (c - 'a'))
     *
     *     prefix ""    → mask = 0000000000  (0)
     *     prefix "a"   → mask = 0000000001  (1)   toggled bit 0
     *     prefix "aa"  → mask = 0000000000  (0)   toggled bit 0 again
     *     prefix "aab" → mask = 0000000010  (2)   toggled bit 1
     *
     * ─────────────────────────────────────────────────────────────────────
     * STEP 2: PREFIX XOR TO CHECK A SUBSTRING
     * ─────────────────────────────────────────────────────────────────────
     *
     *   For substring word[i+1 .. j]:
     *     parity mask = prefix[j] XOR prefix[i]
     *
     *   WHY: XOR cancels letters that appear in both prefixes (the [0..i] part),
     *   leaving only the parity of letters in [i+1..j].
     *
     *   Example  word = "aab",  substring "ab" (i=1, j=2):
     *     prefix[2] = 0b10 (2),  prefix[1] = 0b00 (0)
     *     XOR = 0b10  → bit 0=0 (a:even), bit 1=1 (b:odd) → 2 odd letters → NOT wonderful
     *
     * ─────────────────────────────────────────────────────────────────────
     * STEP 3: WHAT MAKES A MASK "WONDERFUL"?
     * ─────────────────────────────────────────────────────────────────────
     *
     *   At most ONE letter with odd count  →  at most ONE bit set in XOR mask.
     *
     *   XOR mask = 0          →  0 odd letters  →  wonderful  (all bits 0)
     *   XOR mask = 1 << k     →  1 odd letter   →  wonderful  (exactly one bit)
     *   XOR mask = any other  →  2+ odd letters →  NOT wonderful
     *
     *   So for each position j (current prefix mask = cur):
     *     we need to count all previous prefix masks prev such that:
     *       cur XOR prev == 0          →  prev == cur
     *       cur XOR prev == (1 << k)   →  prev == cur XOR (1 << k),  for k in 0..9
     *
     * ─────────────────────────────────────────────────────────────────────
     * STEP 4: USE A FREQUENCY MAP OF SEEN MASKS
     * ─────────────────────────────────────────────────────────────────────
     *
     *   freq[mask] = how many times this prefix mask has been seen so far.
     *   Seed with freq[0] = 1  (empty prefix before index 0).
     *
     *   For each character:
     *     1. Toggle its bit in cur mask
     *     2. count += freq[cur]                          (XOR = 0 case)
     *     3. count += freq[cur ^ (1<<k)] for k=0..9     (XOR = one bit case)
     *     4. freq[cur]++
     *
     * ─────────────────────────────────────────────────────────────────────
     * FULL TRACE  word = "aab"
     * ─────────────────────────────────────────────────────────────────────
     *
     *   freq = [1, 0, 0, ...]    (freq[0]=1: empty prefix)
     *   count = 0,  cur = 0
     *
     *   i=0, c='a':
     *     cur = 0 XOR (1<<0) = 1  (bit 0 toggled)
     *     count += freq[1]              = 0   (no prev with same mask)
     *     count += freq[1^(1<<0)=0]     = 1   ← substring "a", mask=0b01, one odd 'a' ✓
     *     count += freq[1^(1<<1)=3]     = 0
     *     ... all others 0
     *     count = 1,  freq[1]++ → freq[1]=1
     *
     *   i=1, c='a':
     *     cur = 1 XOR (1<<0) = 0  (bit 0 toggled back)
     *     count += freq[0]              = 1   ← substring "aa", mask=0, all even ✓
     *     count += freq[0^(1<<0)=1]     = 1   ← substring "a" (index 1), one odd 'a' ✓
     *     count += freq[0^(1<<1)=2]     = 0
     *     ... all others 0
     *     count = 3,  freq[0]++ → freq[0]=2
     *
     *   i=2, c='b':
     *     cur = 0 XOR (1<<1) = 2  (bit 1 toggled)
     *     count += freq[2]              = 0
     *     count += freq[2^(1<<0)=3]     = 0
     *     count += freq[2^(1<<1)=0]     = 2   ← substrings "aab" and "b" ✓
     *     count += freq[2^(1<<2)=6]     = 0
     *     ... all others 0
     *     count = 5,  freq[2]++ → freq[2]=1
     *
     *   Answer: 5
     *
     *   Verify by listing all substrings of "aab":
     *     "a"   → a:1 odd           → wonderful ✓
     *     "a"   → a:1 odd           → wonderful ✓   (second 'a')
     *     "b"   → b:1 odd           → wonderful ✓
     *     "aa"  → a:2 even          → wonderful ✓
     *     "ab"  → a:1, b:1 both odd → NOT wonderful ✗
     *     "aab" → a:2 even, b:1 odd → wonderful ✓
     *   Total = 5 ✓
     *
     * ─────────────────────────────────────────────────────────────────────
     * COMPLEXITY
     * ─────────────────────────────────────────────────────────────────────
     *   Time : O(10 * n) = O(n)   — 10 mask checks per character
     *   Space: O(2^10)  = O(1024) — fixed-size freq array, independent of n
     */

    public static long wonderfulSubstrings(String word) {
        int[] freq = new int[1 << 10]; // 1024 possible masks for 10 letters
        freq[0] = 1; // empty prefix
        int cur = 0;
        long count = 0;

        for (char c : word.toCharArray()) {
            cur ^= (1 << (c - 'a')); // toggle this letter's parity bit

            // case 1: all letters even (XOR mask = 0)
            count += freq[cur];

            // case 2: exactly one letter odd (XOR mask = single bit)
            for (int k = 0; k < 10; k++) {
                count += freq[cur ^ (1 << k)];
            }

            freq[cur]++;
        }

        return count;
    }
}