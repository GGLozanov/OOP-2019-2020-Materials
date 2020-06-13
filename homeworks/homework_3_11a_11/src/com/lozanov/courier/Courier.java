package com.lozanov.courier;

import com.lozanov.pizza.Pizza;

public class Courier {
    private String fullName;
    private Pizza pizzaToDeliver; // not mentioned in task, but this class is useless in that case

    public Courier(String fullName, Pizza pizzaToDeliver) {
        this.fullName = fullName;
        this.pizzaToDeliver = pizzaToDeliver;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void deliverPizza() {
        System.out.println("Courier " + fullName + " is delivering com.lozanov.pizza w/ ingredients " + pizzaToDeliver.getIngredients());
    }
}
