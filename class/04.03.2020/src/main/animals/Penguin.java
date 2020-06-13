package main.animals;

public class Penguin extends Bird {


    public Penguin() {
    }

    public Penguin(int eggCount) {
        super(eggCount);
    }

    public Penguin(double weight, String type, String name, int eggCount) {
        super(weight, type, name, eggCount);
    }

    @Override
    public void sayName() {
        System.out.println("I am a penguin and my name is " + name);
    }

    @Override
    public void fly() {
        System.out.println("I am a penguin and I am flying; my name is " + name);
    }

    @Override
    public void birth() {
        System.out.println("I am a penguin and I am giving birth; my name is " + name);
    }

    @Override
    public void swim() {
        System.out.println("I am a penguin I am swmimming; and my name is " + name);
    }

    @Override
    public void walk() {
        System.out.println("I am a penguin and I am walking; my name is " + name);
    }
}
