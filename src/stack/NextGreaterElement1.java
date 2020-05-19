package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int cur: nums) {
            while(!stack.isEmpty() && cur > stack.peek()) {
                int prev = stack.pop();
                map.put(prev, cur);
            }
            stack.push(cur);
        }
        while(!stack.isEmpty()) map.put(stack.pop(), -1);

        int[] res = new int[findNums.length];
        for(int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElement1 n = new NextGreaterElement1();
        int[] nums1 = new int[]{4,1,2}, nums2 = new int[]{1,3,4,2};
        System.out.println(Arrays.toString(n.nextGreaterElement(nums1, nums2)));
    }
}

// 496
