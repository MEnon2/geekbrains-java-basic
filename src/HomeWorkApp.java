import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {
//    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        exercise1();
        exercise2();
        exercise3();
        exercise4();
        exercise5();

    }

    /*1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20
     (включительно), если да – вернуть true, в противном случае – false.
     */
    static void exercise1() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите число a:");
        int a = sc.nextInt();
        System.out.println("Введите число b:");
        int b = sc.nextInt();

        String denial = "";
        if (!checkSum(a, b)) {
            denial = "не ";
        }
        System.out.printf("Сумма чисел a и b %sлежит в пределах от 10 до 20 (включительно)%n", denial);
    }

    static boolean checkSum(int a, int b) {
        if (a + b >= 10 && a + b <= 20) {
            return true;
        }
        return false;
    }

    /*2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
     */
    static void exercise2() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите целое число:");
        int a = sc.nextInt();

        String result = "положительное";
        if (!checkNumber(a)) {
            result = "отрицательное";
        }
        System.out.println(String.format("Число %s", result));
    }

    static boolean checkNumber(int a) {
        if (a >= 0) {
            return true;
        }
        return false;
    }

    /*3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число
    отрицательное, и вернуть false если положительное.
     */
    static void exercise3() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите целое число:");
        int a = sc.nextInt();

        System.out.println(checkNegativeNumber(a));
    }

    static boolean checkNegativeNumber(int a) {
        if (a < 0) {
            return true;
        }
        return false;
    }

    /* 4. Написать метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль
    указанную строку, указанное количество раз;
     */
    static void exercise4() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите не пустую строку:");
        String str = sc.nextLine();

        Random rd = new Random();

        printString(str, rd.nextInt(10) + 1);
    }

    static void printString(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }

    }

    /*
    5. * Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true,
    не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    static void exercise5() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите год в формате YYYY:");
        int year = sc.nextInt();

        System.out.println(checkYear(year));
    }

    static boolean checkYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        }
        return false;
    }
}
