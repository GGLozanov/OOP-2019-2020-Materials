package com.lozanov;

import animals.Squirrel;
import foods.Cake;
import foods.Food;
import foods.McBurger;
import foods.Nut;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Squirrel> squirrels = new ArrayList<>();

        String unparsedInput;
        int index = 0;

        boolean isFoodNotInputted = true;

        while(scanner.hasNext()) {
            // Squirrel input
            unparsedInput = scanner.nextLine();
            if(!unparsedInput.contentEquals("stop")) {
                int age = 0;
                String[] input = unparsedInput.split(isFoodNotInputted ? "," : " ", 3);
                if(isFoodNotInputted) {
                    try {
                        age = Integer.parseInt(input[1]);
                    } catch(NumberFormatException e) { System.out.println("Invalid arg input!"); }
                    squirrels.add(new Squirrel(input[2], input[0], age));
                } else {
                    // Food input
                    double amount = 0;
                    double quality = 0;
                    try {
                        amount = Double.parseDouble(input[1]);
                        quality = Double.parseDouble(input[2]);
                    } catch(NumberFormatException e) { System.out.println("Invalid arg input!"); }
                    Food food;
                    switch (input[0]) { // type
                        case "Nut":
                            food = new Nut(amount, quality);
                            break;
                        case "Cake":
                            food = new Cake(amount, quality);
                            break;
                        case "McBurger":
                            food = new McBurger(amount, quality);
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + input[0] + ". Available values: Nut, Cake, McBurger");
                    }
                    try {
                        squirrels.get(index).addFood(food);
                    } catch (Exception e) {
                        if(index > squirrels.size()) {
                            squirrels.forEach(Squirrel::passWinter);
                            break;
                        } else index++; // exception => no more room; move on to the next squirrel
                    }
                }
            } else {
                if(!isFoodNotInputted) break;
                isFoodNotInputted = false;
            }
        }

        squirrels.forEach(System.out::println);
	// write your code here
    }
}
