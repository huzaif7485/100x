import java.util.*;

public class nqueen {

    public static boolean isSafe(int row, int col, char[][] board) {
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q')
                return false;
        }
        int r = row;
        for (int c = col; c >= 0 && r >= 0; c--, r--) {
            if (board[r][c] == 'Q')
                return false;
        }

        r = row;
        for (int c = col; c <board.length && r >= 0; r--, c++) {
            if (board[r][c] == 'Q')
                return false;
        }

        r = row;
        for (int c = col; c >= 0 && r < board.length; r++, c--) {
            if (board[r][c] == 'Q')
                return false;
        }

        r = row;
        for (int c = col; c < board.length && r < board.length; c++, r++) {
            if (board[r][c] == 'Q')
                return false;
        }

        return true;
    }

    public static void saveBoard(char[][] board, List<List<String>> allBoards) {
        String row = "";

        List<String> newBoard = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            row = "";
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q')
                    row += 'Q';
                else
                    row += '.';
            }
            newBoard.add(row);
        }

        allBoards.add(newBoard);
    }

    public static void solve(char[][] board, List<List<String>> allBoards, int col) {
        if (col == board.length) {
            saveBoard(board, allBoards);
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                solve(board, allBoards, col + 1);
            }
            board[row][col] = '.';
        }
    }

    public static void solution(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        solve (board, allBoards, 0);

        for (List<String> b : allBoards) {
            for (int i = 0; i < b.size(); i++) {
                System.out.println(b.get(i));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solution(4);
    }
}
