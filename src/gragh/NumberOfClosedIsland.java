package gragh;

public class NumberOfClosedIsland {
    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    res += (isIsLand(grid, i, j) ? 1 : 0);
                }
            }
        }
        return res;
    }

    private boolean isIsLand(int[][] grid, int si, int sj) {
        if (si < 0 || si >= grid.length || sj < 0 || sj >= grid[0].length) {
            return false;
        }
        if (grid[si][sj] == 1 || grid[si][sj] == 2) {
            return true;
        }
        grid[si][sj] = 2;
        boolean bool1 = isIsLand(grid, si-1, sj);
        boolean bool2 = isIsLand(grid, si, sj-1);
        boolean bool3 = isIsLand(grid, si+1, sj);
        boolean bool4 = isIsLand(grid, si, sj+1);
        return bool1 && bool2 && bool3 && bool4;
    }

    public static void main(String[] args) {
        NumberOfClosedIsland N = new NumberOfClosedIsland();
        int[][] grid = new int[][] {
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}
        };
        System.out.println(N.closedIsland(grid));
    }
}

