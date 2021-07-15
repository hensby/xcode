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
