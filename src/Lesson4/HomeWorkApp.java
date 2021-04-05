package Lesson4;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HomeWorkApp {

    public static final int size = 3;

    public static final char charEmpty = '*';
    public static final char charX = 'X';
    public static final char charO = 'O';

    public static void main(String[] args) {
        char[][] map = initializeMap();
        printMap(map);
    }

    static char[][] initializeMap() {
        char[][] map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = charEmpty;
            }
        }
        return map;
    }

    static void printMap(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));

        }
    }

}
