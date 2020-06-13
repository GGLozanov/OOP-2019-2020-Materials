package com.lozanov.stores;

import com.lozanov.cars.Car;
import com.lozanov.enums.Model;
import com.lozanov.exceptions.CarNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CarStore {

    private Collection<Car> cars;

    public CarStore() {
        this(new ArrayList<>());
    }

    public CarStore(Collection<Car> cars) {
        this.cars = cars;
    }

    /**
     * Adds the specified car in the store.
     * @return true if the car was added successfully to the store
     */
    public boolean add(Car car) {
        return cars.add(car);
    }

    /**
     * Adds all of the elements of the specified collection in the store.
     * @return true if the store com.lozanov.cars are changed after the execution
     * (i.e. at least one new car is added to the store)
     */
    public boolean addAll(Collection<Car> cars) {
        return this.cars.addAll(cars);
    }

    /**
     * Removes the specified car from the store.
     * @return true if the car is successfully removed from the store
     */
    public boolean remove(Car car) {
        return cars.remove(car);
    }

    /**
     * Finds a car from the store by its registration number.
     * @throws CarNotFoundException if a car with this
     * registration number is not found in the store
     **/
    public Car getCarByRegistrationNumber(String registrationNumber) throws CarNotFoundException {
        final Car c = cars.stream().filter((car -> car.getRegistrationNumber().equals(registrationNumber))).findFirst().orElse(null);
        if(c != null) return c;
        throw new CarNotFoundException("Car not found!");
    }

    /**
     * Returns all com.lozanov.cars of a given model.
     * The com.lozanov.cars need to be sorted by year of manufacture (in ascending order).
     */
    public Collection<Car> getCarsByModel(Model model) {
        return cars.stream().filter((car -> car.getModel().equals(model))).
                sorted(Comparator.comparing(Car::getYear)).collect(Collectors.toList());
    }

    /**
     * Returns all com.lozanov.cars sorted by their natural ordering
     * (according to the implementation of the Comparable<Car> interface).
     **/
    public Collection<Car> getCars() {
        return cars.stream().sorted(Car::compareTo).
                collect(Collectors.toList()); // giving the comparable implementation just to be safe
    }

    /**
     * Returns all com.lozanov.cars sorted according to the
     * order induced by the specified comparator.
     */
    public Collection<Car> getCars(Comparator<Car> comparator) {
        return cars.stream().sorted(comparator).
                collect(Collectors.toList());
    }

    /**
     * Returns all com.lozanov.cars sorted according to the
     * given comparator and boolean flag for order.
     * @param isReversed if true, the com.lozanov.cars should be returned in reverse order
     */
    public Collection<Car> getCars(Comparator<Car> comparator,
                                   boolean isReversed) {
        return isReversed ? cars.stream().sorted(comparator.reversed()).
                collect(Collectors.toList()) :
            getCars(comparator);
    }

    /**
     * Returns the total number of com.lozanov.cars in the store.
     */
    public int getNumberOfCars() {
        return cars.size();
    }

    /**
     * Returns the total price of all com.lozanov.cars in the store.
     */
    public int getTotalPriceOfCars() {
        return cars.stream().mapToInt(Car::getPrice).sum();
    }
}

