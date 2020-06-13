package tests.food;

import foods.Food;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FoodTest {
    @Test
    void getFoodScore() {
        Food food = new Food(10, 10) {
            @Override
            public void passWinter() {
                incrementAge();
            }
        };
        assertEquals(food.getFoodScore(), 100);
        food = new Food(20, 10) {
            @Override
            public void passWinter() {
                incrementAge();
            }
        };
        assertEquals(food.getFoodScore(), 200);
        food = new Food(10, 20) {
            @Override
            public void passWinter() {
                incrementAge();
            }
        };
        assertEquals(food.getFoodScore(), 200);
    }
}
