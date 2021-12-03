import java.util.Random;
import java.util.Scanner;

public class GameOfLifeHomeProject {
    static int[][] tableMap;

    public static void setSize() {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        tableMap = new int[size + 2][size + 2];
    }

    public static void setStartingAlivePoints() {
        Random random = new Random();
        int howmanyalive = random.nextInt((tableMap.length - 2) * (tableMap.length) - 2) + 1;
        for (int i = 0; i < howmanyalive; i++) {
            int posX = random.nextInt(tableMap.length - 2) + 1;
            int posY = random.nextInt(tableMap.length - 2) + 1;
            tableMap[posX][posY] = 1;
        }
    }

    public static boolean isArrayEmpty() {
        boolean answer = true;
        for (int i = 1; i < tableMap.length - 1; i++) {
            for (int j = 1; j < tableMap.length - 1; j++) {
                if (tableMap[i][j] == 1) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }

    public static void updateGeneration() {
        for (int i = 1; i < tableMap.length - 1; i++) {
            for (int j = 1; j < tableMap.length - 1; j++) {
                System.out.print(tableMap[i][j]);
            }
            System.out.println();
        }
        while (!isArrayEmpty()) {
            System.out.println();
            int[][] arrayTemp = new int[tableMap.length][tableMap.length];
            for (int i = 1; i < tableMap.length - 1; i++) {
                for (int j = 1; j < tableMap.length - 1; j++) {
                    int sum = tableMap[i - 1][j - 1] + tableMap[i - 1][j] + tableMap[i - 1][j + 1] +
                            tableMap[i][j - 1] + tableMap[i][j + 1] + tableMap[i + 1][j - 1] +
                            tableMap[i + 1][j] + tableMap[i + 1][j + 1];
                    if (sum == 0 || sum == 1 || (sum == 2 && tableMap[i][j] == 0) || sum >= 4) {
                        arrayTemp[i][j] = 0;
                    } else {
                        arrayTemp[i][j] = 1;
                    }
                }
            }
            tableMap = arrayTemp;
            for (int i = 1; i < tableMap.length - 1; i++) {
                for (int j = 1; j < tableMap.length - 1; j++) {
                    System.out.print(tableMap[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        setSize();
        setStartingAlivePoints();
        updateGeneration();
    }
}

