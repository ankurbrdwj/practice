package com.ankur.interview.practice.popular;

// Given a 2D trajectory as a series of (x, y, t) tuples where t increases
// monotonically and segments between points are straight lines:
//
// Q1: Given any t, return the (x, y) position at that time.
// Q2: Given any point P on the plane, find its shortest distance to the trajectory.
//     How do you reduce computation cost when the trajectory has many segments?
//
// Q1 approach: binary search to find the segment containing t, then lerp.
//   Time: O(log n)
//
// Q2 approach: for each segment, compute point-to-segment distance, take the min.
//   Naive: O(n) per query.
//   Optimized: build a spatial index (e.g. R-tree / bounding-box filter) so only
//   nearby segments are checked. Expected O(log n) per query after O(n log n) build.

public class Trajectory {

    // Each point is [x, y, t]
    private final double[][] points;

    public Trajectory(double[][] points) {
        this.points = points;
    }

    // Q1: interpolate position at time t — O(log n)
    public double[] positionAt(double t) {
        int lo = 0, hi = points.length - 1;

        // clamp to trajectory bounds
        if (t <= points[lo][2]) return new double[]{points[lo][0], points[lo][1]};
        if (t >= points[hi][2]) return new double[]{points[hi][0], points[hi][1]};

        // binary search for the segment [lo, lo+1] that contains t
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (points[mid][2] <= t) lo = mid;
            else hi = mid;
        }

        double t0 = points[lo][2], t1 = points[hi][2];
        double ratio = (t - t0) / (t1 - t0); // how far along the segment
        double x = points[lo][0] + ratio * (points[hi][0] - points[lo][0]);
        double y = points[lo][1] + ratio * (points[hi][1] - points[lo][1]);
        return new double[]{x, y};
    }

    // Q2: shortest distance from point P=(px,py) to the full trajectory — O(n)
    // Optimization note: precompute axis-aligned bounding boxes per segment and
    // skip any segment whose min possible distance already exceeds current best.
    public double shortestDistance(double px, double py) {
        double minDist = Double.MAX_VALUE;
        for (int i = 0; i + 1 < points.length; i++) {
            double d = pointToSegmentDist(px, py,
                    points[i][0], points[i][1],
                    points[i + 1][0], points[i + 1][1]);
            if (d < minDist) minDist = d;
        }
        return minDist;
    }

    // Distance from point P to segment AB.
    // Project P onto line AB; clamp projection to [0,1] to stay on the segment.
    private double pointToSegmentDist(double px, double py,
                                      double ax, double ay,
                                      double bx, double by) {
        double abx = bx - ax, aby = by - ay;
        double len2 = abx * abx + aby * aby;

        if (len2 == 0) return Math.hypot(px - ax, py - ay); // degenerate segment (a==b)

        // t = projection parameter: 0 = at A, 1 = at B
        double t = ((px - ax) * abx + (py - ay) * aby) / len2;
        t = Math.max(0, Math.min(1, t)); // clamp to segment

        double closestX = ax + t * abx;
        double closestY = ay + t * aby;
        return Math.hypot(px - closestX, py - closestY);
    }

    public static void main(String[] args) {
        // Trajectory: (0,0,t=0) → (4,0,t=4) → (4,3,t=7)
        //
        //   y
        //   3        * (4,3) t=7
        //   |        |
        //   0  *-----* (4,0) t=4
        //      (0,0) t=0
        //      0    4   x
        double[][] points = {
            {0, 0, 0},
            {4, 0, 4},
            {4, 3, 7}
        };
        Trajectory traj = new Trajectory(points);

        // --- Q1: positionAt(t) ---
        System.out.println("=== Q1: positionAt ===");

        // t=2: halfway along first segment (0,0)→(4,0), expect (2.0, 0.0)
        double[] p1 = traj.positionAt(2);
        System.out.printf("t=2  → (%.1f, %.1f)  expected (2.0, 0.0)%n", p1[0], p1[1]);

        // t=4: exactly at (4,0)
        double[] p2 = traj.positionAt(4);
        System.out.printf("t=4  → (%.1f, %.1f)  expected (4.0, 0.0)%n", p2[0], p2[1]);

        // t=5.5: 1.5/3 of the way along (4,0)→(4,3), expect (4.0, 1.5)
        double[] p3 = traj.positionAt(5.5);
        System.out.printf("t=5.5→ (%.1f, %.1f)  expected (4.0, 1.5)%n", p3[0], p3[1]);

        // t=-1: before start, clamped to (0,0)
        double[] p4 = traj.positionAt(-1);
        System.out.printf("t=-1 → (%.1f, %.1f)  expected (0.0, 0.0)%n", p4[0], p4[1]);

        // t=99: after end, clamped to (4,3)
        double[] p5 = traj.positionAt(99);
        System.out.printf("t=99 → (%.1f, %.1f)  expected (4.0, 3.0)%n", p5[0], p5[1]);

        // --- Q2: shortestDistance(px, py) ---
        System.out.println("\n=== Q2: shortestDistance ===");

        // Point directly on the trajectory → distance 0
        double d1 = traj.shortestDistance(2, 0);
        System.out.printf("P=(2,0)  on segment 1 → %.4f  expected 0.0000%n", d1);

        // Point above the horizontal segment → perpendicular drop to (2,0), dist=3
        double d2 = traj.shortestDistance(2, 3);
        System.out.printf("P=(2,3)  above seg1  → %.4f  expected 3.0000%n", d2);

        // Point to the left of the vertical segment → perpendicular to (4,2), dist=2
        double d3 = traj.shortestDistance(2, 2);
        System.out.printf("P=(2,2)  left of seg2→ %.4f  expected 2.0000%n", d3);

        // Point far from the trajectory — closest to end point (4,3)
        double d4 = traj.shortestDistance(7, 7);
        System.out.printf("P=(7,7)  far away    → %.4f  expected %.4f%n", d4, Math.hypot(3, 4));
    }
}