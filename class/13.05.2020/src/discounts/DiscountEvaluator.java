package discounts;

import products.Item;
import products.Product;

public class DiscountEvaluator {
    public static boolean isDiscountApplicable(Item item, Discount discount) {
        DiscountConditions discountConditions = discount.getConditions();
        if(discountConditions.getCategories() == null || discountConditions.getProducts() == null) {
            return false;
        }

        if(!discountConditions.getProducts().contains(item.getProduct()) && !discountConditions.getCategories().contains(item.getProduct().getCategory())) {
            return false;
        }

        if(discount instanceof SumDiscount && item.getTotalSum() >= discountConditions.getSumMargin()) {
            return true;
        }

        if(discount instanceof QuantityDiscount && item.getQuantity() >= discountConditions.getCountMargin()) {
            return true;
        }

        return false;
    }
}
