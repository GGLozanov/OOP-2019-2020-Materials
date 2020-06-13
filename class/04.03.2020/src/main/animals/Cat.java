package main.animals;

import main.interfaces.Swimmable;

public class Cat extends Mammal implements Swimmable {

    public Cat() {
        super();
    }

    public Cat(int milkAmount) {
        super(milkAmount);
    }

    public Cat(double weight, String type, String name, int milkAmount) {
        super(weight, type, name, milkAmount);
    }

    @Override
    public void walk() {
        System.out.println("I am a cat and I am walking");
    }

    @Override
    public void birth() {
        System.out.println("I am a cat and I am giving birth");
    }

    @Override
    public void swim() {
        System.out.println("I am a cat and I am swimming; my name is " + name);
    }
}
