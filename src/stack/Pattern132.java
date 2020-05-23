package stack;

import java.util.Arrays;
import java.util.Stack;

public class Pattern132 {
        public boolean find132pattern(int[] nums) {
            if (nums.length < 3)
                return false;
            Stack< Integer > stack = new Stack < > ();
            int[] min = new int[nums.length];
            min[0] = nums[0];
            for (int i = 1; i < nums.length; i++)
                min[i] = Math.min(min[i - 1], nums[i]);
            System.out.println(Arrays.toString(min));
            for (int j = nums.length - 1; j >= 0; j--) {
                System.out.println(stack);
                if (nums[j] > min[j]) {
                    while (!stack.isEmpty() && stack.peek() <= min[j])
                        stack.pop();
                    if (!stack.isEmpty() && stack.peek() < nums[j])
                        return true;
                    stack.push(nums[j]);
                }
            }
            return false;
        }

    public static void main(String[] args) {
        int[] input = new int[] {6, 12, 3, 4, 6, 11, 20};
        System.out.println(Arrays.toString(input));
        Pattern132 p = new Pattern132();
        System.out.println(p.find132pattern(input));
    }
}
