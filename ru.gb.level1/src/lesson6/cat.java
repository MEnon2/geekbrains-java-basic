package lesson6;

public class cat extends animals{

    @Override
    public void run(int length) {
        System.out.println("Кот Побежал");
    }

    @Override
    public void swim(int length) {
        System.out.println("не плавает");
    }

}
