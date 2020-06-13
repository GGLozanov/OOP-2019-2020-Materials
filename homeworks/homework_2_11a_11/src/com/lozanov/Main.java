package com.lozanov;

import com.lozanov.cars.OrdinaryCar;
import com.lozanov.enums.EngineType;
import com.lozanov.enums.Model;
import com.lozanov.enums.Region;

public class Main {

    public static void main(String[] args) {
	// write your code here
        OrdinaryCar car = new OrdinaryCar();
        OrdinaryCar car2 = new OrdinaryCar();
        // two cars from Sofia w/ proper registration numbers
        OrdinaryCar car3 = new OrdinaryCar(Model.AUDI, 1999, 25000, EngineType.DIESEL, Region.GABROVO);

        System.out.println(car.getRegistrationNumber()); // 1000 - Sofia (default)
        System.out.println(car2.getRegistrationNumber()); // 1001 - Sofia (default)
        System.out.println(car3.getRegistrationNumber()); // 1000 - Gabrovo
    }
}
