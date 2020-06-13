package current;

public class Virus implements Comparable {

    public String name;
    public String countryOfOrigin;
    public long infected_amount;
    public boolean isCured;

    public Virus() {
        this("", "", 10, false);
    }

    public Virus(String name, String countryOfOrigin, long infected_amount, boolean isCured) {
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.infected_amount = infected_amount;
        this.isCured = isCured;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Virus) {
            return ((Virus) o).name.compareTo(name);
        }
        return -1;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Virus{name=" + name + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Virus) {
            if(((Virus) obj).name.equals(name)) {
                return true;
            }
        }
        return false;
    }

   /* public boolean equals(Virus virus) {
        return virus.name.contentEquals(name);
    } */
}
