package Amazon_onsite;

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length == 0 || height == null) return 0;
        int len = height.length;
        int[] toLeft = new int[len];
        int[] toRight = new int[len];
        int toRightMax = 0, toLeftMax = 0;
        for (int i = 0; i < len; i++) {
            if (height[len - i - 1] > toLeftMax) {
                toLeft[len - i - 1] = height[len - i - 1];
                toLeftMax = height[len - i - 1];
            } else toLeft[len - i - 1] = toLeftMax;
            if (height[i] > toRightMax) {
                toRight[i] = height[i];
                toRightMax = height[i];
            } else toRight[i] = toRightMax;
        }
        int res = 0;
        for (int j = 0; j < len; j++) {
            res += Math.min(toLeft[j], toRight[j]) - height[j];
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
//42. Trapping Rain Water
//        Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
//
//
//
//        Example 1:
//
//
//        Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//        Output: 6
//        Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
//        Example 2:
//
//        Input: height = [4,2,0,3,2,5]
//        Output: 9
//
//
//        Constraints:
//
//        n == height.length
//        1 <= n <= 2 * 104
//        0 <= height[i] <= 105
