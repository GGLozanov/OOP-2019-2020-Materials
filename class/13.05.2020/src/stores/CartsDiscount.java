package stores;

import discounts.Discount;
import discounts.DiscountEvaluator;
import products.Item;

import java.util.List;
import java.util.stream.Collectors;

public class CartsDiscount {
    private List<Discount> discounts;

    public CartsDiscount(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public void applyDiscounts(Cart cart) {
        List<Item> items = cart.getItems();
        List<List<Discount>> applicableDiscounts = items.stream().map(this::getItemDiscounts).reduce();
    }

    public List<Discount> getItemDiscounts(Item item) {
        return discounts.stream().filter(discount -> DiscountEvaluator.isDiscountApplicable(item, discount)).collect(Collectors.toList());
    }
}
