package gragh;

import java.util.Arrays;

public class SurroundedRegions {

    char[][] board;
    int row, col;
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        this.board = board;
        this.row = board.length;
        this.col = board[0].length;
        for (int r = 0; r < row; r++) {
            dfs(r,0);
            dfs(r, col - 1);
        }
        for (int c = 0; c < col; c++) {
            dfs(0,c);
            dfs(row - 1, c);
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c <  col; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                else if (board[r][c] == 'A') board[r][c] = 'O';
            }
        }
        return;
    }

    public void dfs(int r, int c) {
        if (isVaild(r,c)) {
            if ( board[r][c] == 'X' || board[r][c] == 'A') return;
            else {
                board[r][c] = 'A';
                for (int[] direction: directions) {
                    dfs(r + direction[0], c + direction[1]);
                }
            }
        }
        return;
    }

    public boolean isVaild(int r, int c) {
        return r >= 0 && r < row && c >= 0 && c < col;
    }

    public static void main(String[] args) {
        SurroundedRegions solve = new SurroundedRegions();
        char[][] input = new char[][] {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        solve.solve(input);
        System.out.println(Arrays.deepToString(input));
    }
}
//130. Surrounded Regions
//        Given an m x n matrix board containing 'X' and 'O', capture all regions surrounded by 'X'.
//
//        A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
//
//
//        Example 1:
//
//
//        Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
//        Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//        Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
//        Example 2:
//
//        Input: board = [["X"]]
//        Output: [["X"]]
//
//
//        Constraints:
//
//        m == board.length
//        n == board[i].length
//        1 <= m, n <= 200
//        board[i][j] is 'X' or 'O'.