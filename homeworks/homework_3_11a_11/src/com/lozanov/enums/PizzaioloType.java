package com.lozanov.enums;

public enum PizzaioloType {
    JUNIOR_PIZZAIOLO(1000),
    MASTER_PIZZAIOLO(500),
    SENIOR_MASTER_PIZZAIOLO(300);

    private long ingredientParseTime;
        // time to parse in all the ingredients for a com.lozanov.pizza (depends on years of experience for the given Pizzaiolo)

    PizzaioloType(long ingredientParseTime) {
        this.ingredientParseTime = ingredientParseTime;
    }

    public long getIngredientParseTime() {
        return ingredientParseTime;
    }
}
