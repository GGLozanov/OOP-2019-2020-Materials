package com.lozanov.enums;

public enum IngredientType {
    DOUGH(2000),
    SAUCE(1000),
    VEGETABLE(500),
    CHEESE(1000),
    MEAT(1500);

    IngredientType(long bakingTime) {
        this.bakingTime = bakingTime;
    }

    private long bakingTime; // the time required to be ready in the oven

    public long getBakingTime() {
        return bakingTime;
    }

    public void setBakingTime(long bakingTime) {
        this.bakingTime = bakingTime;
    }
}
