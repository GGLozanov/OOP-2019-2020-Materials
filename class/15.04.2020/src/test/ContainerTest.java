package test;

import com.lozanov.Container;
import com.lozanov.Triangle;
import org.junit.jupiter.api.Test;
import com.lozanov.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    @Test
    void add() {
        Triangle triangle = new Triangle();
        List<Triangle> list = new ArrayList<>();
        list.add(triangle);

        Container<Triangle> container = new Container<>(list);
        assertEquals(triangle, container.get(0));
    }

    @Test
    void get() {
    }

    @Test
    void getAllByArea() {
    }

    @Test
    void getTotalArea() {
    }

    @Test
    void getAllContaining() {
    }

    @Test
    void getBiggest() {
    }

    @Test
    void getSmallest() {
    }

    @Test
    void orderDescending() {
    }
}