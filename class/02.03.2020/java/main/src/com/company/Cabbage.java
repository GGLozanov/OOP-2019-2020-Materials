package com.company;

import java.time.chrono.IsoEra;

public class Cabbage extends Product implements ISellable {

    int cabbageLevel;

    @Override
    void print() {
        System.out.println("What does the cabbage man use to repair his cabbages? A cabbage patch!" + cabbageLevel + " " + quantity);
    }

    @Override
    public void sell() {
        System.out.println("Sell dat cabbage!!!!!");
    }

    public Cabbage() {
        this(1, "Cabbage", 9000);
    }

    public Cabbage(int quantity, String name, int cabbageLevel) {
        super(quantity, name);
        this.cabbageLevel = cabbageLevel;
    }
}
