package bfs_dfs.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    int[] candidates;
    int target, len;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return res;
        this.candidates = candidates;
        this.target = target;
        this.len = candidates.length;
        // Arrays.sort(candidates);
        dfs(new ArrayList<>(), 0, 0);
        return res;
    }

    public void dfs(List<Integer> tmpRes,int sum, int start) {
        if (tmpRes.size()!= 0 && sum == target) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }
        if (sum > target) return;
        for (int i = start; i < len; i++) {
            tmpRes.add(candidates[i]);
            dfs(tmpRes, sum + candidates[i], i);
            tmpRes.remove(tmpRes.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = new int[]{2,3,6,7};

        System.out.println(combinationSum.combinationSum(candidates, 7));
    }

}
//39. Combination Sum
//        Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
//        The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
//
//        It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
//
//
//
//        Example 1:
//
//        Input: candidates = [2,3,6,7], target = 7
//        Output: [[2,2,3],[7]]
//        Explanation:
//        2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//        7 is a candidate, and 7 = 7.
//        These are the only two combinations.
//        Example 2:
//
//        Input: candidates = [2,3,5], target = 8
//        Output: [[2,2,2,2],[2,3,3],[3,5]]
//        Example 3:
//
//        Input: candidates = [2], target = 1
//        Output: []
//        Example 4:
//
//        Input: candidates = [1], target = 1
//        Output: [[1]]
//        Example 5:
//
//        Input: candidates = [1], target = 2
//        Output: [[1,1]]
//
//
//        Constraints:
//
//        1 <= candidates.length <= 30
//        1 <= candidates[i] <= 200
//        All elements of candidates are distinct.
//        1 <= target <= 500