package bsu.rfe.group9.kondarevich;
import java.util.Objects;

public class Cocktail extends Food{

    protected String drink = null;
    protected String fruit = null;

    public Cocktail(String name, double colories, String drink, String fruit) {
        super(name, colories);
        this.drink = drink;
        this.fruit = fruit;
    }

    public Cocktail(String name, String drink, String fruit) {
        super(name);
        this.drink = drink;
        this.fruit = fruit;
        this.colories = calculateCalories();
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getDrink() {
        return drink;
    }

    public String getFruit() {
        return fruit;
    }

    @Override
    public boolean equals(Object arg0) {
        if (!(arg0 instanceof Cocktail)) {
            return false;
        }
        if(name == null || drink == null || fruit == null){
            return false;
        }
        if((((Cocktail) arg0).drink) == null || (((Cocktail) arg0).name) == null || (((Cocktail) arg0).fruit) == null){
            return false;
        }
        return (name.equals(((Cocktail)arg0).name) && drink.equals(((Cocktail)arg0).drink)
                && fruit.equals(((Cocktail)arg0).fruit));
    }

    @Override
    public String toString() {
        return "Cocktail - " +
                "drink = " + drink +
                ", fruit = " + fruit +
                ", name = " + name +
                ", colories = " + colories;
    }

    @Override
    public int calculateCalories() {
        return (drink.length() * fruit.length());
    }
}