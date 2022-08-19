package binarySearch;

public class SingleElementinaSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            boolean halvesAreEven = (hi - mid) % 2 == 0;
            if (nums[mid + 1] == nums[mid]) {
                if (halvesAreEven) {
                    lo = mid + 2;
                } else {
                    hi = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (halvesAreEven) {
                    hi = mid - 2;
                } else {
                    lo = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[lo];
    }


    public static void main(String[] args) {
        int[] nums  = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] nums2 = new int[]{1, 1, 2, 2, 3, 3, 4, 8, 8};

        int[] nums1 = new int[]{1, 1, 2};

        System.out.println(singleNonDuplicate(nums));
    }
}
//540. Single Element in a Sorted Array
//        You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
//
//        Follow up: Your solution should run in O(log n) time and O(1) space.
//
//        Example 1:
//
//        Input: nums = [1,1,2,3,3,4,4,8,8]
//        Output: 2
//        Example 2:
//
//        Input: nums = [3,3,7,7,10,11,11]
//        Output: 10
//
//
//        Constraints:
//
//        1 <= nums.length <= 10^5
//        0 <= nums[i] <= 10^5