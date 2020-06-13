package main.java;

public class Triangle extends Shape {

    double side1 = 0;
    double side2 = 0;
    double side3 = 0;

    public Triangle(Point[] points, Point point, Point point1) {
        super();
    }

    public Triangle(Point[] points) throws Exception {
        super(points);
        side1 = Math.sqrt((Math.abs(points[0].x - points[1].x))*(Math.abs(points[0].x - points[1].x)) + (Math.abs(points[0].y - points[1].y))*(Math.abs(points[0].y - points[1].y)));
        side2 = Math.sqrt((Math.abs(points[1].x - points[2].x))*(Math.abs(points[1].x - points[2].x)) + (Math.abs(points[1].y - points[2].y))*(Math.abs(points[1].y - points[2].y)));
        side3 = Math.sqrt((Math.abs(points[0].x - points[2].x))*(Math.abs(points[0].x - points[2].x)) + (Math.abs(points[0].y - points[2].y))*(Math.abs(points[0].y - points[2].y)));
    }

    @Override
    public double getArea() {
        // Heron formula
        return side1 + side2 + side3;
    }

    @Override
    public double getPerimeter() {
        double halfPerimiter = getArea() / 2;
        return Math.sqrt(halfPerimiter * (halfPerimiter - side1) * (halfPerimiter - side2) * (halfPerimiter - side3));
    }

    @Override
    public double getRadius() {
        return 0;
    }
}
