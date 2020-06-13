package com.lozanov;

public class Triangle extends Shape {
    private Point a;
    private Point b;
    private Point c;

    public Point getA() {
        return a;
    }

    private double calculateSide(Point point1, Point point2) {
        double side1 = Math.abs(point1.getX() - point2.getX()) * Math.abs(point1.getX() - point2.getX());
        double side2 = Math.abs(point1.getY() - point2.getY()) * Math.abs(point1.getY() - point2.getY());
        return Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
    }

    @Override
    public double calculateArea() {
        double ab = calculateSide(a, b);
        double ac = calculateSide(a, c);
        double bc = calculateSide(b, c);
        double p = (ab + ac + bc) / 2;
        return Math.sqrt(p*(p - ab)*(p-bc)*(p-ac));
    }

    public Point getB() {
        return b;
    }

    @Override
    public boolean contains(Point p) {
        // compare area
        Triangle triangle1 = new Triangle(a, b, p); // new triangles
        Triangle triangle2 = new Triangle(a, p, b); // from the point
        Triangle triangle3 = new Triangle(p, a, b); // if it's inside the triangle
        double pointTrianglesArea = triangle1.calculateArea() + triangle2.calculateArea() + triangle3.calculateArea();
        return pointTrianglesArea == calculateArea();
    }

    public Point getC() {
        return c;
    }

    public Triangle() {
        this(new Point(), new Point(), new Point());
    }

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

}
