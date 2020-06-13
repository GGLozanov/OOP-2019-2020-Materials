package products;

import enums.Unit;

public class Product {
    static Integer lastID = 0;
    Integer ID;
    String name;
    double price;
    Unit unit;

    public Product(String name, double price, Unit unit) {
        this.ID = ++lastID;
        this.name = name;
        this.price = price;
        this.unit = unit;
    }

    public Integer getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Unit getUnit() {
        return unit;
    }

    public boolean validateFields() {
        return name != null && price >= 0 && unit != null;
    }
}
