package lesson6;

public class cat extends animals {
    public cat(String name) {
        super(name, 200, 0);
    }

    @Override
    public void run(int length) {
        System.out.printf("Кошка %s пробежала: %s: %s %n", this.getName(), length, length <= getMaxLengthRun());
    }

    @Override
    public void swim(int length) {
        System.out.printf("Кошка %s не умеет плавать%n", this.getName());
    }

}
