package DP;

import java.util.Arrays;
// 714
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
            System.out.println(peak + " " + valley);
        }
        return maxprofit;
    }

    public int maxProfit1(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        // dp[i][j] 表示 [0, i] 区间内，到第 i 天（从 0 开始）状态为 j 时的最大收益'
        // j = 0 表示不持股，j = 1 表示持股
        // 并且规定在买入股票的时候，扣除手续费
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        int[] stocks = new int[] {1, 7, 5, 3, 6, 4};
        int[] input = new int[] {1, 3, 2, 8, 4, 9};
        BestTimetoBuyandSellStock stock = new BestTimetoBuyandSellStock();
        System.out.println(stock.maxProfit1(input, 2));
    }
}
//  [7,1,5,3,6,4]
