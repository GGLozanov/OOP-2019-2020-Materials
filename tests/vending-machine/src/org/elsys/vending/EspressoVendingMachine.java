package org.elsys.vending;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class EspressoVendingMachine extends AbstractVendingMachine {

    /*
     * Collection of all ingredients supported by the vending machine.
     */
    public EspressoVendingMachine(Collection<String> containers) {
        super(containers);
    }

    /*
     * Returns the current turnover from all the sells after last resupply of the 
     * vending machine.
     */

    @Override
    public void resupplyContainer(String ingredient) {
        Container container = getContainerByIngredient(ingredient);

        for(int i = container.getIngredients().size(); i < container.getCapacity(); i++) {
            container.addIngredient(new Ingredient(ingredient, 5));
        }
    }

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
