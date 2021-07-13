package greedy;

import java.util.Arrays;

public class NonDecreasingArray {

    public static boolean checkPossibility(int[] nums) {
        if(nums.length < 3) return true;
        int count = 0;
        for(int i = 1; i < nums.length; i++) {
            if(count > 1) return false;
            if(nums[i] > nums[i - 1]) continue;
            if(nums[i] < nums[i - 1]) {
                if(i - 2 >= 0 && nums[i] < nums[i - 2]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i];
                }
                count++;
            }
            System.out.println(Arrays.toString(nums));
            System.out.println(count);
        }
        return count < 2;
    }

    public static boolean checkPossibility1(int[] nums) {
        if (nums == null || nums.length < 3) return true;
        int len = nums.length, count = 0;
        for (int i = 1; i < len; i++) {
            if (count > 1) return false;
            if (nums[i] >= nums[i - 1]) {
                continue;
            } else {
                if (i < 2) nums[i - 1] = nums[i];
                else { // i >= 2
                    if (nums[i] >= nums[i - 2]) {
                        nums[i - 1] = nums[i];
                    } else { // nums[i] < nums[i - 2]
                        nums[i] = nums[i - 1];
                    }
                }
                count++;
            }
        }
        return count < 2;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,5,2,4,6,7};
        int[] nums1 = new int[] {3,5,3,4,6,7};

        System.out.println(checkPossibility(nums));
        System.out.println(checkPossibility1(nums1));

    }
}
//665. Non-decreasing Array
//        Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
//
//        We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
//
//        Example 1:
//
//        Input: nums = [4,2,3]
//        Output: true
//        Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
//        Example 2:
//
//        Input: nums = [4,2,1]
//        Output: false
//        Explanation: You can't get a non-decreasing array by modify at most one element.
//
//
//        Constraints:
//
//        n == nums.length
//        1 <= n <= 104
//        -105 <= nums[i] <= 105
