package Backtraking;

public class Sudoku {
    public static void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean sudukuSolver(int[][] board, int row, int col) {
        // base case
        if (row == board.length) {
            print(board);
            return true;
        }

        // recursion step
        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (board[row][col] != 0) {
            return sudukuSolver(board, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(board, row, col, digit)) {
                board[row][col] = digit;
                if (sudukuSolver(board, nextRow, nextCol)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] board, int row, int col, int digit) {
        // row
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == digit) {
                return false;
            }
        }
        // col
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == digit) {
                return false;
            }
        }

        // box
        row = (row / 3) * 3;
        col = (col / 3) * 3;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] sudokuboard = { 
                { 0, 0, 4, 6, 0, 5, 8, 0, 0 },
                { 6, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 4, 7, 6, 0, 5 },
                { 2, 8, 0, 3, 0, 0, 0, 0, 0 },
                { 7, 4, 0, 0, 0, 8, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 9, 0, 0 },
                { 0, 2, 5, 7, 0, 0, 3, 6, 0 },
                { 4, 3, 0, 0, 2, 0, 0, 8, 0 },
                { 0, 0, 0, 8, 6, 3, 5, 4, 0 } };

        // print(sudokuboard);
        sudukuSolver(sudokuboard, 0, 0);

    }
}
