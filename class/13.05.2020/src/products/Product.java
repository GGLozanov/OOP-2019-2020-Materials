package products;

import categories.Category;

public class Product {
    protected String code;
    protected double price;
    protected String measurementUnit;
    protected Category category;

    public Product() {
        this("defCode", 2.0, "kms", new Category());
    }

    public String getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public Category getCategory() {
        return category;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(String code, double price, String measurementUnit, Category category) {
        this.code = code;
        this.price = price;
        this.measurementUnit = measurementUnit;
        this.category = category;
    }
}
