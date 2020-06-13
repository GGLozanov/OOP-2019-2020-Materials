package com.lozanov;

public class Point {
    private double x;
    private double y;

    public Point() {
        this(1.0, 1.0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
