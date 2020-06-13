package main.java;

public class Rectangle extends Shape {

    public Rectangle() {
        super();
    }

    public Rectangle(Point[] points) {
        super(points);
    }

    @Override
    public double getArea() {
       return (points[1].x - points[0].x) * (points[1].y - points[0].y);
    }

    @Override
    public double getPerimeter() {
        return (points[1].x - points[0].x) * 2 + (points[1].y - points[0].y) * 2;
    }

    @Override
    public double getRadius() {
        return 0;
    }

}
