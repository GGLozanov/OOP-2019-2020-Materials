package com.lozanov.main;

import com.lozanov.enums.IngredientType;
import com.lozanov.exceptions.InvalidPizzaException;
import com.lozanov.exceptions.NoFurnaceException;
import com.lozanov.exceptions.NoPizzaioloException;
import com.lozanov.furnace.Furnace;
import com.lozanov.ingredient.Ingredient;
import com.lozanov.order.Order;
import com.lozanov.pizza.Pizza;
import com.lozanov.pizzaiolo.Pizzaiolo;
import com.lozanov.pizzeria.Pizzeria;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    public static void main(String[] args) {
        List<Pizzaiolo> pizzaiolos = new ArrayList<>();
        Set<Ingredient> ingredients = new HashSet<>();
        List<Furnace> furnaces = new ArrayList<>();

        List<Order> orders = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String[] lineAttributes = line.split(", "); // account for spaces (handle many w/ regex)

            if(lineAttributes.length == 0) {
                System.out.println("Invalid user input! Must enter something");
                continue;
            }

            switch(lineAttributes[0]) {
                case "HirePizzaMan":
                    assert lineAttributes.length == 4;
                    int yearsExperience;

                    try {
                        yearsExperience = Integer.parseInt(lineAttributes[3]);
                    } catch(NumberFormatException e) {
                        System.out.println("Invalid number format for years of experience! Cancelling creation!");
                        break;
                    }

                    pizzaiolos.add(new Pizzaiolo(lineAttributes[1] + lineAttributes[2], yearsExperience));
                    break;
                case "Stove":
                    assert lineAttributes.length == 2;
                    int capacity;

                    try {
                        capacity = Integer.parseInt(lineAttributes[1]);
                    } catch(NumberFormatException e) {
                        System.out.println("Invalid number format for stove capacity! Cancelling creation!");
                        break;
                    }

                    furnaces.add(new Furnace(capacity));
                    break;
                case "Ingredient":
                    assert lineAttributes.length == 3;
                    IngredientType ingredientType;

                    try {
                        ingredientType = IngredientType.valueOf(lineAttributes[2].toUpperCase());
                    } catch(IllegalArgumentException e) {
                        System.out.println("Invalid com.lozanov.ingredient type! Cancelling creation!");
                        break;
                    }

                    Ingredient ingredient = new Ingredient(lineAttributes[1], ingredientType);

                    // doesn't work with contains() for some reason; probably doesn't use equals()
                    if(ingredients.stream()
                            .anyMatch(ingr -> ingr.equals(ingredient))) {
                        System.out.println("Ingredient already exists! Won't add to ingredient list!");
                    } else {
                        ingredients.add(ingredient);
                    }

                    break;
                case "Order":
                    assert lineAttributes.length > 2;
                    int orderID;

                    try {
                        orderID = Integer.parseInt(lineAttributes[1]);
                    } catch(NumberFormatException e) {
                        System.out.println("Invalid number format for com.lozanov.order ID! Cancelling creation!");
                        break;
                    }

                    Set<Ingredient> pizzaIngredients = new HashSet<>();
                    AtomicBoolean isPizzaInvalid = new AtomicBoolean(false); // for use in lambda (avoid final)

                    try {
                        for(int ingredientIDX = 2; ingredientIDX < lineAttributes.length; ingredientIDX++) {
                            final int finalIngredientIDX = ingredientIDX; // required for current stream iteration
                            ingredients.stream()
                                    .filter(ingr -> lineAttributes[finalIngredientIDX].equals(ingr.getName()))
                                    .findFirst()
                                    .ifPresentOrElse(
                                        pizzaIngredients::add,
                                        () -> isPizzaInvalid.set(true)
                                    );  // adds the com.lozanov.pizza com.lozanov.ingredient if present
                                            // breaks loop otherwise and cancels entering

                            if(isPizzaInvalid.get()) {
                                throw new InvalidPizzaException();
                            }
                        }
                    } catch(InvalidPizzaException e) {
                        System.out.println("Invalid pizza given! No com.lozanov.ingredient found to create " +
                                "pizza with or the same ingredients were given twice!");
                        break;
                    }

                    try {
                        orders.add(new Order(orderID, new Pizza(pizzaIngredients)));
                    } catch(InvalidPizzaException e) {
                        System.out.println("Invalid com.lozanov.pizza given! Cancelling creation of com.lozanov.order!");
                    }

                    break;
                default:
                    System.out.println("Invalid input! Commands are: 'HirePizzaMan', 'Stove', 'Ingredient', and 'Order'");
                    break;
            }

            // no stove error handle -> check
            // no com.lozanov.ingredient error handle -> check
            // invalid com.lozanov.pizza error handle -> check
            // duplicate ingredient error handle -> check
            // invalid input error handle -> check
        }

        Pizzeria pizzeria = new Pizzeria(pizzaiolos, ingredients, furnaces);

        orders.forEach(order -> {
            try {
                String deliveredMessage = pizzeria.receiveOrder(order);
                System.out.println(deliveredMessage);
            } catch(NoPizzaioloException e) {
                System.out.println("No active com.lozanov.pizzaiolo to take current com.lozanov.order!");
            } catch(NoFurnaceException e) {
                System.out.println("No active com.lozanov.furnace to take current com.lozanov.order!");
            }
        });

        try {
            pizzeria.closePizzeria();
        } catch (InterruptedException e) {
            System.out.println("Couldn't close pizzeria! Interrupted by one of the pizzaiolos or furnace queries!");
            e.printStackTrace();
        }

    }
}
