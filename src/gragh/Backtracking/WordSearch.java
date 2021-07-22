package gragh.Backtracking;

import java.util.Arrays;

public class WordSearch {

    int[][] dict = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length, len = word.length();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j] = true;
                    System.out.println("i " + i + " j " + j);
                    if(dfs(board, word, visited, i, j, 1)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int index) {

        System.out.println(Arrays.deepToString(visited));
        int m = board.length, n = board[0].length, len = word.length();
        if (index == len) return true;
        for (int[] tmp : dict) {
            int x = i + tmp[0];
            int y = j + tmp[1];
            System.out.println("x " + x + " y " + y);
            if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && board[x][y] == word.charAt(index)) {
                visited[x][y] = true;
                if (dfs(board, word, visited, x, y, index + 1)) return true;
            }
        }
        visited[i][j]=false;
        return false;
    }


    char[][] board;
    int row, col;
    String word;
    int[][] directions = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public boolean exist1(char[][] board, String word) {
        if (word == null || word.equals("")) return true;
        if (board == null || board.length == 0) return false;

        this.board = board;
        this.row = board.length;
        this.col = board[0].length;
        this.word = word;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == word.charAt(0)) {
                    boolean[][] isVisit = new boolean[row][col];
                    isVisit[r][c] = true;
                    if (dfs1(r,c,isVisit,1)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs1(int r, int c, boolean[][] isVisit, int index) {
        System.out.println("x " + r + " y " + c);

        if (index == word.length()) return true;
        for(int[] direction: directions) {
            int tmpRow = r + direction[0];
            int tmpCol = c + direction[1];

            if (isValid(tmpRow,tmpCol) && !isVisit[tmpRow][tmpCol] && board[tmpRow][tmpCol] == word.charAt(index)) {
                isVisit[tmpRow][tmpCol] = true;
                if (dfs1(tmpRow, tmpCol, isVisit, index + 1)) return true;
                isVisit[tmpRow][tmpCol] = false;
            }
        }
        return false;
    }

    public boolean isValid(int r, int c) {
        return r >= 0 && r < row && c >= 0 && c < col;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] input = new char[][] {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
//        char[][] input = new char[][] {
//                {'C', 'A', 'A'},
//                {'A', 'A', 'A'},
//                {'B', 'C', 'D'}
//        };
        String word = "ABCCED";
        System.out.println(wordSearch.exist1(input, word));
    }
}
