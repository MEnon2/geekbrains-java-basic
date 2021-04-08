package myTest;

public class test1 {
    public static void main(String[] args) {
        getArray(4, 4);
        getArray2(5, 8, 2);
    }

    static int[][] getArray(int n, int m) {
        int[][] array = new int[n][m];

        int new_j = 0;
        int k = 0;

        for (int i = 0; i < n; i++) {
            boolean p = i % 2 == 0;

            for (int j = 0; j < m; j++) {
                k++;
                if (p == true) {
                    new_j = j;
                } else {
                    new_j = m - 1 - j;
                }

                array[i][new_j] = k;
            }

        }

        System.out.println("");
        return array;
    }

    static int[][] fillNumber(int[][] array, int n, int m) {
        int sum = 2*m + 2*n - 4;
        int count = n;
        int spiral = 0;

        if (m > n) {
            count = m;
        }

        for (int i = spiral; i < n - spiral; i++) {
            for (int j = spiral; j < m - spiral; j++) {

                array[i][j] = sum * i + j;
                array[n - 1 - i][j] = (2 * (m-1) + (n-1)) - j;



            }
            spiral++;
        }
        return array;
    }

    static int[][] getArray2(int n, int m, int direction) {
        int[][] array = new int[n][m];

        int spiral = 0;

        int sum1 = 0;
        int sum2 = n + m - 2 * spiral - 2;
        int step1 = Math.round(n / 2) + n % 2;
        fillNumber(array, n, m);
/*
        for (int i = 0; i < step1; i++) {
            for (int j = 0; j < m - 2 * spiral; j++) {
                array[i][j + spiral] = sum1 + j;
                if (n - i > step1) {
                    array[n - 1 - i][m - 1 - j - spiral] = sum2 + j;
                }
                array[i][j + spiral] = sum1 + j;
            }
            sum1 = sum1 + (n + m - 4 * (spiral)) * 2 - 4;
            sum2 = sum1 + (n + m - 4 * (spiral + 1)) - 2;

            spiral++;
            System.out.println("");
        }
*/
        return array;

    }

}