package com.lozanov.pizza;

import com.lozanov.exceptions.InvalidPizzaException;
import com.lozanov.ingredient.Ingredient;

import java.util.List;

public class Pizza {
    private List<Ingredient> ingredients;
    private long bakingTime = 0;

    public Pizza(List<Ingredient> ingredients) throws InvalidPizzaException {
        this.ingredients = ingredients;

        if(!new PizzaValidator(this).validatePizza()) {
            this.ingredients = null;
            this.bakingTime = 0;
            throw new InvalidPizzaException("Invalid com.lozanov.pizza received! Need at least one dough, one sauce, and one cheese!");
        }

    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public long getBakingTime() {
        return bakingTime;
    }

    public void addBakingTime(long time) {
        bakingTime += time;
    }

    public void bakePizza() throws InterruptedException {
        Thread.sleep(bakingTime); // bake com.lozanov.pizza with bake time
    }

    @Override
    public String toString() {
        return "Pizza" +
                ingredients.toString();
    }
}
