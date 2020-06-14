package com.lozanov.furnace;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Furnace {
    private int capacity; // max amount of pizzas that can be produced by this com.lozanov.furnace
    private ExecutorService furnaceWorkExecutor; // executor service containing the thread pool for the furnacework threads

    public Furnace(int capacity) throws IllegalArgumentException {
        if(capacity < 0) {
            throw new IllegalArgumentException();
        }

        this.capacity = capacity;
        this.furnaceWorkExecutor = Executors.newFixedThreadPool(capacity);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ExecutorService getFurnaceWorkQueries() {
        return furnaceWorkExecutor;
    }

    public void setFurnaceWorkQueries(ExecutorService furnaceWorkExecutor) {
        this.furnaceWorkExecutor = furnaceWorkExecutor;
    }

    public void addFurnaceWorkQuery(FurnaceWork furnaceWork) { // adds a new queried com.lozanov.pizza to run through the limited thread pool executor
        furnaceWorkExecutor.execute(furnaceWork);
    }

    public void endFurnaceWorkQueries() throws InterruptedException { // removes all the pizzaquery runnables and shuts down the com.lozanov.furnace (exec. service)
        furnaceWorkExecutor.shutdown(); // shut down furnace work executor (recieves no more threads)
        while(!furnaceWorkExecutor.awaitTermination(24L, TimeUnit.HOURS)) {} // wait all threads in executor to finish (simulating join)
    }

    public boolean isFull() {
        return capacity == ((ThreadPoolExecutor) furnaceWorkExecutor).getActiveCount();
            // compare capacity to the current size
            // (access method by casting to parent class)
    }
}
