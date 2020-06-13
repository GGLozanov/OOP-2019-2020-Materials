package main.test;

import main.java.Point;
import org.junit.jupiter.api.Test;
import main.java.Circle;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    Circle circle;

    @Test
    void getArea() {
        try {
            circle = new Circle(new Point[]{new Point(1, 1), new Point(1, 1), new Point(1, 1)});
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(1, circle.getArea());
    }

    @Test
    void getPerimeter() {
        try {
            circle = new Circle(new Point[]{new Point(1, 1), new Point(1, 1), new Point(1, 1)});
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(2, circle.getPerimeter());
    }

    @Test
    void getRadius() {
        try {
            circle = new Circle(new Point[]{new Point(1, 1), new Point(1, 1)});
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(6.28, circle.getRadius());
    }
}