package main.animals;

public class Seagull extends Bird {
    public Seagull() {
        super();
    }

    public Seagull(int eggCount) {
        super(eggCount);
    }

    public Seagull(double weight, String type, String name, int eggCount) {
        super(weight, type, name, eggCount);
    }

    @Override
    public void sayName() {
        System.out.println("I am a Seagull and my name is " + name);
    }

    @Override
    public void fly() {
        System.out.println("I am a Seagull; I am flying and my name is " + name);
    }

    @Override
    public void birth() {
        System.out.println("I am a Seagull I am giving birth; my name is " + name);
    }

    @Override
    public void swim() {
        System.out.println("I am a Seagull and I am swimming; my name is " + name);
    }

    @Override
    public void walk() {
        System.out.println("I am a Seagull and I am walking; my name is " + name);
    }
}
