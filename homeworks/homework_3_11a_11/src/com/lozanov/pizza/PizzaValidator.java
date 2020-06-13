package com.lozanov.pizza;

import com.lozanov.enums.IngredientType;
import com.lozanov.ingredient.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class PizzaValidator { // Could've used Collections.frequency here, but I decided to implement it myself
    private Map<IngredientType, Integer> ingredientFrequency = new HashMap<>(){{
        put(IngredientType.DOUGH, 0);
        put(IngredientType.SAUCE, 0);
        put(IngredientType.VEGETABLE, 0);
        put(IngredientType.CHEESE, 0);
        put(IngredientType.MEAT, 0);
    }};

    private Pizza pizza;

    public PizzaValidator(Pizza pizza) {
        this.pizza = pizza;
    }

    public void validateIngredient(Ingredient ingredient) { // test; may have bugs here
        IngredientType ingredientType = ingredient.getIngredientType();

        int ingredientCount = ingredientFrequency.get(ingredientType);
        double ingredientBakingTime = ingredientType.getBakingTime();

        /* com.lozanov.pizza.addBakingTime((long) (ingredientBakingTime +
                        (ingredientCount / 10) * ingredientBakingTime)); */

         pizza.addBakingTime((long) (ingredientCount > 0 ?
                 (ingredientCount / 10) * ingredientBakingTime
                    : ingredientBakingTime));
         // if 0 => just baking time
         // else => 1/10 percent, 2/10 percent from time. . .

        ingredientFrequency.put(ingredientType, ingredientCount + 1);
    }

    public boolean validatePizza() {
        pizza.getIngredients().forEach(this::validateIngredient);

        int sauceCount = ingredientFrequency.get(IngredientType.SAUCE);
        int doughCount = ingredientFrequency.get(IngredientType.DOUGH);
        int cheeseCount = ingredientFrequency.get(IngredientType.CHEESE);

        return doughCount == 1
                && (sauceCount == 1
                    || sauceCount == 2)
                && cheeseCount > 0;
    }
}
