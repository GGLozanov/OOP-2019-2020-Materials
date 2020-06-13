package org.elsys.glozanov;

public class Rapper {

    public String getName() {
        return name;
    }

    public double getEarnings() {
        return earnings;
    }

    private static int count = 0;
    public static void incrementCount() {
        count++;
    }
    public static int getCount() {
        return count;
    }

    protected String name; // properties are package-private
    protected double earnings;

    public Rapper() {
        this("Rapper McRapperson", 10.0);
        // name = "Rapper McRapperson";
        // earnings = 10.0;
    }

    public Rapper(String name, double earnings) {
        this.name = name;
        this.earnings = earnings;
        Rapper.incrementCount();
    }
}
