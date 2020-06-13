package orders;

import enums.Status;
import javafx.util.Pair;
import products.Product;

import java.util.Map;
import java.util.Set;

public class Order {
    Set<OrderInformation> orderInformation;
    Status status;
    Map<Integer, Pair<Product, Integer>> products;
    double orderPrice;

    public Order(Set<OrderInformation> orderInformation, Status status, Map<Integer, Pair<Product, Integer>> products, double orderPrice) {
        this.orderInformation = orderInformation;
        this.status = status;
        this.products = products;
        this.orderPrice = orderPrice;
    }

    public void addProduct(Product product, Integer quantity) {
        products.put(product.getID(), new Pair<>(product, quantity));
    }
}
