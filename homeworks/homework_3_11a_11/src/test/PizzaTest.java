package test;

import com.lozanov.enums.IngredientType;
import com.lozanov.exceptions.InvalidPizzaException;
import com.lozanov.ingredient.Ingredient;
import com.lozanov.pizza.Pizza;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {
    Pizza pizza;

    Set<Ingredient> pizzaValidIngredients = new HashSet<>(){{
        add(new Ingredient("White dough", IngredientType.DOUGH));
        add(new Ingredient("Ketchup", IngredientType.SAUCE));
        add(new Ingredient("White cheese", IngredientType.CHEESE));
    }};

    Set<Ingredient> pizzaInvalidIngredients = new HashSet<>(){{
        add(new Ingredient("Mayonnaise", IngredientType.SAUCE));
        add(new Ingredient("Ketchup", IngredientType.SAUCE));
        add(new Ingredient("White cheese", IngredientType.CHEESE));
    }};

    @Test
    void assertPizzaCreationCorrect() {
        assertDoesNotThrow(() -> new Pizza(pizzaValidIngredients));
    }

    @Test
    void assertPizzaCreationIncorrect() {
        assertThrows(InvalidPizzaException.class,
                () -> new Pizza(pizzaInvalidIngredients));
    }

    @Test
    void assertPizzaBakingTimeCorrect() throws InvalidPizzaException {
        pizza = new Pizza(pizzaValidIngredients);

        // 1 Dough = 2000 ms
        // 1 Sauce = 1000 ms
        // 1 Cheese = 1000 ms
        // Total: 4000ms

        assertEquals(4000, pizza.getBakingTime());
    }

}