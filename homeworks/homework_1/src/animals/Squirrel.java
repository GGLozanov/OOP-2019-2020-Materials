package animals;

import foods.Food;
import locations.Burrow;

public class Squirrel {
    private String type;
    private String name;
    private int age;
    private Burrow burrow;
    private static final int allowedFoodExcursions = 4;
    private int currentFoodExcursions = 1;

    public Squirrel() {
        this("DefaultType", "DefaultName", 5);
    }

    public Squirrel(String type, String name, int age) {
        this.type = type;
        this.name = name;
        this.age = age;
        this.burrow = new Burrow();
    }

    @Override
    public String toString() {
        return "<" + type + ">" + " " + name + "(" + age + ")";
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Burrow getBurrow() {
        return burrow;
    }

    public void addFood(Food food) throws Exception {
        if(++currentFoodExcursions == allowedFoodExcursions) {
            throw new Exception();
        }
        burrow.addFood(food);
    }

    public void passWinter() {
        burrow.getFoods().forEach(Food::passWinter);
        age++;
        currentFoodExcursions = 1;
    }
}
