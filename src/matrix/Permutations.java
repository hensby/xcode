package matrix;

import java.util.ArrayList;
import java.util.List;
// 46
public class Permutations {
    List<List<Integer>> res ;
    int len;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        this.len = nums.length;
        this.nums = nums;
        // for(int i = 0; i < len; i++) {
        boolean[] visited = new boolean[len];
        // visited[i] = true;
        List<Integer> tmpRes = new ArrayList<>();
        bfs(visited, tmpRes);
        // }
        System.out.println("1" + res);
        return res;
    }

    public void bfs(boolean[] visited, List<Integer> tmpRes) {
        if(tmpRes.size() == len) {
            res.add(new ArrayList<>(tmpRes));
            System.out.println("999" + res);
            return;
        }

        for(int i = 0; i < len; i++) {
            if(!visited[i]) {
                visited[i] = true;
                tmpRes.add(nums[i]);
                System.out.println(tmpRes);
                bfs(visited, tmpRes);
                visited[i] = false;
                tmpRes.remove(tmpRes.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations p = new Permutations();
        List<List<Integer>> lists = p.permute(nums);
        System.out.println(lists);
    }
}
