package crosszero;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    final char SIGN_X = 'x';
    final char SIGN_O = 'o';
    final char SIGN_EMPTY = '.';
    char[][] table;
    Random random;
    Scanner scanner;

    public TicTacToe() {
        random = new Random();
        scanner = new Scanner(System.in);
        table = new char[3][3];
    }

    // заполнение поля постыми символами "."
    public void initTable() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                table[row][col] = SIGN_EMPTY;
    }

    public void game() {
        initTable();
        while (true) {
            moveHuman();
            if (checkWin(SIGN_X)) {
                System.out.println("Victory!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Defeat.");
                break;
            }
            moveAI();
            printTable();
            if (checkWin(SIGN_O)) {
                System.out.println("Defeat.");
                break;
            }
            if (isTableFull()) {
                System.out.println("Victory!");
                break;
            }
        }
        System.out.println("Game over.");
        printTable();
    }

    public void printTable() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++)
                System.out.print(table[row][col] + " ");
            System.out.println();
        }
    }

    public void moveHuman() {
        int x, y;
        do {
            System.out.println("Enter X and Y (1..3):");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_X;
    }

    public boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3|| y >= 3)
            return false;
        return table[y][x] == SIGN_EMPTY;
    }

    public void moveAI() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_O;
    }

    public boolean checkWin(char dot) {
        for (int i = 0; i < 3; i++)
            if ((table[i][0] == dot && table[i][1] == dot &&
                    table[i][2] == dot) ||
                    (table[0][i] == dot && table[1][i] == dot &&
                            table[2][i] == dot))
                return true;
        if ((table[0][0] == dot && table[1][1] == dot &&
                table[2][2] == dot) ||
                (table[2][0] == dot && table[1][1] == dot &&
                        table[0][2] == dot))
            return true;
        return false;
    }

    public boolean isTableFull() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (table[row][col] == SIGN_EMPTY)
                    return false;
        return true;
    }
}
