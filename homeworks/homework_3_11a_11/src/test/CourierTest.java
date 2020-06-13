package test;

import com.lozanov.courier.Courier;
import com.lozanov.enums.IngredientType;
import com.lozanov.exceptions.InvalidPizzaException;
import com.lozanov.furnace.Furnace;
import com.lozanov.ingredient.Ingredient;
import com.lozanov.pizza.Pizza;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    @Test
    void assertCourierCreationCorrect() {
        assertDoesNotThrow(() -> new Courier(
                "Courier McCoury",
                new Pizza(new HashSet<>(){{
                    add(new Ingredient("White dough", IngredientType.DOUGH));
                    add(new Ingredient("Ketchup", IngredientType.SAUCE));
                    add(new Ingredient("White cheese", IngredientType.CHEESE));
                }}))
        );
    }

    @Test
    void assertCourierCreationIncorrect() {
        assertThrows(IllegalArgumentException.class,
                () -> new Courier("Courier McCoury's Idiot Brother", null));
    }

    @Test
    void assertDeliverPizzaCorrect() throws InvalidPizzaException {
        Set<Ingredient> pizzaIngredients = new HashSet<>(){{
            add(new Ingredient("White dough", IngredientType.DOUGH));
            add(new Ingredient("Ketchup", IngredientType.SAUCE));
            add(new Ingredient("White cheese", IngredientType.CHEESE));
        }};

        assertEquals("Courier Courier McCoury is delivering com.lozanov.pizza w/ ingredients " + pizzaIngredients.toString(),
                new Courier(
                    "Courier McCoury",
                new Pizza(pizzaIngredients)
            ).deliverPizzaMessage()
        );
    }
}