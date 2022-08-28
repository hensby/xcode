package bfs_dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {

//    static int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
//    static int row, col;
//
//    public static int shortestPathBinaryMatrix(int[][] grid) {
//        if (grid == null || grid.length == 0) return -1;
//        row = grid.length;
//        col = grid[0].length;
//        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) return -1;
//        grid[0][0] = 1;
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{0, 0});
//        while (!queue.isEmpty() && grid[row - 1][col - 1] == 0) {
//            int[] tmp = queue.poll();
//            for (int[] dire : directions) {
//                int tmpRow = tmp[0] + dire[0];
//                int tmpCol = tmp[1] + dire[1];
//                if (isValid(tmpRow, tmpCol) && grid[tmpRow][tmpCol] == 0) {
//                    grid[tmpRow][tmpCol] = grid[tmp[0]][tmp[1]] + 1;
//                    queue.add(new int[]{tmpRow, tmpCol});
//                }
//            }
//        }
//        System.out.println(Arrays.deepToString(grid));
//        return grid[row - 1][col - 1] == 0 ? -1 : grid[row - 1][col - 1];
//    }
//
//    public static boolean isValid(int x, int y) {
//        return 0 <= x && x < row && 0 <= y && y < col;
//    }

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    int row, col;
    int[][] grid;

    public int shortestPathBinaryMatrix1(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return -1;
        this.row = grid.length;
        this.col = grid[0].length;
        this.grid = grid;
        Queue<int[]> queue = new LinkedList<>();
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) return -1;
        queue.add(new int[]{0, 0});
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            while (size > 0) {
                int[] current = queue.poll();
                if (current[0] == row - 1 && current[1] == col - 1) return level;
                for (int[] dire : directions) {
                    int nextRow = current[0] + dire[0];
                    int nextCol = current[1] + dire[1];
                    if (isValid1(nextRow, nextCol)) {
                        queue.add(new int[]{nextRow, nextCol});
                    }
                }
                size--;
            }
        }
        return -1;
    }

    public boolean isValid1(int r, int c) {
        return r >= 0 && r < row && c >= 0 && c < col && grid[r][c] == 0;
    }


    public static int shortestPathBinaryMatrix2(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int row = grid.length;
        int col = grid[0].length;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                if (current[0] == row - 1 && current[1] == col - 1) {
                    return level;
                } else if (grid[current[0]][current[1]] == 1) {
                    continue;
                } else {
                    for (int[] direction : directions) {
                        int currentRow = current[0] + direction[0];
                        int currentCol = current[1] + direction[1];
                        if (currentRow >= 0 && currentRow < row && currentCol >= 0 && currentCol < col && grid[currentRow][currentCol] == 0) {
                            queue.add(new int[]{currentRow, currentCol});
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 0, 0}, {1, 1, 0}, {1, 1, 0}
        };
        int[][] grid1 = new int[][]{
                {0, 1}, {1, 0}
        };
        System.out.println(shortestPathBinaryMatrix2(grid));
    }
}

//{0,0,0},
//{1,1,0},
//{1,1,0}
