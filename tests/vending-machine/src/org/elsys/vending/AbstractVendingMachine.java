package org.elsys.vending;

import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractVendingMachine {
    protected Collection<String> containerNames;
    protected Collection<Container> containers;
    protected List<Recipe> recipes = new ArrayList<>();
    protected double money = 0;

    public AbstractVendingMachine(Collection<String> containerNames) {
        this.containerNames = containerNames;
        this.containers = containerNames.stream().map(str -> new Container(str,  new ArrayList<>(), 5)).collect(Collectors.toList());
    }

    public AbstractVendingMachine(Map<String, Integer> containerNamesAndAmounts) {
        this.containers = new ArrayList<>();
        for(String name : containerNamesAndAmounts.keySet()) {
            containers.add(new Container(name, new ArrayList<>(), containerNamesAndAmounts.get(name)));
        }
    }

    public Container getContainerByIngredient(String ingredient) {
        return containers.stream().filter(val -> val.getName().equals(ingredient)).findFirst().orElseThrow(RuntimeException::new);
    }

    public double getTurnover() {
        return money;
    }

    public boolean hasEnoughIngredientSupply(String ingredient, int amount) {
        Container container = getContainerByIngredient(ingredient);

        return container.getIngredients().size() >= amount;
    }

    public Collection<String> getIngredientContainers() {
        return containerNames;
    }

    public int getIngredientContainerCapacity(String ingredient) {
        Container container = getContainerByIngredient(ingredient);

        return container.getCapacity();
    }

    public int getIngredientSupply(String ingredient) {
        Container container = getContainerByIngredient(ingredient);

        return container.getRemainingCapacity();
    }

    public void useIngredient(String ingredient, int amount) {
        Container container = getContainerByIngredient(ingredient);

        if(container.getRemainingCapacity() < amount) {
            throw new RuntimeException();
        }

        container.useIngredient();
    }

    public Recipe getRecipeByName(String recipeName) throws Exception {
        Optional<Recipe> recipe = recipes.stream().filter(r -> r.getName().equals(recipeName)).findFirst();

        if(recipe.isPresent()) {
            return recipe.get();
        }

        throw new Exception();
    }

    public List<Recipe> getRecipiesByIngredient(String ingredient) {
        return recipes.stream().filter(r -> r.getName().equals(ingredient)).collect(Collectors.toList());
        // name is the same as ingredients the recipe holds
    }


    public abstract void resupplyContainer(String ingredient);

    public abstract void resupply();

    public abstract void brewRecipe(Recipe recipe);
}
