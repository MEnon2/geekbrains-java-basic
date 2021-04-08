package Lesson1;

public class HomeWorkApp {

    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();

    }


    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    static void checkSumSign() {
        int a = 5;
        int b = -7;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная: " + sum);
        } else {
            System.out.println("Сумма отрицательная: " + sum);
        }
    }

    static void printColor() {
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    static void compareNumbers() {
        int a = 30;
        int b = 20;

        if(a>=b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }


}