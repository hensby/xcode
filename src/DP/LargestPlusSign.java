package DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargestPlusSign {
    public static int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> banned = new HashSet<>();
        int[][] dp = new int[N][N];

        for (int[] mine : mines) {
            banned.add(toOneDimension(mine[0], mine[1], N));
        }
        System.out.println(banned);
        int ans = 0, count;

        for (int x = 0; x < N; ++x) {
            // right
            count = 0;
            for (int y = 0; y < N; ++y) {
                count = banned.contains(toOneDimension(x, y, N)) ? 0 : count + 1;
                dp[x][y] = count;
            }
            System.out.println(Arrays.deepToString(dp));

            // left
            count = 0;
            for (int y = N - 1; y >= 0; --y) {
                count = banned.contains(toOneDimension(x, y, N)) ? 0 : count + 1;
                dp[x][y] = Math.min(dp[x][y], count);
            }
            System.out.println(Arrays.deepToString(dp));
        }
        System.out.println("");

        System.out.println(Arrays.deepToString(dp));
        for (int y = 0; y < N; ++y) {
            // down
            count = 0;
            for (int x = 0; x < N; ++x) {
                count = banned.contains(toOneDimension(x, y, N)) ? 0 : count + 1;
                dp[x][y] = Math.min(dp[x][y], count);
            }
            System.out.println(Arrays.deepToString(dp));

            // up
            count = 0;
            for (int x = N - 1; x >= 0; --x) {
                count = banned.contains(toOneDimension(x, y, N)) ? 0 : count + 1;
                dp[x][y] = Math.min(dp[x][y], count);
                ans = Math.max(ans, dp[x][y]);
            }
            System.out.println(Arrays.deepToString(dp));
        }
        System.out.println("");

        System.out.println(Arrays.deepToString(dp));

        return ans;
    }

    private static int toOneDimension(int x, int y, int n) {
        return x * n + y;
    }

    public static int orderOfLargestPlusSign1(int n, int[][] mines) {
        if (n == 0) return 0;

        Set<Integer> edges = new HashSet<>();
        for(int[] mine: mines) {
            edges.add(oneDementionMap(mine[0], mine[1], n));
        }
        int[][] dp = new int[n][n];
        int count, ans = 0;
        for (int row = 0; row < n; row++) {
            count = 0;
            for (int col = 0; col < n; col++) {
                count = edges.contains(oneDementionMap(row, col, n))? 0: count + 1;
                dp[row][col] = count;
            }
            count = 0;
            for (int col = n - 1; col >= 0; col--) {
                count = edges.contains(oneDementionMap(row, col, n))? 0: count + 1;
                dp[row][col] = Math.min(dp[row][col], count);
            }
        }
        for (int col = 0; col < n; col++) {
            count = 0;
            for (int row = 0; row < n; row++) {
                count = edges.contains(oneDementionMap(row, col, n))? 0: count + 1;
                dp[row][col] = Math.min(dp[row][col], count);
            }
            count = 0;
            for (int row = n - 1; row >= 0; row--) {
                count = edges.contains(oneDementionMap(row, col, n))? 0: count + 1;
                dp[row][col] = Math.min(dp[row][col], count);
                ans = Math.max(ans, dp[row][col]);
            }
        }
        return ans;
    }

    private static int oneDementionMap(int raw, int col, int width) {
        return raw * width + col;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
//                {1,1,1,1,1},
//                {1,1,1,1,1},
//                {1,1,1,1,1},
//                {1,1,1,1,1},
//                {1,1,0,1,1}
                {4, 2}
        };
        System.out.println(orderOfLargestPlusSign(5, input));
        System.out.println(orderOfLargestPlusSign1(5, input));

    }
}

//764. Largest Plus Sign
//        You are given an integer n. You have an n x n binary grid grid with all values initially 1's except for some indices given in the array mines. The ith element of the array mines is defined as mines[i] = [xi, yi] where grid[xi][yi] == 0.
//
//        Return the order of the largest axis-aligned plus sign of 1's contained in grid. If there is none, return 0.
//
//        An axis-aligned plus sign of 1's of order k has some center grid[r][c] == 1 along with four arms of length k - 1 going up, down, left, and right, and made of 1's. Note that there could be 0's or 1's beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1's.
//
//
//
//        Example 1:
//
//
//        Input: n = 5, mines = [[4,2]]
//        Output: 2
//        Explanation: In the above grid, the largest plus sign can only be of order 2. One of them is shown.
//        Example 2:
//
//
//        Input: n = 1, mines = [[0,0]]
//        Output: 0
//        Explanation: There is no plus sign, so return 0.
