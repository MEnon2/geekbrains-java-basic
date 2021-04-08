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

        result = new int[4];

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
                stopGame = isDraw(map) || isWin(map, player);
                player++;
            } while (player <= countPeople && !stopGame);

            while (player <= countPlayer && !stopGame) {
                doAIMove(map, player);
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
        int row, col;
        Random rd = new Random();
        do {
            row = rd.nextInt(size);
            col = rd.nextInt(size);
        } while (!isSign(map, row, col, charEmpty));

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


        calculateCountSign(map);

        if (result[2] == countForWin) {
            out.printf("Выиграл игрок <%s>%n", player);
            return true;
        }

        return false;
    }

    static boolean checkWin(int countWinHorizontally, int countWinVertical, int countWinDiagonally, int countWinOppositeDiagonally) {
        return countWinHorizontally == countForWin || countWinVertical == countForWin || countWinDiagonally == countForWin || countWinOppositeDiagonally == countForWin;
    }

    static void calculateCountSign(char[][] map) {


        int countWinHorizontally = 0, countWinVertical = 0, countWinDiagonally = 0, countWinOppositeDiagonally = 0, countCharEmpty = 0;

        int typeMax = 0; //[0 - горизонтальный, 1 - вертикальный, 2 - диаганаль, 3 - обратная диаганаль]
        int max = 0, numberRowCol = 0, player = 0;

        for (int k = 0; k < charsPlayers.length; k++) {
            char sign = charsPlayers[k];

            for (int i = 0; i < size; i++) {
                for (int s = 0; s < 2; s++) {
                    countWinHorizontally = 0;
                    countCharEmpty = 0;
                    for (int j = 0; j < countForWin; j++) {
                        if (isSign(map, i, j + s, sign)) {
                            countWinHorizontally++;
                        } else if (isSign(map, i, j + s, charEmpty)) {
                            countCharEmpty++;
                        } else {
                            break;
                        }
                    }

                    if (countWinHorizontally > max && countWinHorizontally > 0 && countWinHorizontally + countCharEmpty == countForWin) {
                        max = countWinHorizontally;
                        typeMax = 0;
                        numberRowCol = i;
                        player = k + 1;
                    }

                }
            }

            for (int i = 0; i < size; i++) {
                for (int s = 0; s < 2; s++) {
                    countWinVertical = 0;
                    countCharEmpty = 0;
                    for (int j = 0; j < countForWin; j++) {
                        if (isSign(map, j + s, i, sign)) {
                            countWinVertical++;
                        } else if (isSign(map, j + s, i, charEmpty)) {
                            countCharEmpty++;
                        } else {
                            break;
                        }
                    }
                    if (countWinVertical > max && countWinVertical > 0 && countWinVertical + countCharEmpty == countForWin) {
                        max = countWinVertical;
                        typeMax = 1;
                        numberRowCol = i;
                        player = k + 1;
                    }
                }
            }

            for (int s = 0; s < 2; s++) {
                countWinDiagonally = 0;
                countCharEmpty = 0;

                for (int i = 0; i < countForWin; i++) {
                    if (isSign(map, i + s, i, sign)) {
                        countWinDiagonally++;
                    } else if (isSign(map, i + s, i, charEmpty)) {
                        countCharEmpty++;
                    } else {
                        break;
                    }
                }
                if (countWinDiagonally > max && countWinDiagonally > 0 && countWinDiagonally + countCharEmpty == countForWin) {
                    max = countWinDiagonally;
                    typeMax = 2;
                    numberRowCol = 0;
                    player = k + 1;
                }

                countWinOppositeDiagonally = 0;
                countCharEmpty = 0;

                for (int i = 0; i < countForWin; i++) {
                    if (isSign(map,i + s , size - 1 - i, sign)) {
                        countWinOppositeDiagonally++;
                    } else if (isSign(map,i + s , size - 1 - i, charEmpty)) {
                        countCharEmpty++;
                    } else {
                        break;
                    }
                }
                if (countWinOppositeDiagonally > max && countWinOppositeDiagonally > 0 && countWinOppositeDiagonally + countCharEmpty == countForWin) {
                    max = countWinOppositeDiagonally;
                    typeMax = 3;
                    numberRowCol = 0;
                    player = k + 1;
                }

            }

        }

        result[0] = typeMax;
        result[1] = numberRowCol;
        result[2] = max;
        result[3] = player;

    }
}

