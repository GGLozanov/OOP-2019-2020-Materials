package main.animals;

import main.interfaces.Swimmable;

public class Whale extends Mammal implements Swimmable {
    public Whale() {
        super();
    }

    public Whale(int milkAmount) {
        super(milkAmount);
    }

    public Whale(double weight, String type, String name, int milkAmount) {
        super(weight, type, name, milkAmount);
    }

    @Override
    public void sayName() {
        System.out.println("I am a whale and my name is " + name);
    }

    @Override
    public void walk() {
        System.out.println("I am a whale and I cannot walk; and my name is " + name);
    }

    @Override
    public void birth() {
        System.out.println("I am a whale and I am giving birth; and my name is " + name);
    }

    @Override
    public void swim() {
        System.out.println("I am a whale I am swimming; and my name is " + name);
    }
}
