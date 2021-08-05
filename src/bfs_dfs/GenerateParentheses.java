package bfs_dfs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    private static void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
// O( 2^n * n)
//22. Generate Parentheses
//        Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//        Example 1:
//
//        Input: n = 3
//        Output: ["((()))","(()())","(())()","()(())","()()()"]
//        Example 2:
//
//        Input: n = 1
//        Output: ["()"]
//
//
//        Constraints:
//
//        1 <= n <= 8
