package Amazon_onsite;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1, right = len - 1;
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重复
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> tmpRes = Arrays.asList(nums[i], nums[left], nums[right]);
                    res.add(tmpRes);
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    right--;
                } else if (sum > 0){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));

    }
}
//15. 3Sum
//        Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//        Notice that the solution set must not contain duplicate triplets.
//
//        Example 1:
//
//        Input: nums = [-1,0,1,2,-1,-4]
//        Output: [[-1,-1,2],[-1,0,1]]
//        Example 2:
//
//        Input: nums = []
//        Output: []
//        Example 3:
//
//        Input: nums = [0]
//        Output: []
//
