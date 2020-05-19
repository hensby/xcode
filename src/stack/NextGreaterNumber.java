package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterNumber {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for(int i = 0; i < 2 * nums.length - 1; i++) {
            int index = i % nums.length; // 取模，实现循环数组
            while(!stack.isEmpty() && nums[stack.peek()] < nums[index]) { // 找到下一个更大元素
                res[stack.pop()] = nums[index]; // 栈中保存的是索引
                System.out.println("stack + " + stack);
            }
            stack.push(index);
            System.out.println("stack " + stack);
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterNumber nextGreaterNumber = new NextGreaterNumber();
        int[] input = new int[]{3,8,4,1,2};
        System.out.println(Arrays.toString(nextGreaterNumber.nextGreaterElements(input)));
    }
}

// 503
