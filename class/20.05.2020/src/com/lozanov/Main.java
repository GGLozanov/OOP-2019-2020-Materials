package com.lozanov;

import animals.Animal;
import cells.Cell;
import enums.EatingTypes;
import zoo.Zoo;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();

        while (scanner.hasNext()) {
            Animal animal;

            String line = scanner.nextLine();

            if(line.equals("END")) {
                break;
            }

            String[] delimLine = line.split(",");

            switch(delimLine.length) {
                case 3:
                    String id;
                    break;
                case 5:
                    String name = delimLine[0];
                    String species = delimLine[1];
                    EatingTypes eatingType;

                    try {
                        eatingType = EatingTypes.valueOf(delimLine[2]);
                    } catch(Exception e) {
                        System.out.println("Invalid eating type input!");
                        break;
                    }

                    boolean hasPool;
                    try {
                        int hasPoolValue = Integer.parseInt(delimLine[3]);
                        hasPool = hasPoolValue == 1;
                    } catch(Exception e) {
                        System.out.println("Invalid integer input or hasPool isn't between 1 and 0!");
                        break;
                    }

                    animal = new Animal(name, species, eatingType, hasPool);
                    System.out.println(zoo.hasAnimal(animal) ? "Animal in zoo" : "Animal not in zoo");
                    zoo.possbileCellsFor(animal);
                    Optional<Cell> firstCell = zoo.getCells().stream()
                        .filter(cell -> cell.canAddAnimal(animal))
                        .findFirst();
                    break;
                default:
                    System.out.println("Invalid input! Please enter a correct amount of args!");
                    break;
            }
        }
    }
}
