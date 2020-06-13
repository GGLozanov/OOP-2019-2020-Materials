package com.lozanov;

import java.util.*;

public class Traveller {
    List<City> citiesToVisit = new ArrayList<>(); // the cities a given way has crossed before reaching destination
    City source;
    City destination;

    public Traveller() {
        this(new City(), new City());
    }

    public Traveller(City source, City destination) {
        this.source = source;
        this.destination = destination;
    }

    // solution relifted from my algorithms textbook (which was lifted from the net); hey, everyone learns!
    // BFS + hashmap for parent cities and those visited
    public int findShortestPath() throws Exception {
        HashMap<City, City> parents = new HashMap<>();
        List<Road> roadsTaken = new ArrayList<>();
        // 1 - from
        // 3 - to
        // {1 -> 2}, {2 -> 3}
        citiesToVisit.add(source);
        parents.put(source, null);

        City city = source;

        while(!citiesToVisit.isEmpty()) {
            try {
                city = citiesToVisit.remove(citiesToVisit.size() - 1); // pop last city
            } catch(NullPointerException e) {
                break;
            }
            if(city.ID == destination.ID) break; // if the current city is the one we need, break
            for(Road road : city.roads) { // check all roads of the current city
                if(!parents.containsValue(road.city2)) { // if city isn't present in map, then it isn't visited
                    citiesToVisit.add(road.city2);
                    parents.put(city, road.city2);
                    roadsTaken.add(road);
                }
            }
        }

        if(city.ID != destination.ID) throw new Exception(); // means that no path is found

        return roadsTaken.stream().mapToInt(road -> road.length).sum(); // map current roads to int and sums the roads
    }


}
