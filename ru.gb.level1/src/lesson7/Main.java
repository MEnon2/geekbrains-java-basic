package lesson7;

public class Main {
    public static void main(String[] args) {

        Cat[] cats = {
                new Cat("Мурзик", 7),
                new Cat("Барсик", 5),
                new Cat("Мурка", 8),
                new Cat("Васька", 6),
                new Cat("Тихон", 4)
        };
        Plate plate = new Plate();

        plate.info();
        plate.addFood(25);
        plate.info();

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            System.out.printf("Кот %s : %s%n", cats[i].getName(), cats[i].isSatiety());
        }

        plate.info();

    }
}
