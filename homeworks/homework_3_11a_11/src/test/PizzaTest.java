package test;

import com.lozanov.enums.IngredientType;
import com.lozanov.exceptions.InvalidPizzaException;
import com.lozanov.ingredient.Ingredient;
import com.lozanov.pizza.Pizza;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {
    Pizza pizza;

    List<Ingredient> pizzaValidIngredients = new ArrayList<>(){{
        add(new Ingredient("White dough", IngredientType.DOUGH));
        add(new Ingredient("Ketchup", IngredientType.SAUCE));
        add(new Ingredient("White cheese", IngredientType.CHEESE));
    }};

    List<Ingredient> pizzaInvalidIngredients = new ArrayList<>(){{
        add(new Ingredient("White dough", IngredientType.SAUCE));
        add(new Ingredient("Ketchup", IngredientType.SAUCE));
        add(new Ingredient("White cheese", IngredientType.CHEESE));
    }};

    @Test
    void assertPizzaCreationCorrect() throws InvalidPizzaException {
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