package com.ankur.interview.practice.graphs;

// POJO representing a single tradeable currency in the market graph.
// id is its index in the adjacency matrix used by BellmanFord.detectArbitrage().
public class Currency {

    private final int    id;   // 0-based index, must match matrix row/col
    private final String code; // e.g. "USD", "EUR", "GBP"

    public Currency(int id, String code) {
        this.id   = id;
        this.code = code;
    }

    public int    getId()   { return id; }
    public String getCode() { return code; }

    @Override
    public String toString() { return code; }
}