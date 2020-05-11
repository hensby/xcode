package sort;

import java.util.Arrays;

public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        if(A == null || A.length == 0) return -1;
        Arrays.sort(A);
        int left = 0, right = A.length - 1;
        int res = 0;
        while(left < right) {
            if (A[right] > K) {
                right--;
                continue;
            }
            int sum = A[left] + A[right];
            if (sum < K) {
                res = Math.max(sum, res);
                left ++;
            } else {
                right --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSumLessThanK twoSumLessThanK = new TwoSumLessThanK();
        int[] A = new int[]{34,23,1,24,75,33,54,8};
        int K = 60;
        System.out.println(twoSumLessThanK.twoSumLessThanK(A, K));
    }
}
//        LeetCode 1099. Two Sum Less Than K
//
//        Given an array A of integers and integer K, return the maximum S such that there exists i < j with A[i] + A[j] = S and S < K. If no i, jexist satisfying this equation, return -1.
//
//        Example 1:
//
//        Input: A = [34,23,1,24,75,33,54,8], K = 60
//        Output: 58
//        Explanation:
//        We can use 34 and 24 to sum 58 which is less than 60.
//        Example 2:
//
//        Input: A = [10,20,30], K = 15
//        Output: -1
//        Explanation:
//        In this case it's not possible to get a pair sum less that 15.
//        Note:
//
//        1 <= A.length <= 100
//        1 <= A[i] <= 1000
//        1 <= K <= 2000