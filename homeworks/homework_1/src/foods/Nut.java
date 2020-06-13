package foods;

public class Nut extends Food {
    public Nut() {
        super();
    }

    public Nut(double amount, double quality) {
        super(amount, quality);
    }

    @Override
    public void passWinter() {
        incrementAge();
    }
}
