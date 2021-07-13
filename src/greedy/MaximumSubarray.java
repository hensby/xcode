package greedy;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int preMax = nums[0], max = nums[0], len = nums.length;
        for (int i = 1; i < len; i++) {
            preMax = preMax > 0? preMax: 0;
            int tmpSum = preMax + nums[i];
            max = Math.max(max, tmpSum);
            preMax = tmpSum;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
//53. Maximum Subarray
//        Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//
//
//        Example 1:
//
//        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//        Output: 6
//        Explanation: [4,-1,2,1] has the largest sum = 6.
//        Example 2:
//
//        Input: nums = [1]
//        Output: 1
//        Example 3:
//
//        Input: nums = [5,4,-1,7,8]
//        Output: 23
//
//
//        Constraints:
//
//        1 <= nums.length <= 3 * 104
//        -105 <= nums[i] <= 105
