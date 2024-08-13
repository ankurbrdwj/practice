package com.ankur.interview.hackerrank;

import com.ankur.interview.princeton.fundamentals.dataabstraction.Point2D;

import java.util.Arrays;
import java.util.Comparator;

public class KClosestPair {
    public static void main(String... args) {
        Point2D[] points = {new Point2D(-3, -3), new Point2D(-1, -4), new Point2D(3, 2), new Point2D(5, -2),
                new Point2D(7, 5), new Point2D(4, 1), new Point2D(8, 3), new Point2D(-9, -1)};
        points = kClosestPairs(points, 3);
        for (Point2D point : points) {
            System.out.println(point.toString());
        }
    }

    private static Point2D[] kClosestPairs(Point2D[] points, int k) {
        Comparator<Point2D> euclidComparator = Comparator.comparing(KClosestPair::euclidFromOrigin);
        return Arrays.stream(points)
                .sorted(euclidComparator)
                .limit(k)
                .toArray(Point2D[]::new);
    }

    private static int euclidFromOrigin(Point2D point) {
        return (int) Math.sqrt(Math.pow(point.x(), 2) + Math.pow(point.y(), 2));
    }
}
