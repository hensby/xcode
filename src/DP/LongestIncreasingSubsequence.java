package DP;

import java.util.Arrays;
// 300
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return maxans;
    }

    public int lengthOfLIS1(int[] nums) {
        if (nums.length < 2) return 1;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 1;
        for (int i = 0; i < len; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        int[] input = new int[] {10,9,2,5,3,7,101,18};
        System.out.println(l.lengthOfLIS1(input));
    }
}
//300. Longest Increasing Subsequence
//        Given an integer array nums, return the length of the longest strictly increasing subsequence.
//
//        A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
//
//
//
//        Example 1:
//
//        Input: nums = [10,9,2,5,3,7,101,18]
//        Output: 4
//        Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
//        Example 2:
//
//        Input: nums = [0,1,0,3,2,3]
//        Output: 4
//        Example 3:
//
//        Input: nums = [7,7,7,7,7,7,7]
//        Output: 1
//
//
//        Constraints:
//
//        1 <= nums.length <= 2500
//        -104 <= nums[i] <= 104