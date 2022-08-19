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

    public static boolean checkPossibility2(int[] nums) {
        int len = nums.length;
        if (len <= 1) return true;
        int count = 0;
        for (int i = 1; i < len; i++) {
            if (count > 1) return false;
            if (nums[i] >= nums[i - 1]) continue;
            if (nums[i] < nums[i - 1]) {
                if (i == 1) {
                    nums[i - 1] = nums[i];
                } else {
                    if (nums[i] >= nums[i - 2]) {
                        nums[i - 1] = nums[i];
                    } else {
                        nums[i] = nums[i - 1];
                    }
                }
                count++;
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(count);
        return count <= 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,5,2,4,6,7};
        int[] nums1 = new int[] {3,5,3,4,6,7};
        int[] nums2 = new int[] {4,2,3};


        System.out.println(checkPossibility(nums));
        System.out.println(checkPossibility2(nums2));

    }
}

//两种情况，在出现 nums[i] < nums[i - 1] 时，需要考虑的是应该修改数组的哪个数，
//使得本次修改能使 i 之前的数组成为非递减数组，并且 不影响后续的操作 。
//优先考虑令 nums[i - 1] = nums[i]，因为如果修改 nums[i] = nums[i - 1] 的话，
//那么 nums[i] 这个数会变大，就有可能比 nums[i + 1] 大，从而影响了后续操作。
//还有一个比较特别的情况就是 nums[i] < nums[i - 2]，修改 nums[i - 1] = nums[i]
//不能使数组成为非递减数组，只能修改 nums[i] = nums[i - 1]。

//        例①： 4, 2, 5
//        例②： 1, 4, 2, 5
//        例③： 3, 4, 2, 5

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
