public class HuaweiOnsite {
    // m, n
    // 左上-》 右下
    int max, m, n;
    int[][] grid;
    int[][] directions = new int[][] { {1, 0}, {0, 1}};
    boolean[][] visited;
    public int getMaxPathLength(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        this.max = grid[0][0];
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.visited = new boolean[m][n];
        //visited[0][0] = true;
        bfs(0, 0, grid[0][0]);
        return max;
    }

    public void bfs(int x, int y, int sum) {
        if(x == n - 1 && y == n - 1) {
            max = Math.max(max, sum);
            return;
        }
        visited[x][y] = true;
        for(int[] direction: directions) {
            int tmpX = x + direction[0];
            int tmpY = y + direction[1];
            if(isValid(tmpX, tmpY) && !visited[tmpX][tmpY]) {
                bfs(tmpX, tmpY, sum + grid[tmpX][tmpY]);
            }
        }
        visited[x][y] = false;
    }

    public boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

//    public static void main(String[] args) {
//        HuaweiOnsite h = new HuaweiOnsite();
//        int[][] input = new int[][] { {1,2,3}, {3,4,2}, {2,3,4}};
//        System.out.println(h.getMaxPathLength(input));
//    }
}
