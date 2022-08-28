package bfs_dfs.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

//    List<List<Integer>> res = new ArrayList<>();
//    int[] nums;
//    int len;
//
//    public List<List<Integer>> subsets(int[] nums) {
//        if (nums == null || nums.length == 0) return res;
//        this.nums = nums;
//        this.len = nums.length;
//        boolean[] isVisit = new boolean[len];
//        List<Integer> tmpRes = new ArrayList<>();
//        for (int i = 0; i <= len; i++) {
//            dfs(tmpRes, isVisit, 0, i);
//        }
//
//        return res;
//    }
//
//    public void dfs(List<Integer> tmpRes, boolean[] isVisit, int start, int size) {
//        if (tmpRes.size() == size) {
//            res.add(new ArrayList<>(tmpRes));
//            return;
//        }
//
//        for (int i = start; i < len; i++) {
//            if (!isVisit[i]) {
//                isVisit[i] = true;
//                tmpRes.add(nums[i]);
//                dfs(tmpRes, isVisit, i + 1, size);
//                isVisit[i] = false;
//                tmpRes.remove(tmpRes.size() - 1);
//            }
//        }
//    }

    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    int len;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
        dfs(new ArrayList<>(), 0);
        return res;
    }

    public void dfs(List<Integer> tmpRes, int start) {
        if (start > len) return;
        if (tmpRes.size() <= len) {
            res.add(new ArrayList<>(tmpRes));
        }

        for (int i = start; i < len; i++) {
            tmpRes.add(nums[i]);
            dfs(tmpRes, i + 1);
            tmpRes.remove(tmpRes.size() - 1);
        }
    }


//        List<List<Integer>> res = new ArrayList<>();
//        int[] nums;
//        int len;
        public List<List<Integer>> subsets1(int[] nums) {
            this.nums = nums;
            this.len = nums.length;
            dfs1(new ArrayList<>(), 0);
            return res;
        }

        public void dfs1(List<Integer> tmpRes, int start) {
            if (start > len) return;
            if (tmpRes.size() <= len) {
                res.add(new ArrayList<>(tmpRes));
            }

            for (int i = start; i < len; i++) {
                tmpRes.add(nums[i]);
                dfs1(tmpRes, i + 1);
                tmpRes.remove(tmpRes.size() - 1);
            }
        }

// backtrack
// start index
// dfs

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        Subsets s = new Subsets();
        System.out.println(s.subsets(nums));
    }
}
//78. Subsets
//        Given an integer array nums of unique elements, return all possible subsets (the power set).
//
//        The solution set must not contain duplicate subsets. Return the solution in any order.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2,3]
//        Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
//        All the numbers of nums are unique.
