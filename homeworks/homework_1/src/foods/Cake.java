package foods;

public class Cake extends Food {
    public Cake() {
        super();
    }

    public Cake(double amount, double quality) {
        super(amount, quality);
    }

    @Override
    public void passWinter() {
        amount -= ((double) 30/100)*amount;
        incrementAge();
        quality *= (0.1 + 1.99/(Math.pow(2, age/0.85)));
    }
}
