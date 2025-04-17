import java.util.Scanner;

public class TicTacToe {

    private static boolean isGameEnd = true;
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)  {

        System.out.println("Welcome To Tic Toe");
        System.out.println("1. Start \n2. Exit");
        
        System.out.print("Enter a number: ");
        int input = sc.nextInt();

        if (input == 1) {
            gameBoard();

        } else if (input == 2) {
            System.out.println("Exit");

        } else {
            System.out.println("Close");

        }

    }

    public static void gameBoard() {
        
        System.out.println("Starting Game...");
       
        char [][] board = new char[3][3];

        for (int i = 0; i<board.length; i++) {  
            for(int j = 0; j<board[i].length; j++) { 
                board[i][j] = ' ';
            }
        }
        displayBoard(board);
        gameTurn(board);
    }

    public static void gameTurn(char [][] board) {   
        int turn = 1;

        while (isGameEnd) {
            System.out.println("Turn " + turn);
            
            if (turn % 2 == 0) {
                System.out.println("Player X");

                System.out.print("Enter a row (0-2): ");
                int inputRow = sc.nextInt();
    
                System.out.println();

                System.out.print("Enter a column (0-2): ");
                int inputColumn = sc.nextInt();

                char inputX = 'X';

                if (inputRow >= 0 && inputRow < 3 && inputColumn >= 0 && inputColumn < 3 && board[inputRow][inputColumn] == ' ') {
                    boardUpdate(board, inputRow, inputColumn, inputX);
                    displayBoard(board);
                    playerWin(board, inputX);
                    
                } else {
                    System.out.println("Invalid input or space already occupied. Try again.");
                    displayBoard(board);
                }

            } else if (turn % 2 != 0) {
                System.out.println("Player O");

                System.out.print("Enter a row (0-2): ");
                int inputRow = sc.nextInt();

                System.out.println();

                System.out.print("Enter a column (0-2): ");
                int inputColumn = sc.nextInt();

                char inputO = 'O';

                if (inputRow >= 0 && inputRow < 3 && inputColumn >= 0 && inputColumn < 3 && board[inputRow][inputColumn] == ' ') {
                    boardUpdate(board, inputRow, inputColumn, inputO);
                    displayBoard(board);
                    playerWin(board, inputO);

                } else {
                    System.out.println("Invalid input or cell already occupied. Try again.");
                    displayBoard(board);
                }
            }     

            turn++;
        }
    }

    public static void boardUpdate(char[][] board, int inputRow, int inputColumn, char input) {
        board[inputRow][inputColumn] = input; // Update the board
    }

    public static void displayBoard(char[][] board) {
        System.out.println("Current Board:");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j < board[i].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < board.length - 1) {
                System.out.println("-----");
            }
        }
    }

    public static void playerWin(char[][] board, char input) {

        for (int row = 0; row <=2; row++) {
            if (board[row][0] == input && board[row][1] == input && board[row][2] == input) {
                System.out.println("Player " + input + " wins!");
                isGameEnd = false;
            }
        }

        for (int col = 0; col <=2; col++) {
            if (board[0][col] == input && board[1][col] == input && board[2][col] == input) {
                System.out.println("Player " + input + " wins!");
                isGameEnd = false;
            }
        }

        if (board[0][0] == input && board[1][1] == input && board[2][2] == input) {
            System.out.println("Player " + input + " wins!");
            isGameEnd = false;
        }
        if (board[0][2] == input && board[1][1] == input && board[2][0] == input) {
            System.out.println("Player " + input + " wins!");
            isGameEnd = false;
        }
    }
}