package com.lozanov.ingredient;

import com.lozanov.enums.IngredientType;

public class Ingredient {
    private String name;
    private IngredientType ingredientType;

    public Ingredient(String name, IngredientType ingredientType) throws IllegalArgumentException {
        if(name.equals("") || ingredientType == null) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.ingredientType = ingredientType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IngredientType getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }
}
