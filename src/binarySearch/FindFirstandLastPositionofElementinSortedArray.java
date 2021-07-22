package binarySearch;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) return res;
        int len = nums.length;
        int left = 0, right = len - 1;
        //find left edge
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        res[0] = nums[left] == target? left: -1;
        System.out.println(Arrays.toString(res));

        if (res[0] == -1) {
            res[1] = -1;
            return res;
        } else {
            right = len - 1;
            while (left < right) {
                int mid = left + (right - left) / 2 + 1;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            res[1] = nums[right] == target? right: -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums =new int[]{5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

}
//34. Find First and Last Position of Element in Sorted Array
//        Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
//
//        If target is not found in the array, return [-1, -1].
//
//        You must write an algorithm with O(log n) runtime complexity.
//
//        Example 1:
//
//        Input: nums = [5,7,7,8,8,10], target = 8
//        Output: [3,4]
//        Example 2:
//
//        Input: nums = [5,7,7,8,8,10], target = 6
//        Output: [-1,-1]
//        Example 3:
//
//        Input: nums = [], target = 0
//        Output: [-1,-1]
//
//
//        Constraints:
//
//        0 <= nums.length <= 105
//        -109 <= nums[i] <= 109
//        nums is a non-decreasing array.
//        -109 <= target <= 109