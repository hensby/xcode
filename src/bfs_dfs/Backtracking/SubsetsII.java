package bfs_dfs.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    int len;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        this.nums = nums;
        this.len = nums.length;
        Arrays.sort(nums);
        List<Integer> tmpRes = new ArrayList<>();
        boolean[] isVisit = new boolean[len];
        for(int i = 0; i <= len; i++) {
            dfs(tmpRes, isVisit, i, 0);
        }
        return res;
    }

    public void dfs(List<Integer> tmpRes, boolean[] isVisit, int size, int start) {
        if (tmpRes.size() == size) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }

        for (int i = start; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !isVisit[i - 1]) continue;
            if (!isVisit[i]) {
                isVisit[i] = true;
                tmpRes.add(nums[i]);
                dfs(tmpRes, isVisit, size, i + 1);
                isVisit[i] = false;
                tmpRes.remove(tmpRes.size() - 1);
            }
        }
    }
//    int[] nums;
//    int len;
//    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        Arrays.sort(nums);
        this.nums = nums;
        this.len = nums.length;
        boolean[] isVisit = new boolean[len];
        dfs1(new ArrayList<>(), isVisit, 0);
        return res;
    }

    public void dfs1(List<Integer> tmpRes, boolean[] isVisit, int start) {
        if (start > len) return;
        res.add(new ArrayList<>(tmpRes));
        for (int i = start; i < len; i++) {
            if (i > start && nums[i] == nums[i - 1] && !isVisit[i - 1]) continue;
            if (!isVisit[i]) {
                isVisit[i] = true;
                tmpRes.add(nums[i]);
                dfs1(tmpRes, isVisit, i + 1);
                tmpRes.remove(tmpRes.size() - 1);
                isVisit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        SubsetsII subsetsII = new SubsetsII();
        System.out.println(subsetsII.subsetsWithDup1(nums));
    }
}
//90. Subsets II
//        Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
//
//        The solution set must not contain duplicate subsets. Return the solution in any order.
//
//        Example 1:
//
//        Input: nums = [1,2,2]
//        Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
//        Example 2:
//
//        Input: nums = [0]
//        Output: [[],[0]]
//
//
//        Constraints:
//
//        1 <= nums.length <= 10
//        -10 <= nums[i] <= 10