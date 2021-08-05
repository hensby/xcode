package Amazon_onsite;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums, nums[i] - 1, i);
            }
        }
        System.out.println(Arrays.toString(nums));
        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public int firstMissingPositive1(int[] nums) {
        int len = nums.length;

        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        for (int i = 1; i <= len ; i++) {
            if (!hashSet.contains(i)){
                return i;
            }
        }

        return len + 1;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {-1,7,8,9,11,12,-10};
        System.out.println(firstMissingPositive(nums));
    }

}
//        41. First Missing Positive
//        Given an unsorted integer array nums, return the smallest missing positive integer.
//
//        You must implement an algorithm that runs in O(n) time and uses constant extra space.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2,0]
//        Output: 3
//        Example 2:
//
//        Input: nums = [3,4,-1,1]
//        Output: 2
//        Example 3:
//
//        Input: nums = [7,8,9,11,12]
//        Output: 1
//
//
//        Constraints:
//
//        1 <= nums.length <= 5 * 105
//        -231 <= nums[i] <= 231 - 1
