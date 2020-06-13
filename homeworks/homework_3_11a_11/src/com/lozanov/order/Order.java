package com.lozanov.order;

import com.lozanov.pizza.Pizza;

public class Order {
    private int number; // com.lozanov.order number
    private Pizza pizza; // ordered com.lozanov.pizza

    public Order(int number, Pizza pizza) {
        this.number = number;
        this.pizza = pizza;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}
