package com.lozanov.pizzeria;

import com.lozanov.courier.Courier;
import com.lozanov.exceptions.NoFurnaceException;
import com.lozanov.exceptions.NoPizzaioloException;
import com.lozanov.furnace.Furnace;
import com.lozanov.furnace.FurnaceWork;
import com.lozanov.ingredient.Ingredient;
import com.lozanov.order.Order;
import com.lozanov.pizza.Pizza;
import com.lozanov.pizzaiolo.Pizzaiolo;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Pizzeria {
    private List<Ingredient> ingredients; // available ingredients (runnale)

    private List<Furnace> furnaces; // available furnaces

    private List<Pizzaiolo> pizzaiolos; // the com.lozanov.pizza chefs (runnable)
    private ExecutorService pizzaioloExecutor = Executors.newCachedThreadPool();

    public Pizzeria(List<Pizzaiolo> pizzaiolos, List<Ingredient> ingredients, List<Furnace> furnaces) {
        this.pizzaiolos = pizzaiolos;
        this.ingredients = ingredients;
        this.furnaces = furnaces;
    }

    public List<Pizzaiolo> getPizzaiolos() {
        return pizzaiolos;
    }

    public void setPizzaiolos(List<Pizzaiolo> pizzaiolos) {
        this.pizzaiolos = pizzaiolos;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Furnace> getFurnaces() {
        return furnaces;
    }

    public void setFurnaces(List<Furnace> furnaces) {
        this.furnaces = furnaces;
    }

    public void receiveOrder(Order order) throws NoPizzaioloException, NoFurnaceException {
        // find first free com.lozanov.pizzaiolo to create com.lozanov.pizza
        // and assign him to handle the com.lozanov.order

        int orderNumber = order.getNumber();
        Pizza orderedPizza = order.getPizza();

        Pizzaiolo pizzaiolo = pizzaiolos.stream()
                .filter(pz -> !pz.isPizzaioloRunning()) // find first runnable that's not running
                .findFirst()
                .orElseThrow(NoPizzaioloException::new);

        pizzaiolo.setLastReceievedOrder(order); // set order with which to work with
        pizzaioloExecutor.execute(pizzaiolo);

        Furnace furnace = furnaces.stream()
                .filter(fs -> !fs.isFull())
                .findFirst()
                .orElseThrow(NoFurnaceException::new);

        furnace.addFurnaceWorkQuery(
            new FurnaceWork(
                furnaces.indexOf(furnace), // com.lozanov.furnace ID is the position of it in the array
                orderNumber, // com.lozanov.order ID/number
                orderedPizza // com.lozanov.order com.lozanov.pizza
            )
        );

        // find first free com.lozanov.furnace
        // and put the com.lozanov.pizza there (by creating new thread?)

        // after com.lozanov.pizza is ready, create new com.lozanov.courier and execute deliverPizza() method
        new Courier(orderedPizza.toString() + " Deliverer", orderedPizza).deliverPizza();
            // deliver the com.lozanov.pizza requested
    }

    public void closePizzeria() throws InterruptedException {
        // for each com.lozanov.furnace: endPizzaQuery
        // for each Pizzaiolo: join
        // wait for the threads to finish their execution
        furnaces.forEach(furnace -> {
            try {
                furnace.endFurnaceWorkQueries();
            } catch (InterruptedException e) {
                System.out.println("Couldn't shut down furnace work queries!");
                e.printStackTrace();
            }
        }); // wait for furnace threads to finish (all pizza baking queries)

        layOffPizzaiolos(); // wait for pizzaiolo threads to finish
    }

    public void layOffPizzaiolos() throws InterruptedException {
        pizzaiolos.clear(); // clear pizzaiolo runnables
        pizzaioloExecutor.shutdown(); // end executor service and disallow receing of new tasks
        while(!pizzaioloExecutor.awaitTermination(24L, TimeUnit.HOURS)) {} // wait all threads in executor to finish (simulating join)
    }
}
