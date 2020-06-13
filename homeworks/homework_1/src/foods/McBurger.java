package foods;

public class McBurger extends Food {
    public McBurger() {
        super();
    }

    public McBurger(double amount, double quality) {
        super(amount, quality);
    }

    @Override
    public void passWinter() {
        if(getIncrementedAge() == 1) {
            amount -= ((double) 50/100)*amount;
            quality -= ((double) 20/100)*amount;
        }
    }
}
