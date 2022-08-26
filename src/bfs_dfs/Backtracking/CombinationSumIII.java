package bfs_dfs.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {


    List<List<Integer>> res = new ArrayList<>();
    int k, n;

    public List<List<Integer>> combinationSum3(int k, int n) {// k = res.length, n = target
        if (k == 0 || n == 0) return res;
        this.k = k;
        this.n = n;
        boolean[] isVisit = new boolean[10];
        List<Integer> tmpRes = new ArrayList<>();
        dfs(tmpRes, isVisit, 0, 1);
        return res;
    }

    public void dfs(List<Integer> tmpRes, boolean[] isVisit, int tmpSum, int start) {
        if (tmpSum == n && tmpRes.size() == k) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }
        for (int i = start; i < 10; i++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                tmpRes.add(i);
                tmpSum += i;
                dfs(tmpRes, isVisit, tmpSum, i + 1);
                isVisit[i] = false;
                tmpRes.remove(tmpRes.size() - 1);
                tmpSum -= i;
            }
        }
    }

//    List<List<Integer>> res = new ArrayList<>();
//    int k, n;
//    public List<List<Integer>> combinationSum3(int k, int n) {
//        if (k == 0) return res;
//        this.k = k;
//        this.n = n;
//        dfs(new ArrayList<>(), 0, 1);
//        return res;
//    }
//
//    public void dfs(List<Integer> tmpRes, int sum, int start) {
//        if (tmpRes.size() == k && sum == n) {
//            res.add(new ArrayList<>(tmpRes));
//            return;
//        }
//        if (start > 9 || tmpRes.size() > k || sum > n) return;
//        for (int i = start; i <= 9; i++) {
//            tmpRes.add(i);
//            dfs(tmpRes, sum + i, i + 1);
//            tmpRes.remove(tmpRes.size() - 1);
//        }
//    }

    public static void main(String[] args) {
        CombinationSumIII C = new CombinationSumIII();
        System.out.println(C.combinationSum3(3, 9));
    }


}
//216. Combination Sum III
//        Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
//
//        Only numbers 1 through 9 are used.
//        Each number is used at most once.
//        Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
//
//
//
//        Example 1:
//
//        Input: k = 3, n = 7
//        Output: [[1,2,4]]
//        Explanation:
//        1 + 2 + 4 = 7
//        There are no other valid combinations.
//        Example 2:
//
//        Input: k = 3, n = 9
//        Output: [[1,2,6],[1,3,5],[2,3,4]]
//        Explanation:
//        1 + 2 + 6 = 9
//        1 + 3 + 5 = 9
//        2 + 3 + 4 = 9
//        There are no other valid combinations.
//        Example 3:
//
//        Input: k = 4, n = 1
//        Output: []
//        Explanation: There are no valid combinations.
//        Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
//        Example 4:
//
//        Input: k = 3, n = 2
//        Output: []
//        Explanation: There are no valid combinations.
//        Example 5:
//
//        Input: k = 9, n = 45
//        Output: [[1,2,3,4,5,6,7,8,9]]
//        Explanation:
//        1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
//        There are no other valid combinations.
//
//
//        Constraints:
//
//        2 <= k <= 9
//        1 <= n <= 60