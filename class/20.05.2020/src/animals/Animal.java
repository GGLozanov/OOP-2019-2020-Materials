package animals;

import enums.EatingTypes;

public class Animal {
    private String name;
    private String species;
    private EatingTypes eatingType;
    private boolean needWalks;
    private boolean needPool;

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public EatingTypes getEatingType() {
        return eatingType;
    }

    public boolean getNeedWalks() {
        return needWalks;
    }

    public boolean getNeedPool() {
        return needPool;
    }

    public Animal() {
        this("", "", EatingTypes.CARNIVORE, false, false);
    }

    public Animal(String name, String species, EatingTypes eatingType, boolean needPool) {
        this.name = name;
        this.species = species;
        this.eatingType = eatingType;
        this.needWalks = false;
        this.needPool = needPool;
    }

    public Animal(String name, String species, EatingTypes eatingType, boolean needWalks, boolean needPool) {
        this.name = name;
        this.species = species;
        this.eatingType = eatingType;
        this.needWalks = needWalks;
        this.needPool = needPool;
    }
}
