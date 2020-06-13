package main.lozanov;

import main.animals.Mammal;
import main.animals.Whale;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Mammal whale = new Whale();
        whale.walk();
        whale.sayName();
    }
}
