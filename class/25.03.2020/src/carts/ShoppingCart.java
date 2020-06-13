package carts;

import products.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShoppingCart {
    Map<Integer, Integer> products; // ID to quantity


    public ShoppingCart() {
        this(new HashMap<>());
    }

    public ShoppingCart(Map<Integer, Integer> products) {
        this.products = products;
    }

    public void addProduct(Product product, Integer quantity) {
        products.put(product.getID(), quantity);
    }
}
