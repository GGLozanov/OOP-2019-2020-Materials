package test;

import com.lozanov.enums.IngredientType;
import com.lozanov.enums.PizzaioloType;
import com.lozanov.exceptions.InvalidPizzaException;
import com.lozanov.exceptions.NoFurnaceException;
import com.lozanov.exceptions.NoPizzaioloException;
import com.lozanov.furnace.Furnace;
import com.lozanov.ingredient.Ingredient;
import com.lozanov.order.Order;
import com.lozanov.pizza.Pizza;
import com.lozanov.pizzaiolo.Pizzaiolo;
import com.lozanov.pizzeria.Pizzeria;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PizzeriaTest {
    Pizzeria pizzeria;

    Set<Ingredient> pizzeriaIngredients = new HashSet<>(){{ // Use TearDown() and SetUp()
        add(new Ingredient("White dough", IngredientType.DOUGH));
        add(new Ingredient("Ketchup", IngredientType.SAUCE));
        add(new Ingredient("White cheese", IngredientType.CHEESE));
    }};
    List<Pizzaiolo> pizzeriaPizzaiolos = new ArrayList<>(){{
        add(new Pizzaiolo("Senior Pizzaiolo", 12));
        add(new Pizzaiolo("Mid Pizzaiolo", 5));
        add(new Pizzaiolo("Junior Pizzaiolo", 1));
    }};
    List<Furnace> pizzeriaFurnaces= new ArrayList<>(){{
        add(new Furnace(3));
        add(new Furnace(2));
        add(new Furnace(1));
        add(new Furnace(3));
        add(new Furnace(1));
    }};

    @Test
    void assertPizzeriaCreationCorrect() {
        assertDoesNotThrow(() -> new Pizzeria(pizzeriaPizzaiolos, pizzeriaIngredients, pizzeriaFurnaces));
    }

    @Test
    void assertPizzeriaCreationIncorrect() {
        assertThrows(IllegalArgumentException.class,
                () -> new Pizzeria(null, null, null));
    }

    @Test
    void assertReceiveOrderCorrect() throws InvalidPizzaException, NoFurnaceException, NoPizzaioloException, InterruptedException {
        pizzeria = new Pizzeria(pizzeriaPizzaiolos, pizzeriaIngredients, pizzeriaFurnaces);

        assertDoesNotThrow(() -> pizzeria.receiveOrder(new Order(1, new Pizza(pizzeriaIngredients))));

        pizzeria.closePizzeria(); // can't use AfterEach because not every method uses the pizzeria object (!)
    }

    @Test
    void assertReceiveOrderNoPizzaiolo() throws InterruptedException {
        pizzeria = new Pizzeria(new ArrayList<>(), pizzeriaIngredients, pizzeriaFurnaces); // no pizzaiolos

        assertThrows(NoPizzaioloException.class,
                () -> pizzeria.receiveOrder(new Order(1, new Pizza(pizzeriaIngredients))));

        pizzeria.closePizzeria();
    }

    @Test
    void assertReceiveOrderNoFurnace() throws InterruptedException {
        pizzeria = new Pizzeria(pizzeriaPizzaiolos, pizzeriaIngredients, new ArrayList<>());

        assertThrows(NoFurnaceException.class,
                () -> pizzeria.receiveOrder(new Order(1, new Pizza(pizzeriaIngredients))));

        pizzeria.closePizzeria();
    }
}