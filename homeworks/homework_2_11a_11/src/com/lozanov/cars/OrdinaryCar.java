package com.lozanov.cars;

import com.lozanov.enums.EngineType;
import com.lozanov.enums.Model;
import com.lozanov.enums.Region;

public class OrdinaryCar extends Car {
    public OrdinaryCar() {
        super();
    }

    public OrdinaryCar(Model model, int year, int price, EngineType engineType, Region region) {
        super(model, year, price, engineType, region);
    }
}
