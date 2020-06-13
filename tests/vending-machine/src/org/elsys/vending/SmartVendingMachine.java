package org.elsys.vending;

import java.util.Collection;
import java.util.Map;

public class SmartVendingMachine extends EspressoVendingMachine {

    boolean wasSupportCalled = false;

    public SmartVendingMachine(Collection<String> containers) {
        super(containers);
    }

    @Override
    public void brewRecipe(Recipe recipe) {
        Map<String, Integer> recipeIngredients = recipe.getIngredients();

        for(String key : recipeIngredients.keySet()) {
            Container container = getContainerByIngredient(key);
            if(container.getRemainingCapacity() < (container.getCapacity() * 20/100) && !wasSupportCalled) {
                wasSupportCalled = true;
                notifySupport();
            }
            container.useIngredient();
        }

        money += recipe.getPrice();
    }

    /**
	 * Do not change this method.
	 */
    public void notifySupport() {
        System.out.println("Support notified!!!");
    }

}
