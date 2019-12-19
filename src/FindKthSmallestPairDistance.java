import javax.swing.*;
import java.util.Arrays;

public class FindKthSmallestPairDistance {

    public int smallestDistancePair(int[] nums, int k){
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length-1]-nums[0];
        while (low < high){
            int mid = low + (high - low)>>>1;
            int count = countSmallerPairs(mid, nums);
            if (count < k){
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return low;
    }

    private int countSmallerPairs(int guess, int[] nums) {
        int count = 0, n = nums.length;
        for (int left = 0; left < n - 1; left++) {
            int target = nums[left] + guess;
            int right = upperBound(nums, left + 1, n - 1, target);
            count += right - left - 1;
        }

        return count;
    }

    // Returns index of first index of element which is greater than key
    private int upperBound(int[] a, int low, int high, int key) {
        if (a[high] <= key) {
            return high + 1;
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (key >= a[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        FindKthSmallestPairDistance findKthSmallestPairDistance = new FindKthSmallestPairDistance();
        int[] s = new int[]{1,3,1};
        System.out.println(findKthSmallestPairDistance.smallestDistancePair(s,2));
    }

}
