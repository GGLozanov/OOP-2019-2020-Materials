package main.test;

import main.java.Rectangle;
import main.java.Point;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    Rectangle rectangle;

    // BeforeEach and AfterEach - before and after every test
    // BeforeClass and AfterClass - before and after the class' existence

    @org.junit.jupiter.api.Test
    void getArea() {
        rectangle = new Rectangle(new Point[]{new Point(1, 1), new Point(1, 1)});
        assertEquals(0, rectangle.getArea());
    }

    @org.junit.jupiter.api.Test
    void getPerimeter() {
        rectangle = new Rectangle(new Point[]{new Point(1, 1), new Point(1, 1)});
        assertEquals(0, rectangle.getPerimeter());
    }

    @org.junit.jupiter.api.Test
    void getRadius() {
    }
}