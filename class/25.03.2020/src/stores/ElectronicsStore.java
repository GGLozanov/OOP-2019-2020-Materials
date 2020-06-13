package stores;

import carts.ShoppingCart;
import enums.Country;
import javafx.util.Pair;
import orders.Order;
import products.Product;
import users.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ElectronicsStore {
    Map<Integer, Pair<Product, Integer>> products;
    Set<Order> orders;
    Set<User> users;
    ShoppingCart shoppingCart;
    Country country;

    public ElectronicsStore() {
        this(new HashMap<>(), Country.UGANDA, new HashSet<>(), new ShoppingCart());
    }

    public ElectronicsStore(Map<Integer, Pair<Product, Integer>> products, Country country, Set<Order> orders, ShoppingCart shoppingCart) {
        this.products = products;
        this.country = country;
        this.orders = orders;
        this.shoppingCart = shoppingCart;
    }

    public Map<Integer, Pair<Product, Integer>> getProducts() {
        return products;
    }

    public Country getCountry() {
        return country;
    }

    public void registerUser(User user) throws Exception {
        if(user.validateFields()) {
            users.add(new User(user));
        } else throw new Exception("One of your fields is empty!");
    }

    public void addProduct(Product product, Integer quantity) throws Exception {
        Integer productID = product.getID();
        if(product.validateFields()) {
            if(products.containsKey(productID)) {
                Pair<Product, Integer> pair = products.get(product.getID());
                Integer previousQuantity = pair.getValue();
                products.put(productID, new Pair<>(pair.getKey(), previousQuantity + 1));
            } else products.put(product.getID(), new Pair<>(product, quantity));
        } else throw new Exception();
    }

    public void removeItem(Product product, Integer amount) throws Exception {
        
    }
}
