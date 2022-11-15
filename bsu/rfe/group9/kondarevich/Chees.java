package bsu.rfe.group9.kondarevich;

public class Chees extends Food {
    @Override
    public int calculateCalories() {
        return 12;
    }

    @Override
    public String toString() {
        return "Cheese - " +
                "name = " + name  +
                ", colories = " + colories;
    }

    public Chees(String name, double colories) {
        super(name, colories);
    }

    public Chees(String name) {
        super(name);
        this.colories = calculateCalories();
    }

    public Chees() {
    }
}