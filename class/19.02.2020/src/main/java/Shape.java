package main.java;

public abstract class
Shape {
    protected Point[] points;

    public Shape() {
    }

    public Shape(Point[] points) {
        this.points = points;
    }

    abstract double getArea();
    abstract double getPerimeter();
    abstract double getRadius();
}
