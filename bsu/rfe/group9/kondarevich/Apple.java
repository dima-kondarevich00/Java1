package bsu.rfe.group9.kondarevich;

import java.util.Objects;

public class Apple extends Food{

    protected String size;

    public Apple(String name, double colories, String size) {
        super(name, colories);
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apple)) return false;
        if (!super.equals(o)) return false;
        Apple apple = (Apple) o;
        return Objects.equals(size, apple.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    @Override
    public String toString() {
        return "Apple - " +
                "name = " + name  +
                ", size = " + size  +
                ", colories = " + colories;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public Apple(String name, String size) {
        super(name);
        this.size = size;
        this.colories = calculateCalories();
    }

    public Apple(String size) {
        this.size = size;
    }

    @Override
    public int calculateCalories() {
        return size.length();
    }
}