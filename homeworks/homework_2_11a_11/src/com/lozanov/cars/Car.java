package com.lozanov.cars;

import com.lozanov.enums.EngineType;
import com.lozanov.enums.Model;
import com.lozanov.enums.Region;

import java.util.Random;

public abstract class Car implements Comparable<Car> {

    protected Model model;
    protected int year;
    protected int price;
    protected EngineType engineType;
    protected String registrationNumber;
    protected Region region;

    public Car() {
        this(Model.OPEL,  1995, 20000, EngineType.DIESEL, Region.SOFIA);
    }

    public Car(Model model, int year, int price, EngineType engineType, Region region) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.engineType = engineType;
        this.region = region;

        Random random = new Random();

        this.registrationNumber = region.getPrefix() +
                region.getNumber().toString() +
                Character.toString(random.nextInt(26) + 'A') +
                Character.toString(random.nextInt(26) + 'A');
    }

    /**
     * Returns the model of the car.
     */
    public Model getModel() {
        return model;
    }

    /**
     * Returns the year of manufacture of the car.
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the price of the car.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Returns the engine type of the car.
     */
    public EngineType getEngineType() {
        return engineType;
    }

    /**
     * Returns the unique registration number of the car.
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Region getRegion() {
        return region;
    }

    @Override
    public int compareTo(Car car) {
        int res;
        if((res = model.name().compareTo(car.model.name())) != 0) {
            return res;
        }
        return Integer.compare(year, car.year);
    }
}
