package lesson7;

public class Plate {
    private int amountFood;

    public Plate() {
        this.amountFood = 0;
    }

    public void info() {
        System.out.printf("В тарелке %s еды%n", this.amountFood);
    }

    public void addFood(int amountFood) {
        this.amountFood = amountFood;
    }

    public boolean decreaseFood(int amount) {
        if (this.amountFood - amount >= 0) {
            this.amountFood -= amount;
            return true;
        }
        return false;
    }

}
