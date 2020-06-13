package com.company;

public class Derived extends Main {

    private int specialVar;

    public Derived() {

    }

    public Derived(int id, String name, double status) {
        super(id, name, status);
    }

    public Derived(int id, String name, double status, int specialVar) {
        this(id, name, status);
        this.specialVar = specialVar;
    }

    public static void main(String[] args) {

    }

}
