package gragh.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PathOfGraph {

    List<List<Integer>> res = new ArrayList<>();
    int[][] grid;
    int row, col;
    int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};

    public List<List<Integer>> findPath(int[][] grid) {
        if (grid == null || grid.length == 0) return res;
        this.grid = grid;
        this.row = grid.length;
        this.col = grid[0].length;
        boolean[][] isVisit = new boolean[row][col];
        isVisit[0][0] = true;
        List<Integer> tmpRes = new ArrayList<>();
        tmpRes.add(grid[0][0]);
        dfs(0, 0, isVisit, tmpRes);
        return res;
    }

    public void dfs(int r, int c, boolean[][] isVisit, List<Integer> tmpRes) {
        if (r == row - 1 && c == col - 1) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }

        for (int[] direction: directions) {
            int tmpRow = r + direction[0];
            int tmpCol = c + direction[1];
            if (isValid(tmpRow,tmpCol) && !isVisit[tmpRow][tmpCol]) {
                isVisit[tmpRow][tmpCol] = true;
                tmpRes.add(grid[tmpRow][tmpCol]);
                dfs(tmpRow, tmpCol, isVisit, tmpRes);
                isVisit[tmpRow][tmpCol] = false;
                tmpRes.remove(tmpRes.size() - 1);
            }
        }
    }

    public boolean isValid(int r, int c) {
        return r < row && r >= 0 && c < col && c >= 0;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {5, 4, 5},
                {1, 2, 6},
                {7, 4, 6}
        };

        PathOfGraph p = new PathOfGraph();
        System.out.println(p.findPath(input));
    }
}
// find path from 0,0 -> r - 1, c - 1