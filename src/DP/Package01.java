package DP;

import java.util.Arrays;

public class Package01 {
    // W 为背包总体积
    // N 为物品数量
    // weights 数组存储 N 个物品的重量
    // values 数组存储 N 个物品的价值
    public int knapsack(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = 1; j <= W; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int[] tmp : dp) {
            System.out.println(Arrays.toString(tmp));
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        int W = 15;
        int N = 5;
        int[] weights = new int[] {1,5,4,7,2,6};
        int[] values = new int[] {3,12,3,10,3,6};
        Package01 p = new Package01();
        System.out.println(p.knapsack(W, N, weights, values));
    }
//    [0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0]
//    [0, 0, 0, 0, 0, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12]
//    [0, 0, 0, 0, 3, 12, 12, 12, 12, 15, 15, 15, 15, 15, 15, 15]
//    [0, 0, 0, 0, 3, 12, 12, 12, 12, 15, 15, 15, 22, 22, 22, 22]
//    [0, 0, 3, 3, 3, 12, 12, 15, 15, 15, 15, 18, 22, 22, 25, 25]
//    [0, 0, 3, 3, 3, 12, 12, 15, 15, 15, 15, 18, 22, 22, 25, 25]
}
