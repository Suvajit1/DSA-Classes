package Backtraking;

public class NQueenPrintOneSolution {
    public static void print(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static boolean nQueenOneSloution(char[][] board, int row){
        // base case
        if(row == board.length){
            print(board);
            return true;
        }

        for(int j=0; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                if( nQueenOneSloution(board, row+1) ){
                    return true;
                }
                board[row][j] = 'X'; // back-track 
            }
        }

        return false;
    }

    public static boolean isSafe(char[][] board, int row, int col){
        // up
        for(int i=row-1; i>=0; i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        // left diagonal
        for(int i=row-1,j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        // right diagonal
        for(int i=row-1,j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = 'X';
            }
        }
        // print(board);

        nQueenOneSloution(board, 0);
    }
}
