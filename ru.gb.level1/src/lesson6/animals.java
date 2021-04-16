package lesson6;

public abstract class animals {

    public int countAnimals = 0;
    private String name;
    private int maxLengthRun;
    private int maxLengthSwim;

    public animals(String name, int maxLengthRun, int maxLengthSwim) {
        this.name = name;
        this.maxLengthRun = maxLengthRun;
        this.maxLengthSwim = maxLengthSwim;
    }

     public String getName() {
        return this.name;
    }

    public int getMaxLengthRun() {
        return this.maxLengthRun;
    }

    public int getMaxLengthSwim() {
        return this.maxLengthSwim;
    }

    public abstract void run(int length);
    public abstract void swim(int length);

}
