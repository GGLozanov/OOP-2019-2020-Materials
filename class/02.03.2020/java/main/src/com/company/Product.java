package com.company;

public abstract class Product {
    int quantity;
    String name;

    public Product() {
        this(1, "Product");
    }

    public Product(int quantity, String name) {
        this.quantity = quantity;
        this.name = name;
    }

    abstract void print();

}
