package lesson6;

public class main {

    public static void main(String[] args) {
        animals[] arrAnimals = new animals[5];

        arrAnimals[0] = new dog();
        arrAnimals[1] = new cat();

        arrAnimals[0].getCountAnimals();
        arrAnimals[1].getCountAnimals();

    }
}
