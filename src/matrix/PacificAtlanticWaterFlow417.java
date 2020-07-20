package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static matrix.PrintMatrix.printMatrix;

public class PacificAtlanticWaterFlow417 {
    private final int[][] d = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    private int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        m = matrix.length;
        n = matrix[0].length;
        // 太平洋
        int[][] pacific = new int[m][n];
        // 大西洋
        int[][] atlantic = new int[m][n];

        // 递归遍历四个边界，并存放到对应的数组中
        for (int i = 0; i < n; i++) {
            // 上边界
            dfs(matrix, 0, i, pacific);
            // 下边界
            dfs(matrix, m - 1, i, atlantic);
        }
        for (int i = 0; i < m; i++) {
            // 左边界
            dfs(matrix, i, 0, pacific);
            // 右边界
            dfs(matrix, i, n - 1, atlantic);
        }

        // 最后遍历完所有边界值，将选出的目标坐标放入 ans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] matrix, int x, int y, int[][] tmp) {
        tmp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            // 这里使用 或 的形式，如果是 与 的形式会少解 [1,4]
            if (!legal(newX, newY) || matrix[x][y] > matrix[newX][newY] || tmp[newX][newY] == 1) {
                continue;
            }
            dfs(matrix, newX, newY, tmp);
        }
    }

    private boolean legal(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        PacificAtlanticWaterFlow417 p = new PacificAtlanticWaterFlow417();
        System.out.println(p.pacificAtlantic(input));
    }

}
