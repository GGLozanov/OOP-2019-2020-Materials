package org.elsys.vending;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private String name;
    private int capacity;
    private List<Ingredient> ingredients;

    public Container(String name, List<Ingredient> ingredients, int capacity) {
        this.name = name;
        if(ingredients.size() > capacity) {
            throw new RuntimeException();
        }
        this.ingredients = ingredients;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public int getRemainingCapacity() {
        return capacity - ingredients.size();
    }

    public void useIngredient() {
        ingredients.remove(ingredients.size() - 1);
    }


}
