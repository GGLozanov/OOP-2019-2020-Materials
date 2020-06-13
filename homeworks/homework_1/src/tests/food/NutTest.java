package tests.food;

import foods.Nut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NutTest {
    @Test
    void passWinter() {
        Nut nuts = new Nut(20, 10);
        assertEquals(nuts.getFoodScore(), 200);

        nuts.passWinter();
        assertEquals(nuts.getFoodScore(), 200);
        assertEquals(nuts.getAge(), 1);

        nuts.passWinter();
        assertEquals(nuts.getFoodScore(), 200);
        assertEquals(nuts.getAge(), 2);
    }
}