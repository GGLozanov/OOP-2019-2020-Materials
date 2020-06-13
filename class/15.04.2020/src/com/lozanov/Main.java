package com.lozanov;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Circle circle1 = new Circle();
        Circle circle2 = new Circle();

        Container<Circle> container = new Container<>(List.of(circle1, circle2));
        System.out.println(container.getSmallest());
    }
}
