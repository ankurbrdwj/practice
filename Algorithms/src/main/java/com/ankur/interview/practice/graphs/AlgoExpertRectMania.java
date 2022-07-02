package com.ankur.interview.practice.graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AlgoExpertRectMania {
    public static int rectangleMania(Point[] coords) {
        Map<Point, Integer> countYLines = new HashMap<>();
        int answer = 0;
        for (Point p : coords) {
            for (Point pAbove : coords) {
                if (p.x == pAbove.x && pAbove.y > p.y) {
                    Point point = new Point(p.y, pAbove.y);
                    Integer count = countYLines.get(point) == null ? 0 : countYLines.get(point);
                    answer = answer + count;
                    countYLines.put(point, ++count);
                }
            }
        }
        return answer > 0 ? answer : -1;

    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    public static void main(String[] args) {
        Point[] array = {new Point(0, 0), new Point(0, 2), new Point(2, 0), new Point(2, 2), new Point(4, 0), new Point(4, 2),};
        System.out.println(rectangleMania(array));

    }
}
