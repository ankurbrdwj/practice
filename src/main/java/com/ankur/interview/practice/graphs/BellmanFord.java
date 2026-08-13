package com.ankur.interview.practice.graphs;

import java.util.Arrays;

public class BellmanFord {

    // =========================================================================
    // REAL-WORLD APPLICATION: CURRENCY ARBITRAGE DETECTION
    // =========================================================================
    //
    // Arbitrage = making risk-free profit by exploiting price gaps across markets.
    //
    //   Example loop:  100 USD → 90 EUR → 121.5 GBP → 103 USD  (profit: $3!)
    //
    // A profitable loop exists when:  rate1 × rate2 × ... × rateN > 1
    //
    // MATH TRICK — convert multiplication to addition with logarithms:
    //   log(rate1 × rate2 × ... × rateN) > 0
    //   log(rate1) + log(rate2) + ... + log(rateN) > 0
    //
    // Set edge weight = -log(rate).  A negative-weight CYCLE then means
    //   sum of -log(rates) < 0  ⟺  product of rates > 1  ⟺  ARBITRAGE!
    //
    //   Concrete numbers (USD→EUR→GBP→USD):
    //     −log(0.90) + −log(0.85) + −log(1.35)
    //   =   +0.105   +   +0.163   +   −0.300
    //   =   −0.032  < 0  ✓
    //
    //   Why does a negative sum guarantee product > 1?  Algebra:
    //
    //     −log(r1) + −log(r2) + −log(r3)  <  0      (observed)
    //    −(log(r1)  +  log(r2)  +  log(r3)) <  0      (factor out −1)
    //      log(r1)  +  log(r2)  +  log(r3)  >  0      (flip inequality)
    //      log(r1 × r2 × r3)               >  0      (log product rule)
    //          r1 × r2 × r3                >  e⁰ = 1  (exponentiate both sides)
    //
    //   In plain English: the log turns "did I grow my money?" (product > 1)
    //   into "is the running total positive?" (sum > 0).  Negating flips it
    //   into the shortest-path framing: negative sum = negative cycle = profit.
    //
    // =========================================================================
    // EXAMPLE TRACE — 3 Currencies, 1 Arbitrage Loop
    // =========================================================================
    //
    //   Nodes:  0=USD   1=EUR   2=GBP
    //
    //   Exchange rates (simplified):
    //     USD → EUR : 0.90    weight = -log(0.90) ≈ +105  (×1000 for clarity)
    //     EUR → GBP : 0.85    weight = -log(0.85) ≈ +163
    //     GBP → USD : 1.35    weight = -log(1.35) ≈ -300
    //
    //   Sanity check:  0.90 × 0.85 × 1.35 = 1.03 > 1  →  Arbitrage exists!
    //   Cycle weight:  105 + 163 + (−300) = −32 < 0    ←  Bellman-Ford catches this
    //
    //   Graph (directed):
    //
    //          +105          +163
    //    USD ──────► EUR ──────► GBP
    //     ▲                       │
    //     │          −300         │
    //     └───────────────────────┘
    //
    // ── Initial state ──────────────────────────────────────────────────────────
    //
    //   dist  = [ USD:   0,   EUR:  ∞,   GBP:  ∞ ]
    //
    // ── Pass 1 of 2  (n−1 = 2 passes) ─────────────────────────────────────────
    //
    //   Relax USD→EUR :  0   + 105 =  105  < ∞    →  dist[EUR] = 105
    //   Relax EUR→GBP :  105 + 163 =  268  < ∞    →  dist[GBP] = 268
    //   Relax GBP→USD :  268 − 300 =  −32  < 0    →  dist[USD] = −32  ← already better!
    //
    //   dist  = [ USD: −32,   EUR: 105,   GBP: 268 ]
    //
    // ── Pass 2 of 2 ────────────────────────────────────────────────────────────
    //
    //   Relax USD→EUR :  −32 + 105 =   73  < 105  →  dist[EUR] =  73
    //   Relax EUR→GBP :   73 + 163 =  236  < 268  →  dist[GBP] = 236
    //   Relax GBP→USD :  236 − 300 =  −64  < −32  →  dist[USD] = −64
    //
    //   dist  = [ USD: −64,   EUR:  73,   GBP: 236 ]
    //
    // ── Detection pass (nth pass — any relaxation = negative cycle) ─────────────
    //
    //   Relax USD→EUR :  −64 + 105 =  41   < 73   →  STILL IMPROVING → neg-cycle!
    //   Mark USD, EUR, GBP all inNegCycle = true
    //
    //   Result: every node returns Integer.MIN_VALUE  →  Arbitrage loop confirmed!
    //
    // =========================================================================

