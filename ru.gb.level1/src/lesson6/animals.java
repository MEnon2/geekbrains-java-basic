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

    public abstract void run(int length);
    public abstract void swim(int length);

}
