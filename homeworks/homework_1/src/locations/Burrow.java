package locations;

import foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Burrow {
    private List<Food> foods;

    public Burrow() {
        this(new ArrayList<Food>());
    }

    public Burrow(List<Food> foods) {
        this.foods = foods;
    }

    public double getTotalFoodScore() {
        return foods.stream().mapToDouble(Food::getFoodScore).sum();
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void addFood(Food food) {
        foods.add(food);
    }
}
