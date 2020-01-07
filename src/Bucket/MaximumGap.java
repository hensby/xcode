package Bucket;

import java.util.Arrays;

public class MaximumGap {
//    public int maximumGap1(int[] nums) {
//        if (nums == null || nums.length < 2) return 0;
//
//        int min = nums[0], max = nums[0];
//        for (int val : nums) {
//            max = Math.max(max, val);
//            min = Math.min(min, val);
//        }
//        int n = nums.length;
//        int gap = (int)Math.ceil((double)(max - min) / (n - 1));
//        int[] maxs = new int[n - 1];
//        int[] mins = new int[n - 1];
//        Arrays.fill(maxs, Integer.MAX_VALUE);
//        Arrays.fill(mins, Integer.MIN_VALUE);
//
//        for (int val : nums) {
//            if (val == max || val == min) continue;
//            int index = (val - min) / gap;
//
//
//        }
//
//
//    }



    public int maximumGap(int[] num) {
        if (num == null || num.length < 2) {
            return 0;
        }
        // get the max and min value of the array
        int min = num[0];
        int max = num[0];
        for (int val : num) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        int n = num.length;
        // the minimum possible gap, ceiling of the integer division
        int gap = (int) Math.ceil((double) (max - min) / (n - 1));
        System.out.println((double) (max - min) / (n - 1));
        System.out.println((max - min) / (n - 1));
        int[] mins = new int[n - 1]; // min number in each bucket
        int[] maxs = new int[n - 1]; // max number in each bucket
        Arrays.fill(mins, Integer.MAX_VALUE);
        Arrays.fill(maxs, Integer.MIN_VALUE);
        // put numbers into buckets
        for (int val : num) {
            if (val == min || val == max) {
                continue;
            }
            int idx = (val - min) / gap;
            mins[idx] = Math.min(val, mins[idx]);
            maxs[idx] = Math.max(val, maxs[idx]);
        }
        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < n - 1; i++) {
            if (mins[i] == Integer.MAX_VALUE) { // empty bucket
                continue;
            }
            maxGap = Math.max(maxGap, mins[i] - previous);
            previous = maxs[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }

    public static void main(String[] args) {
        MaximumGap maximumGap = new MaximumGap();
        int[] nums = new int[]{3, 6, 9, 1};
        System.out.println(maximumGap.maximumGap(nums));
    }
}
/*
 * Maximum Gap
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Try to solve it in linear time/space.

 Return 0 if the array contains less than 2 elements.

 You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

 Suppose there are N elements and they range from A to B.

 Then the maximum gap will be no smaller than ceiling[(B - A) / (N - 1)]

 Let the length of a bucket to be len = ceiling[(B - A) / (N - 1)], then we will have at most num = (B - A) / len + 1 of bucket

 for any number K in the array, we can easily find out which bucket it belongs by calculating loc = (K - A) / len and therefore maintain the maximum and minimum elements in each bucket.

 Since the maximum difference between elements in the same buckets will be at most len - 1, so the final answer will not be taken from two elements in the same buckets.

 For each non-empty buckets p, find the next non-empty buckets q, then q.min - p.max could be the potential answer to the question. Return the maximum of all those values.
 */