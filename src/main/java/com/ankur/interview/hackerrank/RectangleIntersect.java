package com.ankur.interview.hackerrank;

import com.ankur.interview.princeton.fundamentals.dataabstraction.Point2D;

public class RectangleIntersect {

    public static void main(String[] args) {
    }
}

class Rectangle {

    private Point2D bottomLeft;
    private Point2D topRight;

    public Rectangle(int x1,int y1, int x3,int y3){
        //this.bottomLeft= new Point2D();
    }
    public Point2D getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Point2D bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Point2D getTopRight() {
        return topRight;
    }

    public void setTopRight(Point2D topRight) {
        this.topRight = topRight;
    }

    public boolean isOverLapping(Rectangle other) {
        if (this.getTopRight().x() < other.getBottomLeft().x()
                || this.getBottomLeft().x() > other.getTopRight().x())
            return false;
        if (this.getTopRight().y() < other.getBottomLeft().y()
                || this.getBottomLeft().y() > other.getTopRight().y())
            return false;
        return true;
    }
}
