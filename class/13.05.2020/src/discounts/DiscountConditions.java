package discounts;

import categories.Category;
import products.Product;

import java.util.ArrayList;
import java.util.List;

public class DiscountConditions {
    private List<Product> products;
    private List<Category> categories; // holds all categories

    private double sumMargin;
    private double countMargin;

    public DiscountConditions(List<Product> products, List<Category> categories, double sumMargin, double countMargin) {
        this.products = products;
        this.categories = categories;
        this.sumMargin = sumMargin;
        this.countMargin = countMargin;
    }

    public DiscountConditions() {
        this(new ArrayList<>(), new ArrayList<>(), 5.0, 5.0);
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public double getSumMargin() {
        return sumMargin;
    }

    public double getCountMargin() {
        return countMargin;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setSumMargin(double sumMargin) {
        this.sumMargin = sumMargin;
    }

    public void setCountMargin(double countMargin) {
        this.countMargin = countMargin;
    }
}
