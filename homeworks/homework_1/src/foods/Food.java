package foods;

public abstract class Food {
    protected int age = 0;
    protected double amount;
    protected double quality;

    public Food() {
        this(1.0, 1.0);
    }

    public Food(double amount, double quality) {
        this.amount = amount;
        this.quality = quality;
    }

    public double getFoodScore() {
        return amount * quality;
    }
    public abstract void passWinter();

    public double getAmount() {
        return amount;
    }

    public double getQuality() {
        return quality;
    }

    public int getAge() {
        return age;
    }

    protected void incrementAge() {
        age++;
    }

    public int getIncrementedAge() {
        incrementAge();
        return age;
    }
}
