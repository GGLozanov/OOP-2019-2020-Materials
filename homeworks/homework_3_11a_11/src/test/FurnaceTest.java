package test;

import com.lozanov.enums.IngredientType;
import com.lozanov.exceptions.InvalidPizzaException;
import com.lozanov.furnace.Furnace;
import com.lozanov.furnace.FurnaceWork;
import com.lozanov.ingredient.Ingredient;
import com.lozanov.pizza.Pizza;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class FurnaceTest {
    Furnace furnace;

    @Test
    void assertFurnaceCreationCorrect() {
        assertDoesNotThrow(() -> new Furnace(2));
    }

    @Test
    void assertFurnaceCreationIncorrect() {
        assertThrows(IllegalArgumentException.class,
                () -> new Furnace(-2));
    }

    @Test
    void assertFurnaceIsFullFalse() {
        assertFalse(new Furnace(2).isFull());
    }

    @Test
    void assertFurnaceIsFullTrue() throws InvalidPizzaException, InterruptedException {
        furnace = new Furnace(1);

        furnace.addFurnaceWorkQuery(
            new FurnaceWork(
                    1,
                    1,
                    new Pizza(new HashSet<>(){{
                        add(new Ingredient("White dough", IngredientType.DOUGH));
                        add(new Ingredient("Ketchup", IngredientType.SAUCE));
                        add(new Ingredient("White cheese", IngredientType.CHEESE));
                    }}
                )
            )
        );

        assertTrue(furnace.isFull()); // assert here

        furnace.endFurnaceWorkQueries(); // wait for file writing to finish (wait for all threads here)
    }
}