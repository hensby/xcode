package gragh;

public class numberOfIslands {
    int length, height;
    char[][] grid;
    int count = 0;

    public int numIslands(char[][] grid) {
        this.height = grid.length;
        this.length = grid[0].length;
        this.grid = grid;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    public void dfs(int h, int l) {
        if (h > height || l > length || h < 0 || l < 0 || grid[h][l] == '0') {
            return;
        }
        grid[h][l] = '0';
        dfs(h, l + 1);
        dfs(h, l - 1);
        dfs(h - 1, l);
        dfs(h + 1, l);
    }
}

