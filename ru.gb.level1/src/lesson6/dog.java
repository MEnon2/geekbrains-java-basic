package lesson6;

public class dog extends animals {

    @Override
    public void run(int length) {
        System.out.println("Собака Побежал");
    }

    @Override
    public void swim(int length) {
        System.out.println("Собака плавает");
    }
}
