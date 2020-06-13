package com.lozanov.furnace;

import com.lozanov.interfaces.ThreadStatusFormatter;
import com.lozanov.pizza.Pizza;

import java.io.*;
import java.time.LocalTime;

import static java.lang.Thread.currentThread;

public class FurnaceWork implements Runnable, ThreadStatusFormatter {
    private int furnaceNumber;
    private int orderNumber;
    private Pizza requestedPizza;

    public FurnaceWork(int furnaceNumber, int orderNumber, Pizza requestedPizza) throws IllegalArgumentException {
        if(furnaceNumber < 0 || orderNumber < 0 || requestedPizza == null) {
            throw new IllegalArgumentException();
        }

        this.furnaceNumber = furnaceNumber;
        this.orderNumber = orderNumber;
        this.requestedPizza = requestedPizza;
    }

    public int getFurnaceNumber() {
        return furnaceNumber;
    }

    public void setFurnaceNumber(int furnaceNumber) {
        this.furnaceNumber = furnaceNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String getFormat(boolean isStartFormat) {
        return (isStartFormat ? "StartTime: " : "EndTime: ") +
                LocalTime.now().toString() + "; Unique ID: " + currentThread().getId() + furnaceNumber
                + "; Order ID: " + orderNumber + '\n';
    }

    @Override
    public void run() {
        long uniqueFurnaceWorkID = currentThread().getId() + furnaceNumber;

        File furnaceWorkFile = new File("furnacefiles/furnaceWork" + uniqueFurnaceWorkID + ".txt");
        // extract unique IDin property or something
        // (can't in constructor because main thread is still being invoked there, not the created thread)

        try {
            if(furnaceWorkFile.getParentFile().mkdirs() && furnaceWorkFile.createNewFile()) {  // if a new file needs to be created (along with its dirs)
                System.out.println("File created: " + furnaceWorkFile.getName());
            } else {
                System.out.println("File already exists: " + furnaceWorkFile.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Couldn't create furnaceWork w/ ID " + uniqueFurnaceWorkID + " file! Aborting com.lozanov.pizza creation!");
            return;
        }

        System.out.println("Passed file creation");

        FileWriter fileWriter; // used to write into the file (and append to it)

        try {
            fileWriter = new FileWriter(furnaceWorkFile, true);
        } catch (IOException e) {
            System.out.println("Couldn't create unique furnaceWorkID w/ ID " + uniqueFurnaceWorkID + " file stream! Aborting com.lozanov.pizza creation!");
            e.printStackTrace();
            return;
        }

        System.out.println("Created FileWriter");

        String furnaceWorkStartFormat = getFormat(true);

        System.out.println("Start format: " + furnaceWorkStartFormat);

        try {
            fileWriter.write(furnaceWorkStartFormat);
        } catch (IOException e) {
            System.out.println("Couldn't write to furnaceWork w/ ID " + uniqueFurnaceWorkID + " file stream! Aborting com.lozanov.pizza creation!");
            e.printStackTrace();
            return;
        }

        System.out.println("Wrote to FileWriter: " + furnaceWorkStartFormat);

        try {
            requestedPizza.bakePizza();
            // wait for time needed to bake all the ingredients (by calling the bakePizza() method in this thread)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String furnaceWorkEndFormat = getFormat(false);

        try {
            fileWriter.write(furnaceWorkEndFormat);
        } catch (IOException e) {
            System.out.println("Couldn't write to furnaceWork w/ ID " + uniqueFurnaceWorkID + " file stream! Aborting com.lozanov.pizza creation!");
            e.printStackTrace();
            return;
        }

        System.out.println("Wrote to FileWriter: " + furnaceWorkEndFormat);

        try {
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Couldn't close furnaceWork w/ ID " + uniqueFurnaceWorkID + " file stream! Aborting com.lozanov.pizza creation!");
            e.printStackTrace();
        }

        System.out.println("Closed FileWriter and flushed stream");
    }
}
