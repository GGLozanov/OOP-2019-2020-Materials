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
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Pizzeria {
    private Set<Ingredient> ingredients; // available ingredients (runnale)
    private List<Furnace> furnaces; // available furnaces
    private List<Pizzaiolo> pizzaiolos; // the com.lozanov.pizza chefs (runnable)

    private ExecutorService pizzaioloExecutor = Executors.newCachedThreadPool();

    public Pizzeria(List<Pizzaiolo> pizzaiolos, Set<Ingredient> ingredients, List<Furnace> furnaces) throws IllegalArgumentException {
        if(pizzaiolos == null || ingredients == null || furnaces == null) {
            throw new IllegalArgumentException();
        }

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

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Furnace> getFurnaces() {
        return furnaces;
    }

    public void setFurnaces(List<Furnace> furnaces) {
        this.furnaces = furnaces;
    }

    public void receiveOrder(Order order) throws NoPizzaioloException, NoFurnaceException, ExecutionException, InterruptedException {
        // returns a successful delivery message by courier upon delivered pizza; else null

        // find first free com.lozanov.pizzaiolo to create com.lozanov.pizza
        // and assign him to handle the com.lozanov.order

        int orderNumber = order.getNumber();
        Pizza orderedPizza = order.getPizza();

        Pizzaiolo pizzaiolo = pizzaiolos.stream()
                .filter(pz -> !pz.isPizzaioloRunning()) // find first runnable that's not running
                .findFirst()
                .orElseThrow(NoPizzaioloException::new); // get first free pizzaiolo
        // bonus: (make thread wait if there are no free pizzaiolos)

        pizzaiolo.setLastReceievedOrder(order); // set order with which to work with for the pizzaiolo

        Furnace furnace = furnaces.stream()
                .filter(fs -> !fs.isFull())
                .findFirst()
                .orElseThrow(NoFurnaceException::new); // find first available furnace to bake new pizza in
        // bonus: (make thread wait if there are no free furnaces)

        FurnaceWork furnaceWork = new FurnaceWork(
                furnaces.indexOf(furnace), // com.lozanov.furnace ID is the position of it in the array
                orderNumber, // com.lozanov.order ID/number
                orderedPizza // com.lozanov.order com.lozanov.pizza
        ); // create new furnace work query for given pizza (it will wait until the pizza is done b pizzaiolo)

        // execute pizzaiolo thread using a submit to the executor
        pizzaioloExecutor.submit(pizzaiolo).get(); // start the pizzaiolo pizza preparing thread

        // execute furnacework thread
        furnace.addFurnaceWorkQuery(furnaceWork); // starts the furnacework thread (waits until the pizzaiolo thread finishes)

        //-----/RANT/------

        // Rant/Explanation for using the async API in pizzaioloExecutor:
        // due to encountered difficulties using wait()/notify()
        // for starting furnacework threads after pizzaiolo threads have finished, I have opted to use the async API
        // Using the async API, we wait until the result of the Callable
        // (that's the Runnable and its run() method in our case; probably because it's not implemented)
        // finishes so that we can collect the 'result' (that doesn't exist because run() returns void, I presume)
        // and simulate wait/notify using the async API w/ get() to await the result

        // also, when you get() a future and it's equal to null and hasn't thrown an exception,
        // that means the run() method has ended successfully

        // so that's another useful tip for using Java with async
        // this here is really just multithreading, since there isn't any real result collected
        // by the main thread and it's just being notified for the sake of starting all other relevant threads
        // (i.e. furnacework)

        //-----/RANT/------
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
        pizzaioloExecutor.shutdown(); // end executor service and disallow receiving of new tasks
        while(!pizzaioloExecutor.awaitTermination(24L, TimeUnit.HOURS)) {} // wait all threads in executor to finish (simulating join)
    }
}
