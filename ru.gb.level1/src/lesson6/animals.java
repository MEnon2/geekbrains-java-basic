package lesson6;

public abstract class animals {

    private int countAnimals = 0;
    private String name;

    public animals() {
        this.countAnimals++;
    }

    public int getCountAnimals() {
        return countAnimals;
    }

    public void move(int length) {

    }
}
