package com.company;

public class Apple extends Product implements ISellable {

    int juiciness = 1;


    @Override
    void print() {
        System.out.println("APPLE");
    }

    @Override
    public void sell() {
        System.out.println("Sell dat apple!!!!!!!!!");
    }

    public Apple() {
        this(1, "Apple");
    }

    public Apple(int juiciness) {
        this();
        this.juiciness = juiciness;
    }

    public Apple(int quantity, String name) {
        super(quantity, name);
    }

    public Apple(int quantity, String name, int juiciness) {
        super(quantity, name);
        this.juiciness = juiciness;
    }
}
