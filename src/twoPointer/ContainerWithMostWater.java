package twoPointer;

public class ContainerWithMostWater {

    public int maxArea(int[] heights) {
        if (heights == null || heights.length < 2) return 0;
        int len = heights.length, left = 0, right = len - 1, result = 0;
        while (left < right) {
            int bar = heights[left] > heights[right]? heights[right] : heights[left];
            int tempRes = bar * (right - left);
            if (result < tempRes) result = tempRes;
            if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        int[] heights = new int[] {1,7,2,5,4,7,3,6};
        System.out.println(c.maxArea(heights));
    }
}

//https://neetcode.io/problems/max-water-container?list=neetcode150

//Container With Most Water
//Solved
//You are given an integer array heights where heights[i] represents the height of the bar.
//
//You may choose any two bars to form a container. Return the maximum amount of water a container can store.
//
//Example 1:
//Input: height = [1,7,2,5,4,7,3,6]
//
//Output: 36
//Example 2:
//
//Input: height = [2,2,2]
//
//Output: 4
//Constraints:
//
//2 <= height.length <= 1000
//0 <= height[i] <= 1000