package test;

import com.lozanov.Point;
import com.lozanov.Triangle;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @org.junit.jupiter.api.Test
    void calculateArea() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(0, 5), new Point(5, 0));

    }


    @org.junit.jupiter.api.Test
    void contains() {
    }

}