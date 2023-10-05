package tictactoe;

import java.util.Scanner;public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize an empty 3x3 board
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        printBoard(board);

        char currentPlayer = 'X';

        // Main game loop
        while (true) {
            // Player's Turn
            int x, y;
            while (true) {
                System.out.print("Enter the coordinates: ");
                try {
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                } catch (Exception e) {
                    scanner.nextLine(); // Clear the input buffer
                    System.out.println("You should enter numbers!");
                    continue;
                }

                if (x < 1 || x > 3 || y < 1 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (board[x - 1][y - 1] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    break;
                }
            }

            // Make a move
            board[x - 1][y - 1] = currentPlayer;
            printBoard(board);

            // Check game state
            if (checkWin(board, currentPlayer)) {
                System.out.println(currentPlayer + " wins");
                break;
            } else if (isBoardFull(board)) {
                System.out.println("Draw");
                break;
            }

            // Switch player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;

        return false;
    }

    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}