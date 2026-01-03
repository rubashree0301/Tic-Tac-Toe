public class Board {

    private char[][] board;
    private final char Empty = '-';

    public Board() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Empty;
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j] + " "); // Space between cells
                if (j < 2)
                    System.out.print("|");
            }
            System.out.println();
        }
    }

    public boolean iscellEmpty(int row, int col) {
        return board[row][col] == Empty;
    }

    public void placeSymbol(int row, int col, char symbol) {
        board[row][col] = symbol;
    }
    
    public char[][] getBoard() {
        return board;
    }
}