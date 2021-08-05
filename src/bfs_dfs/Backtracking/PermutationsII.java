package bfs_dfs.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    int len;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        this.nums = nums;
        this.len = nums.length;
        Arrays.sort(nums);
        List<Integer> tmpRes = new ArrayList<>();
        boolean[] isVisit = new boolean[len];
        dfs(tmpRes, isVisit);
        return res;
    }

    public void dfs(List<Integer> tmpRes, boolean[] isVisit) {
        if (tmpRes.size() == len) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }
        System.out.println("tmpRes " + tmpRes);
        System.out.println(Arrays.toString(isVisit));
        System.out.println(" res " + res);
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !isVisit[i - 1]) continue;
            if (isVisit[i]) continue;
            isVisit[i] = true;
            tmpRes.add(nums[i]);
            dfs(tmpRes, isVisit);
            isVisit[i] = false;
            tmpRes.remove(tmpRes.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        PermutationsII p = new PermutationsII();
        System.out.println(p.permuteUnique(nums));
    }
}
//47. Permutations II
//        Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
//
//        Example 1:
//
//        Input: nums = [1,1,2]
//        Output:
//        [[1,1,2],
//        [1,2,1],
//        [2,1,1]]
//        Example 2:
//
//        Input: nums = [1,2,3]
//        Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//        Constraints:
//
//        1 <= nums.length <= 8
//        -10 <= nums[i] <= 10