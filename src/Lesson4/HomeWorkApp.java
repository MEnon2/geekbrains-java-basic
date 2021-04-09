package Lesson4;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class HomeWorkApp {

    public static final int size = 5;
    public static final int countPlayer = 2;
    public static final int countForWin = 4;

    public static final char charEmpty = '*';
    public static final char[] charsPlayers = {'X', 'O'};
    public static int[] result;

    public static void main(String[] args) {

        doStart();

    }

    static void doStart() {

        out.println("Начинаем игру!");
        char[][] map = initializeMap();

        result = new int[5];

        out.println("Общее количество игроков: " + countPlayer);

        int countPeople;
        Scanner sc = new Scanner(System.in);
        do {
            out.printf("Введите сколько человек будет играть [1...%s]%n", countPlayer);
            countPeople = sc.nextInt();
        } while (countPeople < 1 || countPeople > countPlayer);

        doBegin(map, countPeople);

    }

    static void doBegin(char[][] map, int countPeople) {
        boolean stopGame;

        do {
            int player = 1;
            do {
                doPlayerMove(map, player);
                calculateCountSign(map);
                stopGame = isDraw(map) || isWin(map, player);
                player++;
            } while (player <= countPeople && !stopGame);

            while (player <= countPlayer && !stopGame) {
                doAIMove(map, player);
                calculateCountSign(map);
                stopGame = isDraw(map) || isWin(map, player);
                player++;
            }
            if (stopGame) {
                break;
            }
        } while (true);
    }

    static char[][] initializeMap() {
        char[][] map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = charEmpty;
            }
        }
        printMap(map);
        return map;
    }

    static void doAIMove(char[][] map, int player) {
        out.printf("Ход игрока %s (компьютер)%n", player);
        int row = 0, col = 0;

        if (result[0] == 0) {
            row = result[1];
            for (int i = 0; i < size; i++) {
                if (isSign(map, row, i + result[2], charEmpty)) {
                    col = i + result[2];
                    break;
                }
            }
        } else if (result[0] == 1) {
            col = result[1];
            for (int i = 0; i < size; i++) {
                if (isSign(map, i + result[2], col, charEmpty)) {
                    row = i + result[2];
                    break;
                }
            }
        } else if (result[0] == 2) {
            for (int i = 0; i < countForWin; i++) {
                if (isSign(map, i + result[1], i + result[2], charEmpty)) {
                    row = i + result[1];
                    col = i + result[2];
                    break;
                }
            }
        } else if (result[0] == 3) {
            for (int i = 0; i < countForWin; i++) {
                if (isSign(map, i + result[1], size - 1 - (i + result[2]), charEmpty)) {
                    row = i + result[1];
                    col = size - 1 - (i + result[2]);
                    break;
                }
            }

        }

        map[row][col] = charsPlayers[player - 1];
        printMap(map);

    }

    static void doPlayerMove(char[][] map, int player) {
        out.printf("Ход игрока %s (человек)%n", player);
        int row, col;
        do {
            row = getCoordinate("строки");
            col = getCoordinate("колонки");
        } while (!isSign(map, row, col, charEmpty));

        map[row][col] = charsPlayers[player - 1];
        printMap(map);
    }

    static int getCoordinate(String coordType) {
        int coordinate;
        Scanner sc = new Scanner(System.in);
        do {
            out.printf("Введите номер %s в диапазоне [1...%s]%n", coordType, size);
            coordinate = sc.nextInt() - 1;
        } while (coordinate < 0 || coordinate >= size);

        return coordinate;
    }

    static void printMap(char[][] map) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                out.print(map[i][j] + " ");
            }
            out.println();
        }
        out.println();
    }

    static boolean isSign(char[][] map, int row, int col, char sign) {
        return map[row][col] == sign;
    }

    static boolean isDraw(char[][] map) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isSign(map, i, j, charEmpty)) {
                    return false;
                }
            }
        }
        out.println("Ничья");
        return true;
    }

    static boolean isWin(char[][] map, int player) {
        if (result[3] == countForWin) {
            out.printf("Выиграл игрок <%s>%n", player);
            return true;
        }

        return false;
    }

    static void calculateCountSign(char[][] map) {
        result = new int[5];
        int[] resultСomparison = new int[5];

        for (int k = 0; k < charsPlayers.length; k++) {
            resultСomparison = checkHorizontallyVertical(map, 0, k + 1);
            if (resultСomparison[3] > result[3]) {
                result = resultСomparison;
            }
            resultСomparison = checkHorizontallyVertical(map, 1, k + 1);
            if (resultСomparison[3] > result[3]) {
                result = resultСomparison;
            }
            resultСomparison = checkDiagonally(map, 2, k + 1);
            if (resultСomparison[3] > result[3]) {
                result = resultСomparison;
            }
            resultСomparison = checkDiagonally(map, 3, k + 1);
            if (resultСomparison[3] > result[3]) {
                result = resultСomparison;
            }
        }
    }

    static int[] checkDiagonally(char[][] arr, int typeMax, int player) {
        int max = 0, countCharPlayer = 0, countCharEmpty = 0;
        char sign = charsPlayers[player - 1];
        int[] resultСomparison = new int[5];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                countCharPlayer = 0;
                countCharEmpty = 0;
                for (int s = 0; s < countForWin; s++) {
                    if (typeMax == 2 && s + i < size && s + j < size) {
                        if (isSign(arr, s + i, s + j, sign)) {
                            countCharPlayer++;
                        } else if (isSign(arr, s + i, s + j, charEmpty)) {
                            countCharEmpty++;
                        } else {
                            break;
                        }
                    }

                    if (typeMax == 3 && s + i < size && s + j < size) {
                        if (isSign(arr, s + i, size - 1 - (s + j), sign)) {
                            countCharPlayer++;
                        } else if (isSign(arr, s + i, size - 1 - (s + j), charEmpty)) {
                            countCharEmpty++;
                        } else {
                            break;
                        }
                    }

                }

                if (countCharPlayer > max && countCharPlayer > 0 && countCharPlayer + countCharEmpty == countForWin) {
                    max = countCharPlayer;
                    resultСomparison[0] = typeMax;
                    resultСomparison[1] = i;
                    resultСomparison[2] = j;
                    resultСomparison[3] = max;
                    resultСomparison[4] = player;
                }
            }
        }


