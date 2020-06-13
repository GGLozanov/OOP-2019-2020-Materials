package main.test;

import main.java.Point;
import org.junit.jupiter.api.Test;
import main.java.Triangle;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    Triangle triangle;

    @Test
    void getArea() {
        try {
            triangle = new Triangle(new Point[]{new Point(1, 2), new Point(1, 2), new Point(1, 2)});
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(1, triangle.getArea());
    }

    @Test
    void getPerimeter() {
        try {
            triangle = new Triangle(new Point[]{new Point(1, 2), new Point(1, 2), new Point(1, 2)});
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(2, triangle.getPerimeter());
    }

    @Test
    void getRadius() {

    }
}