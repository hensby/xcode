package Amazon_onsite;

import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        if (nums.length == 0) return;
        int zeroIndex = 0, numIndex = 0;
        while (numIndex < nums.length) {
            if (nums[numIndex] != 0) {
                nums[zeroIndex] = nums[numIndex];
                zeroIndex++;
            }
            numIndex++;
        }
        for (int i = zeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,3,9,10,0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
//时间复杂度：O(n)O(n)，其中 nn 为序列长度。每个位置至多被遍历两次。
//空间复杂度：O(1)O(1)。只需要常数的空间存放若干变量。
//        283. Move Zeroes
//        Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//        Note that you must do this in-place without making a copy of the array.
//
//        Example 1:
//
//        Input: nums = [0,1,0,3,12]
//        Output: [1,3,12,0,0]
//        Example 2:
//
//        Input: nums = [0]
//        Output: [0]
//
//        Constraints:
//
//        1 <= nums.length <= 104
//        -231 <= nums[i] <= 231 - 1