/*
        for (int s = 0; s < 2; s++) {
            countCharPlayer = 0;
            countCharEmpty = 0;

            for (int i = 0; i < countForWin; i++) {
                if (typeMax == 2) {
                    if (isSign(arr, i + s, i + s, sign)) {
                        countCharPlayer++;
                    } else if (isSign(arr, i + s, i + s, charEmpty)) {
                        countCharEmpty++;
                    } else {
                        break;
                    }
                }
                if (typeMax == 3) {
                    if (isSign(arr, i + s, size - 1 - i - s, sign)) {
                        countCharPlayer++;
                    } else if (isSign(arr, i + s, size - 1 - i - s, charEmpty)) {
                        countCharEmpty++;
                    } else {
                        break;
                    }
                }
            }

            if (countCharPlayer > max && countCharPlayer > 0 && countCharPlayer + countCharEmpty == countForWin) {
                max = countCharPlayer;
                resultСomparison[0] = typeMax;
                resultСomparison[1] = 0;
                resultСomparison[3] = max;
                resultСomparison[4] = player;
            }
        }
*/
        return resultСomparison;
    }

    static int[] checkHorizontallyVertical(char[][] arr, int typeMax, int player) {
        int max = 0;
        int countCharPlayer = 0, countCharEmpty = 0;
        char sign = charsPlayers[player - 1];
        int[] resultСomparison = new int[5];

        for (int i = 0; i < size; i++) {
            for (int s = 0; s < 2; s++) {
                countCharPlayer = 0;
                countCharEmpty = 0;

                for (int j = 0; j < countForWin; j++) {
                    if (typeMax == 0) {
                        if (isSign(arr, i, j + s, sign)) {
                            countCharPlayer++;
                        } else if (isSign(arr, i, j + s, charEmpty)) {
                            countCharEmpty++;
                        } else {
                            break;
                        }
                    } else if (typeMax == 1) {
                        if (isSign(arr, j + s, i, sign)) {
                            countCharPlayer++;
                        } else if (isSign(arr, j + s, i, charEmpty)) {
                            countCharEmpty++;
                        } else {
                            break;
                        }
                    }
                }

                if (countCharPlayer > max && countCharPlayer > 0 && countCharPlayer + countCharEmpty == countForWin) {
                    max = countCharPlayer;
                    resultСomparison[0] = typeMax;
                    resultСomparison[1] = i;
                    resultСomparison[2] = s;
                    resultСomparison[3] = max;
                    resultСomparison[4] = player;
                }

            }
        }


        return resultСomparison;
    }

}

