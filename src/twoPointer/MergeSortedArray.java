package twoPointer;

import java.util.Arrays;

public class MergeSortedArray {

     public static void merge(int[] nums1, int m, int[] nums2, int n) {
         int pointer1 = m - 1, pointer2 = n - 1, index = m + n - 1;
         while(pointer1 >= 0 || pointer2 >= 0) {
             if(pointer1 >= 0 && pointer2 >= 0) {
                 if(nums1[pointer1] > nums2[pointer2]) {
                     nums1[index--] = nums1[pointer1--];
                 } else {
                     nums1[index--] = nums2[pointer2--];
                 }
             } else if(pointer2 >= 0) {
                 nums1[index--] = nums2[pointer2--];
             } else {
                 nums1[index--] = nums1[pointer1--];
             }
         }
     }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int index1 = m - 1, index2 = n - 1, indexEnd = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 >= 0 && index2 >= 0) {
                if (nums1[index1] >= nums2[index2]) {
                    nums1[indexEnd--] = nums1[index1--];
                } else {
                    nums1[indexEnd--] = nums2[index2--];
                }
            } else if (index2 >= 0) {
                nums1[indexEnd--] = nums2[index2--];
            } else {
                nums1[indexEnd--] = nums1[index1--];
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0}, nums2 = new int[]{2,5,6};
        merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
}
//88. Merge Sorted Array
//        You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//
//        Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//        The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
//
//
//
//        Example 1:
//
//        Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//        Output: [1,2,2,3,5,6]
//        Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//        The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
//        Example 2:
//
//        Input: nums1 = [1], m = 1, nums2 = [], n = 0
//        Output: [1]
//        Explanation: The arrays we are merging are [1] and [].
//        The result of the merge is [1].
//        Example 3:
//
//        Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//        Output: [1]
//        Explanation: The arrays we are merging are [] and [1].
//        The result of the merge is [1].
//        Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
//
//
//        Constraints:
//
//        nums1.length == m + n
//        nums2.length == n
//        0 <= m, n <= 200
//        1 <= m + n <= 200
//        -109 <= nums1[i], nums2[j] <= 109
