package main.animals;

import main.interfaces.Flyable;

public class FlyingFish extends Fish implements Flyable {

    public FlyingFish() {
        super();
    }

    public FlyingFish(double weight, String type, String name) {
        super(weight, type, name);
    }

    public FlyingFish(double weight, String type, String name, int caviarCount) {
        super(weight, type, name, caviarCount);
    }

    @Override
    public void sayName() {
        System.out.println("I am a flying fish and my name is " + name);
    }

    @Override
    public void swim() {
        System.out.println("I am a flying fish and I am swimming; and my name is " + name);
    }

    @Override
    public void birth() {
        System.out.println("I am a flying fish and I am giving birth; and my name is " + name);
    }

    @Override
    public void fly() {
        System.out.println("I am a flying fish and I am flying; and my name is " + name);
    }
}
