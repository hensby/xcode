package gragh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    int[][] heights;
    int row, col;
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();
        this.heights = heights;
        this.row = heights.length;
        this.col = heights[0].length;
        boolean[][] visitAtlantic = new boolean[row][col];
        boolean[][] visitPacific = new boolean[row][col];
        for (int c = 0; c < col; c++) {
            dfs(visitAtlantic, row - 1, c);
            dfs(visitPacific, 0, c);
        }
        for (int r = 0; r < row; r++) {
            dfs(visitAtlantic, r, col - 1);
            dfs(visitPacific, r, 0);
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (visitAtlantic[r][c] && visitPacific[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    public void dfs(boolean[][] isVisit, int r, int c) {
        if (!isVaild(r, c) || isVisit[r][c] == true) return;
        isVisit[r][c] = true;
        for (int[] direction: directions) {
            if (isVaild(r + direction[0], c + direction[1]) && heights[r][c] <= heights[r + direction[0]][c + direction[1]]) {
                dfs(isVisit, r + direction[0], c + direction[1]);
            }
        }
    }

    public boolean isVaild(int r, int c) {
        return r >= 0 && r < row && c >= 0 && c < col;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
        System.out.println(pacificAtlanticWaterFlow.pacificAtlantic(grid));
    }
}
//417. Pacific Atlantic Water Flow
//        There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
//
//        The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
//
//        The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
//
//        Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
//
//
//
//        Example 1:
//
//
//        Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//        Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
//        Example 2:
//
//        Input: heights = [[2,1],[1,2]]
//        Output: [[0,0],[0,1],[1,0],[1,1]]
//
//
//        Constraints:
//
//        m == heights.length
//        n == heights[r].length
//        1 <= m, n <= 200
//        0 <= heights[r][c] <= 105
