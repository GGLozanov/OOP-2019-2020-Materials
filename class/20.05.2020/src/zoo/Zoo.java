package zoo;

import animals.Animal;
import cells.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Zoo {
    private List<Animal> animals;
    private List<Cell> cells;

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public Zoo() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    public Zoo(List<Animal> animals, List<Cell> cells) {
        this.animals = animals;
        this.cells = cells;
    }

    public Optional<Cell> getCellByID(String cellID) throws Exception {
        Optional<Cell> foundCell = cells
                .stream()
                .filter((cell) -> cell.getID().equals(cellID))
                .findAny();
        if(foundCell.isEmpty()) {
            throw new Exception();
        }

        return foundCell;
    }


    public void addAnimal(String cellID, Animal animal) throws Exception {
        Optional<Cell> foundCell = getCellByID(cellID);

        Cell newCell = foundCell.get();

        if(newCell.getCapacity() >= newCell.getAnimals().size()) {
            throw new Exception();
        }

        if(animal.getNeedPool() && !newCell.isHasPool()) {
            throw new Exception();
        }

        if(!animals.isEmpty())  {
            if(animals.get(0).getEatingType() != animal.getEatingType()) {
                throw new Exception();
            }
        }

        animals.add(animal);
        newCell.getAnimals().add(animal);
    }

    public List<String> possbileCellsFor(Animal animal) {
        return cells.stream()
                .filter(cell -> cell.canAddAnimal(animal))
                .map(Cell::getID)
                .collect(Collectors.toList());
    }

    public boolean hasAnimal(Animal animal) {
        return animals.contains(animal);
    }

    public int getTotalSpaceLeft() {
       return cells.stream()
                .mapToInt(Cell::getRemainingSpace)
                .sum();
    }

    public Map<String, Integer> getSpaceLeft() {
        return cells.stream()
                .collect(Collectors.toMap(Cell::getID, Cell::getRemainingSpace));
    }

    public int getSpaceLeftIn(String cellId) throws Exception {
        Optional<Cell> foundCell = getCellByID(cellId);
        return foundCell.get().getRemainingSpace();
    }

}
