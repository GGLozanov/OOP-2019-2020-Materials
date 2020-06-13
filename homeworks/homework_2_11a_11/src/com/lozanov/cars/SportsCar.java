package com.lozanov.cars;

import com.lozanov.enums.EngineType;
import com.lozanov.enums.Model;
import com.lozanov.enums.Region;

public class SportsCar extends Car {
    public SportsCar() {
        super();
    }

    public SportsCar(Model model, int year, int price, EngineType engineType, Region region) {
        super(model, year, price, engineType, region);
    }
}
