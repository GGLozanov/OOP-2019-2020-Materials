package com.lozanov.courier;

import com.lozanov.pizza.Pizza;

public class Courier {
    private String fullName;
    private Pizza pizzaToDeliver; // not mentioned in task, but this class is useless in that case

    public Courier(String fullName, Pizza pizzaToDeliver) throws IllegalArgumentException {
        if(fullName.equals("") || pizzaToDeliver == null) {
            throw new IllegalArgumentException();
        }

        this.fullName = fullName;
        this.pizzaToDeliver = pizzaToDeliver;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String deliverPizzaMessage() {
        return "Courier " + fullName + " is delivering com.lozanov.pizza w/ ingredients " + pizzaToDeliver.getIngredients();
    }

    public void deliverPizza() {
        System.out.println(deliverPizzaMessage()); // TODO: Write in file? Have to start new threads...
    }
}
