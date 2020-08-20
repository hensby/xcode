package DP;

import java.util.Arrays;

//494
public class FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = computeArraySum(nums);
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int W = (sum + S) / 2;
        int[] dp = new int[W + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                System.out.println(Arrays.toString(dp));
                dp[i] = dp[i] + dp[i - num];
            }
        }

        return dp[W];
    }

    private int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        FindTargetSumWays findTargetSumWays = new FindTargetSumWays();
        int[] input = new int[]{1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(findTargetSumWays.findTargetSumWays(input, S));
    }
}
