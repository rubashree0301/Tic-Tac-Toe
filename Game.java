import java.util.*;

public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    private Scanner scan;
    private int moveCount;

    public Game() {
        scan = new Scanner(System.in);

        player1 = new Player("Player 1", 'X');
        player2 = new Player("Player 2", 'O');

        currentPlayer = player1;
        board = new Board();
        moveCount = 0;
    }
    
    public void startGame() {
        while (true) {
            board.displayBoard();
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");

            System.out.print("Enter row (0 - 2) : ");
            int row = scan.nextInt();

            System.out.print("Enter column (0 - 2 ) : ");
            int col = scan.nextInt();

            if (!board.iscellEmpty(row, col)) {
                System.out.println("Cell is already filled. So try again");
                continue;
            }

            board.placeSymbol(row, col, currentPlayer.getSymbol());
            moveCount++;

            if (checkWin()) {
                board.displayBoard();
                System.out.println(currentPlayer.getName() + " " + "You are Winner!!");
                break;
            }

            if (moveCount == 9) {
                board.displayBoard();
                System.out.println("Game draw!!");
                break;
            }

            switchPlayer();
        }
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;

    }

    private boolean checkWin(){
        char[][] arr = board.getBoard();
        char temp = currentPlayer.getSymbol();

        // Row
        for (int i = 0; i < 3; i++) {
            if (arr[i][0] == temp && arr[i][1] == temp && arr[i][2] == temp) {
                return true;
            }
        }
        
        // Cloumn
        for (int i = 0; i < 3; i++) {
            if (arr[0][i] == temp && arr[1][i] == temp && arr[2][i] == temp) {
                return true;
            }
        }

        // Diagonals
        if (arr[0][0] == temp && arr[1][1] == temp && arr[2][2] == temp) {
            return true;
        }

        if (arr[0][2] == temp && arr[1][1] == temp && arr[2][0] == temp) {
            return true;
        }

        return false;

    }

}