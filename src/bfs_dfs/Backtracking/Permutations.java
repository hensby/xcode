package bfs_dfs.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    List<List<Integer>> res = new ArrayList<>();

    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        this.nums = nums;
        List<Integer> resList = new ArrayList<>();
        boolean[] isVisit = new boolean[nums.length];
        dfs(resList, isVisit);

        return res;
    }

    public void dfs(List<Integer> resList, boolean[] isVisit) {
        if (resList.size() == nums.length) {
            res.add(new ArrayList<>(resList));
            return;
        }
        System.out.println(resList);
        System.out.println(Arrays.toString(isVisit));
        System.out.println(" res" + res);
        for (int i = 0; i < nums.length; i++) {
            if (!isVisit[i]) {
                resList.add(nums[i]);
                isVisit[i] = true;
                dfs(resList, isVisit);
                isVisit[i] = false;
                resList.remove(resList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permutations p = new Permutations();
        System.out.println(p.permute(nums));
    }
}
//46. Permutations
//        Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
//
//        Example 1:
//
//        Input: nums = [1,2,3]
//        Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//        Example 2:
//
//        Input: nums = [0,1]
//        Output: [[0,1],[1,0]]
//        Example 3:
//
//        Input: nums = [1]
//        Output: [[1]]
//
//
//        Constraints:
//
//        1 <= nums.length <= 6
//        -10 <= nums[i] <= 10
//        All the integers of nums are unique.