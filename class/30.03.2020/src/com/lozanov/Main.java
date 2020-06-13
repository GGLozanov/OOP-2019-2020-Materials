package com.lozanov;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        // shortest distance between 2 cities
        City city1 = new City();
        City city2 = new City();
        City city3 = new City();

        Traveller traveller = new Traveller(city1, city2);
        System.out.println(traveller.findShortestPath());
    }
}
