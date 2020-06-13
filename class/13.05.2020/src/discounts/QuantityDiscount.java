package discounts;

public class QuantityDiscount extends Discount {
    public QuantityDiscount(String code, String name, DiscountConditions conditions) {
        super(code, name, conditions);
    }

    public QuantityDiscount() {
        super();
    }


}
