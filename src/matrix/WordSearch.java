package matrix;

import java.util.Arrays;

public class WordSearch {
    int[][] dict = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m, n, len;
    char[][] board;
    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.len = word.length();
        this.board = board;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j] = true;
                    // System.out.println("i " + i + " j " + j);
                    if(dfs(word, visited, i, j, 1)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(String word, boolean[][] visited, int i, int j, int index) {
         System.out.println(Arrays.deepToString(visited));
        if (index == len) return true;
        for (int[] tmp : dict) {
            int x = i + tmp[0];
            int y = j + tmp[1];
             System.out.println("x " + x + " y " + y);
            if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && board[x][y] == word.charAt(index)) {
                visited[x][y] = true;
                if (dfs(word, visited, x, y, index + 1)) return true;
            }
        }
        visited[i][j]=false;
        return false;

    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        WordSearch word = new WordSearch();
        System.out.println(word.exist(board,"ABCCED"));
    }
}
