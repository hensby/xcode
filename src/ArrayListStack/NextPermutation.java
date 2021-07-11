package ArrayListStack;

import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int len = nums.length;  // >= 2
        int left = len - 2;
        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }
        if (left >= 0) {
            int right = len - 1;
            while (right >= 0 && nums[right] > nums[left]) {
                right--;
            }
            swap(nums, left, right);
        }
        revert(nums, left - 1);
    }

    public static void swap(int[] nums, int left, int right) {
        int leftNum = nums[left];
        nums[left] = nums[right];
        nums[right] = leftNum;
    }

    public static void revert(int[] nums, int left) {
        int right = nums.length - 1;
        while (left <= right) {
            swap(nums, left, right);
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,5,8,4,7,6,5,3,1};
        nextPermutation(input);
        System.out.println(Arrays.toString(input));
    }
}

//31. Next Permutation
//        Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//        If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
//
//        The replacement must be in place and use only constant extra memory.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2,3]
//        Output: [1,3,2]
//        Example 2:
//
//        Input: nums = [3,2,1]
//        Output: [1,2,3]
//        Example 3:
//
//        Input: nums = [1,1,5]
//        Output: [1,5,1]
//        Example 4:
//        [2,3,4,5,6,3,2,1]
//
//        Input: nums = [1]
//        Output: [1]
//
//
//        Constraints:
//
//        1 <= nums.length <= 100
//        0 <= nums[i] <= 100