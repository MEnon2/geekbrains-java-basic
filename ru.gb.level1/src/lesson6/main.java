package lesson6;

public class main {

    public static void main(String[] args) {
        animals[] arrAnimals = {
                new dog(),
                new dog(),
                new cat()
        };


        arrAnimals[0].getCountAnimals();
        arrAnimals[1].getCountAnimals();

        for (int i = 0; i < arrAnimals.length; i++) {
            arrAnimals[i].run(150);
            arrAnimals[i].swim(200);

        }

    }
}
