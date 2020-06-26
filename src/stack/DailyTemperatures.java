package stack;

import java.util.Arrays;
import java.util.Stack;
// 739
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[len];
        Arrays.fill(res, 0);
        for(int i = 0; i < len; i++) {
            if(stack.isEmpty()) {
                stack.push(new int[]{i, T[i]});
            }
            while(!stack.isEmpty() && T[i] > stack.peek()[1]) {
                int[] tmp = stack.pop();
                res[tmp[0]] = i - tmp[0];
            }
            stack.push(new int[]{i, T[i]});
        }
        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(T)));
    }

}
