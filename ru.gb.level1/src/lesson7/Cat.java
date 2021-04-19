package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int Appetite) {
        this.name = name;
        this.appetite = Appetite;
        this.satiety = false;
    }

    public void eat(Plate plate) {
        this.satiety = plate.decreaseFood(this.appetite);
    }

    public String isSatiety() {
        if (satiety) {
            return "сыт";
        } else {
            return "голоден";
        }
    }

    public String getName() {
        return name;
    }
}
