package org.elsys.vending;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Recipe {

    private String name; // name of the recipe (ingredient)
    private double price;
    private List<Ingredient> ingredients = new ArrayList<>();

    public Recipe(String name, double price) {
        if(price < 0) {
            throw new RuntimeException();
        }
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
    	return price;
    }
    
    public String getName() {
    	return name;
    }

    /*
     * Should add an ingredient into the recipe. If given ingredient is added
     * twice a RuntimeException should be thrown.
     */
    public void addIngredient(String name, int amount) {
        Ingredient ingredient = new Ingredient(name, amount);
        if(ingredients.contains(ingredient)) {
            throw new RuntimeException();
        }

        ingredients.add(ingredient);
    }

    /*
     * Should return a copy of the ingredients in the recipe.
     */
    public Map<String, Integer> getIngredients() {
        return ingredients.stream().collect(Collectors.toMap(Ingredient::getName, Ingredient::getAmount));
    }

}
