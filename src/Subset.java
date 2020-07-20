import java.util.ArrayList;
import java.util.List;

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        /**
         * 循环枚举
         */
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (Integer n : nums) {
            int size = res.size();
            System.out.println(n);
            for (int i = 0; i < size; i++) {

                List<Integer> newSub = new ArrayList<Integer>(res.get(i));
                newSub.add(n);
                System.out.println(newSub);
                res.add(newSub);
            }
            System.out.println(res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Subset s = new Subset();
        int[] j = nums.clone();
        System.out.println(s.subsets(nums));
    }
}
