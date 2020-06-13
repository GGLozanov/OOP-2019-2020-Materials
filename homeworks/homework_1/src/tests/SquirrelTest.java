package tests;

import animals.Squirrel;
import foods.Cake;
import foods.Nut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SquirrelTest {
    private Squirrel squirrel;
    @BeforeEach
    void setUp() {
        squirrel = new Squirrel("Test", "Species", 5);
    }

    @Test
    void passWinter() throws Exception {
        squirrel.addFood(new Nut(10, 10));
        squirrel.addFood(new Cake(10, 10));
        assertEquals(squirrel.getBurrow().getTotalFoodScore(), 200);

        squirrel.passWinter();
        assertEquals(squirrel.getBurrow().getTotalFoodScore(), 168.63, 0.01);
        assertEquals(squirrel.getAge(), 6);

        squirrel.passWinter();
        assertEquals(squirrel.getBurrow().getTotalFoodScore(), 123.51, 0.01);
        assertEquals(squirrel.getAge(), 7);
    }

    @Test
    void addFood() {
        try {
             squirrel.addFood(new Nut(10, 10));
             assertEquals(squirrel.getBurrow().getTotalFoodScore(), 100);
             squirrel.addFood(new Nut(10, 10));
             assertEquals(squirrel.getBurrow().getTotalFoodScore(), 200);
             squirrel.addFood(new Nut(10, 10));
         } catch (Exception e) {
             assertEquals(squirrel.getBurrow().getTotalFoodScore(), 200);
         }
    }
}
