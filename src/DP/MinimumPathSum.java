package DP;

import java.util.Arrays;
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
//        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (i != 0 && j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        for (int[] a : grid) {
            System.out.println(Arrays.toString(a));
        }
        return grid[m - 1][n - 1];
    }

    public int minPathSum1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
//        int[][] count = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0 && j != 0) {
                    matrix[i][j] = matrix[i][j] + matrix[i][j - 1];
                } else if (i != 0 && j == 0) {
                    matrix[i][j] = matrix[i][j] + matrix[i - 1][j];
                } else {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i - 1][j] , matrix[i][j - 1]);
                }
            }
        }
        return matrix[m - 1][n - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int[][] a = new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minimumPathSum.minPathSum1(a));
    }
}
//    LC64
//    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
//        Note: You can only move either down or right at any point in time.
//
//        Example:
//
//        Input:
//        [
//        [1,3,1],
//        [1,5,1],
//        [4,2,1]
//        ]
//        Output: 7
//        Explanation: Because the path 1→3→1→1→1 minimizes the sum.



