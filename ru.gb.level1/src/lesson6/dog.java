package lesson6;

public class dog extends animals {
    public dog(String name) {
        super(name, 500, 10);
        super.countAnimals++;
    }

    @Override
    public void run(int length) {
        System.out.printf("Собака %s пробежала %s: %s %n", this.getName(),length, length <= getMaxLengthRun());
    }

    @Override
    public void swim(int length) {
        System.out.printf("Собака %s проплыла %s: %s %n", this.getName(),length, length <= getMaxLengthSwim());
    }
}
