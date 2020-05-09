package gragh;

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

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] input = new char[][] {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
//        char[][] input = new char[][] {
//                {'C', 'A', 'A'},
//                {'A', 'A', 'A'},
//                {'B', 'C', 'D'}
//        };
        String word = "ABCESEEEFS";
        System.out.println(wordSearch.exist(input, word));
    }
}
