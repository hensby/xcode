package DP;

public class BestTimetoBuyandSellStockwithCooldown {

    public int maxProfit(int[] prices) {

        int len = prices.length;
        if (len < 2) return 0;
        int[][] dp = new int[len][3];
        dp[0][0] = prices[0] * -1;
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }

    public static void main(String[] args) {
        int[] stocks = new int[]{1, 7, 5, 3, 6, 4};
        int[] input = new int[]{1, 3, 2, 8, 4, 9};
        BestTimetoBuyandSellStockWithFee stock = new BestTimetoBuyandSellStockWithFee();
        System.out.println(stock.maxProfit1(input, 2));
        System.out.println(stock.maxProfit1(stocks, 2));
        System.out.println(stock.maxProfit2(stocks, 2));
    }

}
