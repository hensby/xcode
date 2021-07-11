package ArrayListStack;

import java.util.Arrays;

public class LongestMountain {
    public static int longestMountain(int[] arr) {
        if (arr == null || arr.length <= 1) return 0;
        int len = arr.length;
        int[] toRight = new int[len];
        int[] toLeft = new int[len];
        for (int i = 1; i < len; i++) {
            if (arr[i] > arr[i - 1]) toRight[i] = toRight[i - 1] + 1;
            int toLeftIndex = len - i - 1;
            if (arr[toLeftIndex] > arr[toLeftIndex + 1]) toLeft[toLeftIndex] = toLeft[toLeftIndex + 1] + 1;
        }
        System.out.println(Arrays.toString(toLeft));
        System.out.println(Arrays.toString(toRight));

        int res = 0;
        for (int i = 0; i < len; i++) {
            if (toLeft[i] > 0 && toRight[i] > 0)
                res = Math.max(res, toLeft[i] + toRight[i] + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,1,4,7,3,2,5};
        int[] arr1 = new int[] {2,1,4,7,10,3,2,1,5};

        System.out.println(longestMountain(arr));
        System.out.println(longestMountain(arr1));

    }

}
//845. Longest Mountain in Array
//        You may recall that an array arr is a mountain array if and only if:
//
//        arr.length >= 3
//        There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
//        arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
//        arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
//        Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.
//
//
//
//        Example 1:
//
//        Input: arr = [2,1,4,7,3,2,5]
//        Output: 5
//        Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
//        Example 2:
//
//        Input: arr = [2,2,2]
//        Output: 0
//        Explanation: There is no mountain.
//
//
//        Constraints:
//
//        1 <= arr.length <= 104
//        0 <= arr[i] <= 104
