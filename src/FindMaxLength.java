import java.util.HashMap;
import java.util.Map;

public class FindMaxLength {

     public int findMaxLength(int [] nums) {
         for (int i = 0; i < nums.length; i++ ) {
             if (nums[i] == 0) {
                 nums[i] = -1;
             }
         }

         Map<Integer, Integer> sumToIndex = new HashMap<>();
         int sum = 0, max = 0;

         for (int i = 0; i < nums.length; i++) {
             sum += nums[i];
             if (sum == 0) {
                 max = i + 1;
                 continue;
             }

             Integer index = sumToIndex.get(sum);
             if (index != null) {
                 max = Math.max(max, i - index);
                 continue;
             }
             sumToIndex.put(sum, i);
         }
         return max;
     }

    public static void main(String[] args) {
        int[] test = new int[] {0,0,1,1,0};
        FindMaxLength findMaxLength = new FindMaxLength();
        System.out.println(findMaxLength.findMaxLength(test));
    }


}
/**
 * Contiguous Array
 Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

 Example 1:

 Input: [0,1]
 Output: 2
 Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

 Example 2:

 Input: [0,1,0]
 Output: 2
 Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

 Easy Java O(n) Solution, PreSum + HashMap

 The idea is to change 0 in the original array to -1. Thus, if we find SUM[i, j] == 0
 then we know there are even number of -1 and 1 between index i and j.
 Also put the sum to index mapping to a HashMap to make search faster.
 */
