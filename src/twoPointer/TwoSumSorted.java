package twoPointer;

import java.util.Arrays;

public class TwoSumSorted {
    public static int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int left = 0, right = len - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(twoSum(input, 17)));
    }
}
//167. Two Sum II - Input array is sorted
//        Given an array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
//
//        Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
//
//        The tests are generated such that there is exactly one solution. You may not use the same element twice.
//
//
//
//        Example 1:
//
//        Input: numbers = [2,7,11,15], target = 9
//        Output: [1,2]
//        Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
//        Example 2:
//
//        Input: numbers = [2,3,4], target = 6
//        Output: [1,3]
//        Example 3:
//
//        Input: numbers = [-1,0], target = -1
//        Output: [1,2]
//
//
//        Constraints:
//
//        2 <= numbers.length <= 3 * 104
//        -1000 <= numbers[i] <= 1000
//        numbers is sorted in non-decreasing order.
//        -1000 <= target <= 1000
//        The tests are generated such that there is exactly one solution.