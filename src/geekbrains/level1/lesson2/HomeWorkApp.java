package geekbrains.level1.lesson2;

public class HomeWorkApp {

    public static void main(String[] args) {

        exercises1();
        exercises2();
        exercises3();
        exercises4();
        exercises5();
        exercises6();
        exercises7();
        exercises8();
    }

    /*
    1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0;
    */
    static void exercises1() {
        int array[] = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");

            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
            System.out.println(array[i]);
        }
    }

    /*
    2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
    */
    static void exercises2() {
        int array[] = new int[100];

        for (int i = 1; i <= array.length; i++) {
            array[i - 1] = i;
        }
    }

    /*
    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    */
    static void exercises3() {
        int array[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
            System.out.print(array[i] + " ");
        }
    }

    /*
    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
     заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно). Определить
     элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1],
     [2][2], …, [n][n];
     */
    static void exercises4() {
        int n = 5;
        int array[][] = new int[n][n];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || j == array[i].length - 1 - i) {
                    array[i][j] = 1;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }

    }

    /*
    5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int
    длиной len, каждая ячейка которого равна initialValue;
     */
    static int[] getaArray(int len, int initialValue) {
        int array[] = new int[len];

        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }

        return array;
    }

    static void exercises5() {
        int[] array = getaArray(10, 5);
    }

    /*
    6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы;
    */
    static void exercises6() {
        int array[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 18, 9, 1};

        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("min: " + min + ", max: " + max);
    }

    /*
    7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    если в массиве есть место, в котором сумма левой и правой части массива равны.
    */

    static boolean checkBalance(int[] array) {
        int sumL;
        int sumR;

        for (int i = 0; i < array.length - 1; i++) {
            sumL = 0;
            sumR = 0;

            for (int j = 0; j <= i; j++) {
                sumL = sumL + array[j];
            }

            for (int j = i + 1; j < array.length; j++) {
                sumR = sumR + array[j];
            }

            if (sumL == sumR) {
                return true;
            }
        }
        return false;
    }

    static void exercises7() {
        boolean result;

        result = checkBalance(new int[]{1, 1, 1, 2, 1});
        System.out.println("result: " + result);

        result = checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 1});
        System.out.println("result: " + result);

        result = checkBalance(new int[]{3, 5, 1, 7, 3});
        System.out.println("result: " + result);

    }

    /*
    8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи
    нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
    */

    static int[] changeArray(int[] arr, int n) {
        int a = 0;
        int b = 0;
        int offsetArray = Math.abs(n % arr.length);

        if (n < 0) {
            offsetArray = arr.length - offsetArray;
        }

        for (int i = 0; i < offsetArray; i++) {
            b = arr[arr.length - 1];
            for (int j = 0; j < arr.length; j++) {
                a = arr[j];
                arr[j] = b;
                b = a;
            }
        }
        return arr;
    }

    static void exercises8() {
        int[] arrray = changeArray(new int[]{3, 5, 6, 1, 7, 2}, -1);
        System.out.println("");
    }

}
