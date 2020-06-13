package com.lozanov;

public class Rectangle extends Shape {
    Point lowerLeft;
    Point upperRight;

    public boolean isBetween(double start, double end, double current) {
        return current >= start && current <= end;
    }

    @Override
    public boolean contains(Point p) {
        return isBetween(lowerLeft.getX(), upperRight.getX(), p.getX()) &&
                isBetween(lowerLeft.getY(), upperRight.getY(), p.getY());
    }

    @Override
    public double calculateArea() {
        return Math.abs(lowerLeft.getX() - upperRight.getY()) * Math.abs(upperRight.getX() - lowerLeft.getY());
    }
}
