package main.animals;

public abstract class Animal {

    double weight;
    String type;
    String name;

    public Animal() {
        this(4.0, "Animal", "Default");
    }

    public Animal(double weight, String type, String name) {
        this.weight = weight;
        this.type = type;
        this.name = name;
    }

    public abstract void sayName();
    public abstract void birth();
}
