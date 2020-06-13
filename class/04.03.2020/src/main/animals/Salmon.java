package main.animals;

public class Salmon extends Fish {
    public Salmon() {
        super();
    }

    public Salmon(double weight, String type, String name) {
        super(weight, type, name);
    }

    public Salmon(double weight, String type, String name, int caviarCount) {
        super(weight, type, name, caviarCount);
    }

    @Override
    public void sayName() {
        System.out.println("I am a salmon and my name is " + name);
    }

    @Override
    public void birth() {
        System.out.println("I am a salmon and I am laying my caviar; my name is " + name);
    }

    @Override
    public void swim() {
        System.out.println("I am a salmon; I am swimming and my name is " + name);
    }
}
