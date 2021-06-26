package twoPointer;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;

        int left = 0;
        int right = size - 1;

        int removeNums = size - k;
        while (removeNums > 0) {
            if (x - arr[left] <= arr[right] - x) {
                right--;
            } else {
                left++;
            }
            removeNums--;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        FindKClosestElements findClosestElements = new FindKClosestElements();
        int[] arr = new int[]{1,2,3,4,5};
        int k = 4, x = 3;
        System.out.println(findClosestElements.findClosestElements(arr, k, x));
    }

}
//658. Find K Closest Elements
//        Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
//
//        An integer a is closer to x than an integer b if:
//
//        |a - x| < |b - x|, or
//        |a - x| == |b - x| and a < b
//
//
//Example 1:
//
//        Input: arr = [1,2,3,4,5], k = 4, x = 3
//        Output: [1,2,3,4]
//        Example 2:
//
//        Input: arr = [1,2,3,4,5], k = 4, x = -1
//        Output: [1,2,3,4]
//
//
//        Constraints:
//
//        1 <= k <= arr.length
//        1 <= arr.length <= 104
//        arr is sorted in ascending order.
//        -104 <= arr[i], x <= 104
