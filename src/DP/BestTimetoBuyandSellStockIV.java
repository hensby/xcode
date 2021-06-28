package DP;

public class BestTimetoBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2 * k + 1];
        for(int i = 1;i < 2 * k + 1;i += 2){
            dp[0][i] = -prices[0];
        }
        for(int i = 1;i < n;i++){
            for(int j = 0;j < 2 * k - 1;j += 2){
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1],dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2],dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[n - 1][2 * k];
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,2,6,5,0,3};
        BestTimetoBuyandSellStockIV bt = new BestTimetoBuyandSellStockIV();
        System.out.println(bt.maxProfit(2, input));
    }
}
//188. Best Time to Buy and Sell Stock IV
//        You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
//
//        Find the maximum profit you can achieve. You may complete at most k transactions.
//
//        Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
//
//
//
//        Example 1:
//
//        Input: k = 2, prices = [2,4,1]
//        Output: 2
//        Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
//        Example 2:
//
//        Input: k = 2, prices = [3,2,6,5,0,3]
//        Output: 7
//        Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
//
//
//        Constraints:
//
//        0 <= k <= 100
//        0 <= prices.length <= 1000
//        0 <= prices[i] <= 1000