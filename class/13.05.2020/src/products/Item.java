package products;

public class Item {
    private Product product;
    private double quantity;

    public Item(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Item() {
        this(new Product(), 1.0);
    }

    public double getTotalSum() {
        return quantity * product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
