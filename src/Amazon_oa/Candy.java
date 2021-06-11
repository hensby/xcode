package Amazon_oa;

import java.util.Arrays;

public class Candy {
// 13
    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;
        int size = ratings.length;
        int[] left = new int[size];
        int[] right = new int[size];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < size; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        System.out.println(Arrays.toString(left));
        int sum = left[size-1];
        right[size-1] = left[size-1];
        for (int i = size - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
            right[i] = Math.max(right[i], left[i]);
            sum += right[i];
        }
        System.out.println(Arrays.toString(right));
        return sum;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,2,2};
        int[] input1 = new int[] {1,0,2,3,4,5};
        System.out.println(candy(input));
        System.out.println(candy(input1));
    }
}
// 13
//    There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
//
//        You are giving candies to these children subjected to the following requirements:
//
//        Each child must have at least one candy.
//        Children with a higher rating get more candies than their neighbors.
//        Return the minimum number of candies you need to have to distribute the candies to the children.
//
//        Example 1:
//
//        Input: ratings = [1,0,2]
//        Output: 5
//        Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
//
//        Example 2:
//
//        Input: ratings = [1,2,2]
//        Output: 4
//        Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
//        The third child gets 1 candy because it satisfies the above two conditions.