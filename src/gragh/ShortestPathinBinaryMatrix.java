package gragh;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {

    static int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    static int row, col;

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        row = grid.length;
        col = grid[0].length;
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) return -1;
        grid[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty() && grid[row - 1][col - 1] == 0) {
            int[] tmp = queue.poll();
            for (int[] dire : directions) {
                int tmpRow = tmp[0] + dire[0];
                int tmpCol = tmp[1] + dire[1];
                if (isValid(tmpRow, tmpCol) && grid[tmpRow][tmpCol] == 0) {
                    grid[tmpRow][tmpCol] = grid[tmp[0]][tmp[1]] + 1;
                    queue.add(new int[]{tmpRow, tmpCol});
                }
            }
        }
        System.out.println(Arrays.deepToString(grid));
        return grid[row - 1][col - 1] == 0 ? -1 : grid[row - 1][col - 1];
    }

    public static boolean isValid(int x, int y) {
        return 0 <= x && x < row && 0 <= y && y < col;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {0,0,0},{1,1,0},{1,1,0}
        };
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
