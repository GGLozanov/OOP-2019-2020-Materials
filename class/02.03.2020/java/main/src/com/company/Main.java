package com.company;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner scanner = new Scanner(System.in); // say the default stream is the input one

        ArrayList<ISellable> sellables = new ArrayList<>();

        Apple apple = new Apple(scanner.hasNextInt() ? scanner.nextInt() : 0);

        sellables.add(new Apple());
        sellables.add(new Apple());
        sellables.add(new Apple());
        sellables.add(new Cabbage());
        sellables.add(new Cabbage());

        Market market = new Market();
        market.sell(sellables);

        // Product p = (Product)sellables.get(2);
        // p.print();
    }
}
