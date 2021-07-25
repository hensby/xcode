package gragh.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {


    List<List<Integer>> res = new ArrayList<>();
    int[] candidates;
    int len, target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        this.len = candidates.length;

        boolean[] isVisit = new boolean[len];
        List<Integer> tmpRes = new ArrayList<>();
        dfs(tmpRes, isVisit,0, 0);
        return res;
    }

    public void dfs(List<Integer> tmpRes, boolean[] isVisit, int tmpSum, int start) {
        System.out.println(Arrays.toString(isVisit));
        if (tmpSum == target) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }
        for (int i = start; i < len; i++) {
            if (tmpSum + candidates[i] > target) continue;
            if (i > 0 && candidates[i] == candidates[i - 1] && !isVisit[i - 1]) continue;

            if (!isVisit[i]){
                isVisit[i] = true;
                tmpSum += candidates[i];
                tmpRes.add(candidates[i]);
                dfs(tmpRes,isVisit, tmpSum, i + 1);
                tmpSum -= candidates[i];
                tmpRes.remove(tmpRes.size() - 1);
                isVisit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[] {10,1,2,7,6,1,5}; // 1,1,2,5,6,7,10
        int target = 8;
        CombinationSumII C = new CombinationSumII();
        System.out.println(C.combinationSum2(candidates, target));
    }
}
//40. Combination Sum II
//        Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//
//        Each number in candidates may only be used once in the combination.
//
//        Note: The solution set must not contain duplicate combinations.
//
//
//
//        Example 1:
//
//        Input: candidates = [10,1,2,7,6,1,5], target = 8
//        Output:
//        [
//        [1,1,6],
//        [1,2,5],
//        [1,7],
//        [2,6]
//        ]
//        Example 2:
//
//        Input: candidates = [2,5,2,1,2], target = 5
//        Output:
//        [
//        [1,2,2],
//        [5]
//        ]
//
//
//        Constraints:
//
//        1 <= candidates.length <= 100
//        1 <= candidates[i] <= 50
//        1 <= target <= 30