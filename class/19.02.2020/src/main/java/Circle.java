package main.java;

public class Circle extends Shape {
    public Circle() {
        super();
    }

    double r;

    public Circle(Point[] points) throws Exception {
        super(points);
        if(points.length < 2) throw new Exception();
        r = points[1].x * points[1].x;
    }

    @Override
    public double getArea() {
        // 2 * p * r
        return 2 * Math.PI * r;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * r * r;
    }

    @Override
    public double getRadius() {
        return 0;
    }
}
