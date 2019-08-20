package com.company;
import java.util.Scanner;

public class Board {
    char[][] board = new char[3][3];
    int numTurns = 0;
    boolean isWinner = false;
    Scanner sc = new Scanner(System.in);

    public void printBoard() {
        for (int i = 0; i <= 2; i++) {
            System.out.print(" ");
            for (int j = 0; j <= 2; j++) {
                if (board[i][j] != 0) {
                    System.out.print(board[i][j]);
                } else {
                    System.out.print(" ");
                }

                if (j != 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i != 2) {
                System.out.println("------------");
            }
        }
    }

    public void addMove(int x, int y, char player) {
        while (true) {
            if (board[x][y] == 0) {
                board[x][y] = player;
                break;
            } else {
                System.out.println("Sorry, that spot is already taken! Please try again.");
            }
        }
    }

    public boolean checkForWinner() {
        // Check for Horizontal Victories
        for (int i = 0; i <= 2; i++) {
            if ((board[i][0] != board[i][1]) && (board[i][0] != board[i][2]) // checks for win
                    && (board[i][0] != 0 && board[i][1] != 0 && board[i][2] != 0)) { //checks for null values
                return true;
            }
        }

        // Check for Horizontal Victories
        for (int i = 0; i <= 2; i++) {
            if ((board[0][i] == board[1][i] && board[0][i] == board[2][i])
                    && (board[0][i] != 0 && board[1][i] != 0 && board[2][i] != 0)) {
                isWinner = true;
                return true;
            }
        }

        // Check for Diagonal Victories
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] )
                    && (board[0][0] != 0 && board[1][1] != 0 && board[2][2] != 0)) {
            isWinner = true;
            return true;
        }

        if ((board[0][2] == board[1][1] && board[1][1] == board[2][0])
                    && (board[0][2] != 0 && board[1][1] != 0 && board[2][0] != 0)) {
            isWinner = true;
            return true;
        }

        return false;
    }

    public void turn(char player) {
        int x;
        int y;

        this.printBoard();

        System.out.print("Please input your X coordinate: ");
        x = sc.nextInt();

        System.out.print("Please input your Y coordinate: ");
        y = sc.nextInt();
        System.out.println();

        this.addMove(x, y, player);

        numTurns++;
    }

    public void play() {
        System.out.println("Welcome to TicTacToe!");
        System.out.println("I will be X, you will be O.");

        while (numTurns < 9) {
            // Determines which player's turn it is
            if (numTurns % 2 == 0) {
                turn('X');
            } else {
                turn('O');
            }

            // Determines if there is a winner
            if (this.checkForWinner()) {
                if (numTurns % 2 == 0) {
                    System.out.println("O is the winner!");
                } else {
                    System.out.println("X is the winner!");
                }
                break;
            }
        }
    }
}
