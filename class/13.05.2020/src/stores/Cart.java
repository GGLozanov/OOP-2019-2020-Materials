package stores;

import products.Item;
import products.Product;

import java.util.List;
import java.util.Optional;

public class Cart {

    private List<Item> items;

    public void addProduct(Product product) {
        Optional<Item> it = items.stream().filter(item -> item.getProduct() == product).findAny();
        if(it.isEmpty()) {
            items.add(new Item(product, 1));
        } else {
            Item i = it.get();
            i.setQuantity(i.getQuantity() + 1);
        }
    }

    public void checkout() {
        // apply all disounts here♦
    }

    public Cart(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
