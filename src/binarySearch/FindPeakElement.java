package binarySearch;

public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + ((right - left) / 2);
            if (mid < len - 1 && nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(input));
    }

}
//162. Find Peak Element
//        A peak element is an element that is strictly greater than its neighbors.
//
//        Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
//
//        You may imagine that nums[-1] = nums[n] = -∞.
//
//        You must write an algorithm that runs in O(log n) time.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2,3,1]
//        Output: 2
//        Explanation: 3 is a peak element and your function should return the index number 2.
//        Example 2:
//
//        Input: nums = [1,2,1,3,5,6,4]
//        Output: 5
//        Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
//
//
//        Constraints:
//
//        1 <= nums.length <= 1000
//        -231 <= nums[i] <= 231 - 1
//        nums[i] != nums[i + 1] for all valid i.