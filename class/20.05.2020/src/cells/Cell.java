package cells;

import animals.Animal;
import enums.EatingTypes;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<Animal> animals = new ArrayList<>();
    private int capacity;
    private boolean hasPool;
    private String id;
    private static List<String> generatedIDs = new ArrayList<>();

    public String getID() {
        return id;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isHasPool() {
        return hasPool;
    }

    public boolean canAddAnimal(Animal animal) {
        boolean isCellEmpty = animals.isEmpty();
        if(isCellEmpty || (
                animal.getEatingType() != animals.get(0).getEatingType() &&
                capacity < animals.size())) {
            return true;
        }
        return false;
    }

    public int getRemainingSpace() {
        return capacity - animals.size();
    }


    public String getIDIfCanAddAnimal(Animal animal) {
        return canAddAnimal(animal) ? id : "";
    }

    public Cell() {
        this(5, false, "TotallyUniqueId");
    }

    public Cell(int capacity, boolean hasPool, String id) {
        this.capacity = capacity;
        this.hasPool = hasPool;
        if(Cell.generatedIDs.contains(id)) {
            throw new RuntimeException("Not unique ID!");
        } else {
            Cell.generatedIDs.add(id);
        }
    }
}
