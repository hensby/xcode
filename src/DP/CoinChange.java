package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 322. Coin Change
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        // System.out.println(Arrays.toString(dp));
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    System.out.println(Arrays.toString(dp));
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public List<Integer> coinChange1(int[] coins, int amount) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < amount + 1; i++) {
            res.add(new ArrayList<>());
        }
        for (int remaining = 0; remaining <= amount; remaining++) {
            for (int coinIndex = 0; coinIndex < coins.length; coinIndex++) {
                if (coins[coinIndex] <= remaining) {
                    System.out.println(res);
                    if (res.get(remaining).isEmpty() || !res.get(remaining).isEmpty() && res.get(remaining).size() >
                            res.get(remaining - coins[coinIndex]).size()) {
                        List<Integer> tmpRes = new ArrayList<>(res.get(remaining - coins[coinIndex]));
                        tmpRes.add(coins[coinIndex]);
                        res.set(remaining, tmpRes);
                    }
                }
            }
        }
        System.out.println(res);

        return res.get(amount);
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(coinChange.coinChange(coins, amount));
        System.out.println(coinChange.coinChange1(coins, amount));

    }
}
