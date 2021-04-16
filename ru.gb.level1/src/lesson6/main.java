package lesson6;

public class main {

    public static void main(String[] args) {
        animals[] arrAnimals = {
                new dog("Шарик"),
                new dog("Бобик"),
                new cat("Мурка")
        };


        for (int i = 0; i < arrAnimals.length; i++) {
            arrAnimals[i].run(150);
            arrAnimals[i].swim(200);

        }
        System.out.println("Собак: " + getCount(arrAnimals, "dog"));
        System.out.println("Кошек: " + getCount(arrAnimals, "cat"));
        System.out.println("Животных: " + getCount(arrAnimals, "animal"));

    }

    public static int getCount(animals[] array,String nameClass ) {
        int CountAnimals = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] instanceof dog && nameClass == "dog") {
                CountAnimals++;
            }
            if (array[i] instanceof cat && nameClass == "cat") {
                CountAnimals++;
            }
            if (array[i] instanceof animals && nameClass == "animal") {
                CountAnimals++;
            }
        }
        return CountAnimals;
    }

}