    // Returns shortest distances from `start` to all vertices.
    // -1 means unreachable; Integer.MIN_VALUE means the vertex is on or
    // downstream of a negative-weight cycle (distance is unboundedly negative).
    //
    // edges[u] = [[v, weight], ...] — same format as Dijkstra in this package.
    // Unlike Dijkstra, handles negative edge weights and detects negative cycles.
    // Time: O(V * E)   Space: O(V)
    public static int[] bellmanFord(int start, int[][][] edges) {
        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // After k passes, dist[v] holds the shortest path from `start` using
        // at most k edges. A cycle-free path visits at most n vertices, so it
        // uses at most n-1 edges — n-1 passes always converge on a valid graph.
        for (int pass = 0; pass < n - 1; pass++) {
            for (int u = 0; u < n; u++) {
                if (dist[u] == Integer.MAX_VALUE) continue; // u not yet reached
                for (int[] edge : edges[u]) {
                    int v = edge[0], w = edge[1];
                    // Edge relaxation: is the path to v through u cheaper than
                    // the best known path to v? If so, update dist[v].
                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }

        // If a distance still improves on the nth pass, a path of n edges
        // exists — meaning some vertex is visited twice, i.e. there is a
        // negative-weight cycle reachable from `start` on that path.
        boolean[] inNegCycle = new boolean[n];
        for (int u = 0; u < n; u++) {
            if (dist[u] == Integer.MAX_VALUE) continue;
            for (int[] edge : edges[u]) {
                int v = edge[0], w = edge[1];
                if (dist[u] + w < dist[v] || inNegCycle[u]) {
                    inNegCycle[v] = true;
                }
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) result[i] = -1;               // unreachable
            else if (inNegCycle[i])           result[i] = Integer.MIN_VALUE; // negative cycle
            else                              result[i] = dist[i];
        }
        return result;
    }

    // Detects whether a profitable arbitrage cycle exists among currencies.
    //
    // rates[i][j] = exchange rate from currency i to currency j
    //               (0 means no direct exchange exists between i and j)
    //
    // Edge weight = -log(rate):  a negative-weight cycle means rate_product > 1,
    // i.e. you can start with $1, traverse the cycle, and return with more than $1.
    //
    // Returns true if an arbitrage opportunity exists.
    public static boolean detectArbitrage(double[][] rates) {
        int n = rates.length;
        double[] dist = new double[n];
        Arrays.fill(dist, Double.MAX_VALUE);
        dist[0] = 0; // start from currency 0 (e.g. USD)

        for (int pass = 0; pass < n - 1; pass++) {
            for (int u = 0; u < n; u++) {
                if (dist[u] == Double.MAX_VALUE) continue;
                for (int v = 0; v < n; v++) {
                    if (rates[u][v] == 0) continue; // no direct exchange
                    double w = -Math.log(rates[u][v]); // key transformation
                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }

        // nth pass: if any edge still relaxes, a negative cycle (arbitrage) exists
        for (int u = 0; u < n; u++) {
            if (dist[u] == Double.MAX_VALUE) continue;
            for (int v = 0; v < n; v++) {
                if (rates[u][v] == 0) continue;
                double w = -Math.log(rates[u][v]);
                if (dist[u] + w < dist[v]) {
                    return true; // arbitrage!
                }
            }
        }
        return false;
    }
}