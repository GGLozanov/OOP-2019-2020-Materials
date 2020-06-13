package com.company;

import org.elsys.glozanov.Rapper;

public class Main implements OKBoomer {

    public Main() {

    }

    public Main(int id, String name, double status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getStatus() {
        return status;
    }

    private int id;
    private String name;
    private double status;

    public void boom() {

    }

    public static void main(String[] args) throws Exception {
        Rapper Drake = new Rapper("Drake", 30.0);

        System.out.println(Rapper.getCount());
        System.out.println(Drake.getName() + Drake.getEarnings());
    }
}
