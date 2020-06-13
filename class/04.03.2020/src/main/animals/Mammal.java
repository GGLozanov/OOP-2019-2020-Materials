package main.animals;

import main.interfaces.Walkable;

public abstract class Mammal extends Animal implements Walkable {

    int milkAmount;

    public Mammal() {
        this(2);
    }

    public Mammal(int milkAmount) {
        super();
        this.milkAmount = milkAmount;
    }

    public Mammal(double weight, String type, String name, int milkAmount) {
        super(weight, type, name);
        this.milkAmount = milkAmount;
    }

    @Override
    public void sayName() {
        System.out.println("I am a mammal and my name is " + name);
    }

    @Override
    public void walk() {
        System.out.println("I am a mammal and I am walking; my name is " + name);
    }

    @Override
    public void birth() {
        System.out.println("I am a mammal and I am giving birth");
    }
}
