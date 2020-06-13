package main.animals;

import main.interfaces.Swimmable;

public abstract class Fish extends Animal implements Swimmable {

    int caviarCount;

    public Fish() {
        super();
        this.caviarCount = 1;
    }

    public Fish(double weight, String type, String name) {
        super(weight, type, name);
        this.caviarCount = 1;
    }

    public Fish(double weight, String type, String name, int caviarCount) {
        super(weight, type, name);
        this.caviarCount = caviarCount;
    }

    @Override
    public void sayName() {
        System.out.println("I am a fish and my name is " + name);
    }

    @Override
    public void swim() {
        System.out.println("I am a fish and I am swimming; my name is " + name);
    }

    @Override
    public void birth() {
        System.out.println("I am a fish and I am laying caviar");
    }
}
