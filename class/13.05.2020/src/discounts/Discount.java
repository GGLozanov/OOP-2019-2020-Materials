package discounts;

public class Discount {
    protected String code;
    protected String name;

    protected DiscountConditions conditions;

    public Discount(String code, String name, DiscountConditions conditions) {
        this.code = code;
        this.name = name;
        this.conditions = conditions;
    }

    public Discount() {
        this("defaultCode", "defaultName", new DiscountConditions());
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public DiscountConditions getConditions() {
        return conditions;
    }
}
