package lesson6;

public abstract class animals {

    private int countAnimals = 0;

    public animals() {
        this.countAnimals++;
    }

    public int getCountAnimals() {
        return countAnimals;
    }
}
