package main.animals;

import main.interfaces.Flyable;
import main.interfaces.Swimmable;
import main.interfaces.Walkable;

public abstract class Bird extends Animal implements Flyable, Walkable, Swimmable {

    int eggCount;

    public Bird() {
        super();
        this.eggCount = 1;
    }

    public Bird(int eggCount) {
        this.eggCount = eggCount;
    }


    public Bird(double weight, String type, String name, int eggCount) {
        super(weight, type, name);
        this.eggCount = eggCount;
    }

    @Override
    public void sayName() {
        System.out.println("I am a bird and my name is " + name);
    }

    @Override
    public void fly() {
        System.out.println("I am a bird and I am flying; my name is " + name);
    }

    @Override
    public void birth() {
        System.out.println("I am a bird and I am giving birth");
    }

}
