package DP;

import java.util.Arrays;

public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 子问题：
        // f(k) = 偷 [0..k) 房间中的最大金额

        // f(0) = 0
        // f(1) = nums[0]
        // f(k) = max{ rob(k-1), nums[k-1] + rob(k-2) }

        int N = nums.length;
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int k = 2; k <= N; k++) {
            dp[k] = Math.max(dp[k-1], nums[k-1] + dp[k-2]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[N];
    }


    public int rob1(int[] nums) {
        if (nums.length == 1) return nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(i > 1? nums[i - 2]+ nums[i]: nums[i], nums[i - 1]);
        }
        System.out.println(Arrays.toString(nums));
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        houseRobber.rob1(new int[] {2,1,1,2});
        houseRobber.rob(new int[] {2,1,1,2});

    }
}
