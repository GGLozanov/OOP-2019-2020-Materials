package org.elsys.vending;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class FlexibleVendingMachine extends AbstractVendingMachine {
    public FlexibleVendingMachine(Collection<String> containerNames) {
        super(containerNames);
    }

    public FlexibleVendingMachine(Map<String, Integer> containers) {
        // names-to-capacity
        super(containers);
    }


    @Override
    public void resupplyContainer(String ingredient) {
        Container container = getContainerByIngredient(ingredient);

        for(int i = container.getIngredients().size(); i < container.getCapacity(); i++) {
            container.addIngredient(new Ingredient(ingredient, 5));
        }
    }

    // THIS IS NOT A GOOD WAY TO DO IT BUT TEACHER SAID I HAD TO HAVE IMPLEMENTATION! NEVER DUPLICATE IMPLEMENTATIONS, IT'S AN OOP SIN
    @Override
    public void resupply() {
        containers.clear();
        money = 0;
        for(String c : containerNames) {
            resupplyContainer(c);
        }
    }

    @Override
    public void brewRecipe(Recipe recipe) {
        Map<String, Integer> recipeIngredients = recipe.getIngredients();

        for(String key : recipeIngredients.keySet()) {
            Container container = getContainerByIngredient(key);
            if(container.getRemainingCapacity() < recipeIngredients.get(key)) {
                throw new RuntimeException();
            }
            container.useIngredient();
        }

        recipes.add(recipe);

        money += recipe.getPrice();
    }
}
