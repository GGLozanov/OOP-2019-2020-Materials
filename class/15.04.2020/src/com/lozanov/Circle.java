package com.lozanov;

public class Circle extends Shape {
    private Point center;
    private int radius;

    public Point getCenter() {
        return center;
    }

    @Override
    public boolean contains(Point p) {
        double side1 = Math.abs(p.getX() - center.getX());
        double side2 = Math.abs(p.getY() - center.getY());

        double distanceToCenter = Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2)); // pythagor

        return distanceToCenter < radius;
    }

    public int getRadius() {
        return radius;
    }

    public Circle() {
        this(new Point(), 4);
    }

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI*radius*radius;
    }
}
