package Amazon_onsite;

public class NumberOfIslands {
    char[][] grid;
    int row, col;
    int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0, -1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        this.grid = grid;
        this.row = grid.length;
        this.col = grid[0].length;
        int res = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == '1') {
                    dfs(r,c);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(int r, int c) {
        if(grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for (int[] direction: directions) {
            int tmpR = r + direction[0];
            int tmpC = c + direction[1];
            if (isValid(tmpR,tmpC) && grid[tmpR][tmpC] == '1') {
                dfs(tmpR,tmpC);
            }
        }
        return;
    }
    public boolean isValid(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(grid));
    }
}

