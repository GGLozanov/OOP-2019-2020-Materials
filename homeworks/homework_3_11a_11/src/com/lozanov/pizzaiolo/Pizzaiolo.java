package com.lozanov.pizzaiolo;

import com.lozanov.enums.PizzaioloType;
import com.lozanov.interfaces.ThreadStatusFormatter;
import com.lozanov.order.Order;

import java.io.*;
import java.time.LocalTime;

public class Pizzaiolo implements Runnable, ThreadStatusFormatter {
    private String fullName;
    private int yearsExperience;
    private PizzaioloType pizzaioloType; // depends on the years of experience

    private Order lastReceievedOrder; // latest com.lozanov.order received by the com.lozanov.pizzaiolo

    private volatile boolean isPizzaioloRunning = false;
        // volatile as to keep state across threads and be read directly from main memory
        // determines whether the com.lozanov.pizzaiolo runnable is running

    public Pizzaiolo(String fullName, int yearsExperience) throws IllegalArgumentException {
        if(fullName == null || yearsExperience < 0) {
            throw new IllegalArgumentException();
        }

        this.fullName = fullName;
        this.yearsExperience = yearsExperience;

        if(yearsExperience >= 9) {
            this.pizzaioloType = PizzaioloType.SENIOR_MASTER_PIZZAIOLO;
        } else if(yearsExperience >= 4) {
            this.pizzaioloType = PizzaioloType.MASTER_PIZZAIOLO;
        } else {
            this.pizzaioloType = PizzaioloType.JUNIOR_PIZZAIOLO;
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public PizzaioloType getPizzaioloType() {
        return pizzaioloType;
    }

    public void setPizzaioloType(PizzaioloType pizzaioloType) {
        this.pizzaioloType = pizzaioloType;
    }

    public Order getLastReceievedOrder() {
        return lastReceievedOrder;
    }

    public void setLastReceievedOrder(Order lastReceievedOrder) {
        this.lastReceievedOrder = lastReceievedOrder;
    }

    public boolean isPizzaioloRunning() {
        return isPizzaioloRunning;
    }

    public void setPizzaioloRunning(boolean pizzaioloRunning) {
        isPizzaioloRunning = pizzaioloRunning;
    }

    @Override
    public String getFormat(boolean isStartFormat) throws IllegalStateException {
        return (isStartFormat ? "StartTime: " : "EndTime: ") +
                LocalTime.now().toString() + "; Name: " +
                fullName + "; Order ID: " + lastReceievedOrder.getNumber() + '\n';
    }

    @Override
    public void run() throws IllegalStateException {
        if(lastReceievedOrder == null) {
            throw new IllegalStateException();
        }

        isPizzaioloRunning = true;
        File pizzaioloFile = new File("pizzaiolofiles/pizzaiolo" + fullName + ".txt");

        try {
            if(pizzaioloFile.getParentFile().mkdirs() && pizzaioloFile.createNewFile()) {  // if a new file needs to be created
                System.out.println("File created: " + pizzaioloFile.getName());
            } else {
                System.out.println("File already exists: " + pizzaioloFile.getName());
            }
        } catch (IOException e) {
            System.out.println("Couldn't create com.lozanov.pizzaiolo" + fullName + " file! Aborting com.lozanov.pizza creation!");
            e.printStackTrace();
            isPizzaioloRunning = false;
            return;
        }

        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(pizzaioloFile, true); // used to write into the file (while also appending to it)
        } catch (IOException e) {
            System.out.println("Couldn't open file w/ file name " + pizzaioloFile.getName() + "!");
            e.printStackTrace();
            isPizzaioloRunning = false;
            return;
        }

        String pizzaioloStartFormat = getFormat(true);

        try {
            fileWriter.write(pizzaioloStartFormat);
        } catch (IOException e) {
            System.out.println("Couldn't write to com.lozanov.pizzaiolo" + fullName + " file stream! Aborting com.lozanov.pizza creation!");
            e.printStackTrace();
            isPizzaioloRunning = false;
            return;
        }

        try {
            Thread.sleep(
                (lastReceievedOrder.getPizza().getIngredients().size() * pizzaioloType.getIngredientParseTime()));
                // wait for time needed to parse all the ingredients (depending on the com.lozanov.pizzaiolo's skill level)
        } catch (InterruptedException e) {
            e.printStackTrace();
            isPizzaioloRunning = false;
        }

        String pizzaioloEndFormat = getFormat(false);

        try {
            fileWriter.write(pizzaioloEndFormat);
        } catch (IOException e) {
            System.out.println("Couldn't write to com.lozanov.pizzaiolo" + fullName + " file stream! Aborting com.lozanov.pizza creation!");
            e.printStackTrace();
            isPizzaioloRunning = false;
            return;
        }

        try {
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Couldn't close com.lozanov.pizzaiolo" + fullName + " file stream! Aborting com.lozanov.pizza creation!");
            e.printStackTrace();
            isPizzaioloRunning = false;
            return;
        }

        isPizzaioloRunning = false;
    }

}
