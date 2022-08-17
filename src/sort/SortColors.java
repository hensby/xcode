package sort;

import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }

    public static void sortColors1(int[] nums) {
        int zero = -1, one = 0, two = nums.length;
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            } else if (nums[one] == 2) {
                swap(nums, --two, one);
            } else {
                ++one;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void sortColors2(int[] nums) {
        int len = nums.length;
        if (len <= 1) return;
        int left = 0, right = len - 1, current = 0;
        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, left, current);
                left++;
                current++;
            } else if (nums[current] == 2) {
                swap(nums, current, right);
                right--;
            } else {
                current++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,2,0,2,1,1,0,0,0,1,1,2};
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
//75. Sort Colors
//        Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//        We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//        You must solve this problem without using the library's sort function.
//
//        Example 1:
//
//        Input: nums = [2,0,2,1,1,0]
//        Output: [0,0,1,1,2,2]
//        Example 2:
//
//        Input: nums = [2,0,1]
//        Output: [0,1,2]
//        Example 3:
//
//        Input: nums = [0]
//        Output: [0]
//        Example 4:
//
//        Input: nums = [1]
//        Output: [1]
//
//
//        Constraints:
//
//        n == nums.length
//        1 <= n <= 300
//        nums[i] is 0, 1, or 2.