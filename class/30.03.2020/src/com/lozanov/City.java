package com.lozanov;

import java.util.ArrayList;
import java.util.List;

public class City {
    static int lastID = 0;
    int ID;
    String cityName;

    List<Road> roads; // cityID1 is always this city's ID here

    public City() {
        this("Rome", new ArrayList<>()); // all roads lead to Rome
    }

    public City(String cityName, List<Road> roads) {
        ID = ++lastID;
        this.cityName = cityName;
        this.roads = roads;
    }
}
