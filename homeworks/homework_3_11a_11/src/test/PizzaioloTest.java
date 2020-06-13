package test;

import com.lozanov.enums.IngredientType;
import com.lozanov.enums.PizzaioloType;
import com.lozanov.exceptions.InvalidPizzaException;
import com.lozanov.ingredient.Ingredient;
import com.lozanov.order.Order;
import com.lozanov.pizza.Pizza;
import com.lozanov.pizzaiolo.Pizzaiolo;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PizzaioloTest {
    Pizzaiolo pizzaiolo;
    String pizzaioloName = "Chef Gusteau"; // (Ratatouille reference)
    int yearsExperienceYoung = 1;

    @Test
    void assertPizzaioloisPizzaioloCreationCorrect() {
        pizzaiolo = new Pizzaiolo(pizzaioloName, yearsExperienceYoung);

        assertEquals(PizzaioloType.JUNIOR_PIZZAIOLO, pizzaiolo.getPizzaioloType());
    }

    @Test
    void assertPizzaioloisPizzaioloCreationIncorrect() {
        assertThrows(IllegalArgumentException.class, // pass in expected exception's class reflection (evaluated at runtime)
                () -> new Pizzaiolo(null, -10)); // pass in executable that throws said exception
    }

    @Test
    void assertPizzaioloisPizzaioloRunning() {
        pizzaiolo = new Pizzaiolo(pizzaioloName, yearsExperienceYoung);

        assertFalse(pizzaiolo.isPizzaioloRunning());
    }

    @Test
    void assertPizzaioloGetFormat() throws InvalidPizzaException {
        pizzaiolo = new Pizzaiolo(pizzaioloName, yearsExperienceYoung);

        pizzaiolo.setLastReceievedOrder(
                new Order(
            1,
                    new Pizza(new ArrayList<>(){{
                        add(new Ingredient("White dough", IngredientType.DOUGH));
                        add(new Ingredient("Ketchup", IngredientType.SAUCE));
                        add(new Ingredient("White cheese", IngredientType.CHEESE));
                    }})
                )
        );

        assertEquals(pizzaiolo.getFormat(true),
            "StartTime: " + LocalTime.now().toString() +
                    "; Name: " + pizzaiolo.getFullName() +
                    "; Order ID: " + pizzaiolo.getLastReceievedOrder().getNumber()
        );
    }

}