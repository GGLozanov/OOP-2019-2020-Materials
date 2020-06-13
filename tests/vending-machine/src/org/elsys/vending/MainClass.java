package org.elsys.vending;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EspressoVendingMachine vendingMachine = null;

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if(line.equals("END")) {
                break;
            }

            String[] vendingMachineAttributes = line.split(",");
            String[] recipeAttributes = line.split(";");

            Recipe recipe = null;

            if(vendingMachineAttributes.length > 0 && vendingMachineAttributes[0].equals(line)) {
                // recipe then (regex for vending failed)
                double recipePrice;

                try {
                    recipePrice = Double.parseDouble(recipeAttributes[1]);
                } catch(Exception e) {
                    e.printStackTrace();
                    break;
                }

                recipe = new Recipe(recipeAttributes[0], recipePrice);

                String[] ingredientAttributes = line.split(", ", 2);
                int ingredientAmount;

                try {
                    ingredientAmount = Integer.parseInt(ingredientAttributes[1]);
                } catch(Exception e) {
                    e.printStackTrace();
                    break;
                }

                recipe.addIngredient(ingredientAttributes[0], ingredientAmount);
            } else if(recipeAttributes.length > 0 && recipeAttributes[0].equals(line)) {
                // vending then (regex for recipe failed)
                vendingMachine = new EspressoVendingMachine(new ArrayList<>(Arrays.asList(vendingMachineAttributes)));
            } else {
                System.out.println("Incorrect formatting!");
            }

            if(recipe != null && vendingMachine != null) { // check if received check
                vendingMachine.brewRecipe(recipe);
            } else {
                System.out.println("No vending machine to brew recipe and/or no recipe to brew it with!");
            }
        }

        if(vendingMachine != null) {
            System.out.println("Total profit: " + vendingMachine.getTurnover());
        }
    }
}
