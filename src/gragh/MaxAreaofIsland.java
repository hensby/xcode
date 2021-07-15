package gragh;

public class MaxAreaofIsland {

    int[][] grid;
    int row, col;
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        this.grid = grid;
        this.row = grid.length;
        this.col = grid[0].length;
        int maxArea = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                maxArea = Math.max(maxArea, dfs(r,c));
            }
        }
        return maxArea;
    }
    public int dfs (int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col || grid[r][c] == 0) {
            return 0;
        }
        int ans = 1;
        grid[r][c] = 0;
        for (int[] direct: directions) {
            ans += dfs(direct[0] + r, direct[1] + c);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        MaxAreaofIsland map = new MaxAreaofIsland();
        System.out.println(map.maxAreaOfIsland(grid));

    }
}
//695. Max Area of Island
//        You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
//
//        The area of an island is the number of cells with a value 1 in the island.
//
//        Return the maximum area of an island in grid. If there is no island, return 0.
//
//
//
//        Example 1:
//
//
//        Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//        Output: 6
//        Explanation: The answer is not 11, because the island must be connected 4-directionally.
//        Example 2:
//
//        Input: grid = [[0,0,0,0,0,0,0,0]]
//        Output: 0
//
//
//        Constraints:
//
//        m == grid.length
//        n == grid[i].length
//        1 <= m, n <= 50
//        grid[i][j] is either 0 or 1.
