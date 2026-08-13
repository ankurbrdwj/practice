package com.ankur.interview.practice.graphs;

import java.util.Objects;

// POJO representing a single cell in a 2-D grid.
// row increases downward, col increases rightward (standard matrix layout).
// Used as both a coordinate and a graph node in AStar pathfinding.
public class Point {

    public final int row;
    public final int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // equals/hashCode are required so Point works correctly as a HashMap key
    // inside AStar (bestG map) and in goal-reached comparison.
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return row == p.row && col == p.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return "(" + row + "," + col + ")";
    }
}