package com.lozanov;

import java.util.HashMap;

public class Road {
    static int lastID = 0;
    int ID;
    int length;
    String roadName;

    City city1;
    City city2;

    public Road() {
        this("Hemos", 324, new City(), new City());
    }

    public Road(String roadName, int length, City city1, City city2) {
        this.roadName = roadName;
        this.length = length;
        if(city1.ID < City.lastID && city2.ID < City.lastID) {
            this.city1 = city1;
            this.city1 = city2;
        } else {
            this.city1 = new City();
            this.city2 = new City();
        }
    }

}
