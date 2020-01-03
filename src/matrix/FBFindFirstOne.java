package matrix;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FBFindFirstOne {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.test();
        Solution2 solution2 = new Solution2();
        solution2.test();
        Solution3 solution3 = new Solution3();
        solution3.test();
        Solution4 solution4 = new Solution4();
        solution4.test();
    }

    public static class Solution1 extends Test {
        // each row do binary search, time: nlog(n)
        public int find(int[][] nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException();
            }
            int res = -1;
            for (int[] row :nums) {
                int index = findFirstOne(row, 0, row.length - 1);
                if (res == -1) res = index;
                else if (index != -1) {
                    res = Math.min(res, index);
                }
            }
            return res;
        }
    }

    public static class Solution2 extends Test {
        // time: m + n
        public int find(int[][] nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException();
            }
            int j = nums.length -1, res = -1;
            for (int[] row: nums) {
                while (j >= 0 && row[j] == 1 ) {
                    res = j;
                    j--;
                }
            }
            return res;
        }
    }

    public static class Solution3 extends Test {
        // optimization on Solution2 with binary search
        // time: less than m + n, less than mlog(n)
        public int find(int[][] nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException();
            }
            int j = nums.length - 1, res = -1;
            for (int[] row: nums) {
                int index = findFirstOne(row, 0, j);
                if (index != -1) {
                    j = index;
                    res = index;
                }
            }
            return res;
        }
    }

    public static class Solution4 extends Test {
        // use whole column to binary search
        // time: less than mlog(n)
        public int find(int[][] nums) {

            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException();
            }
            int m = nums.length, n = nums[0].length;
            Set<Integer> cur = IntStream.range(0, m).boxed().collect(Collectors.toSet()); //important
            int res = -1, left = 0, right = m - 1;
            while (left <= right) {
                int mid = right - ((right - left) >>> 1);
                Set<Integer> next = new HashSet<>();
                for (int num : cur) {
                    if (nums[num][mid] == 1) {
                        next.add(num);
                    }
                }
                if (next.isEmpty()){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                    res = mid;
                    cur = next;
                }
            }
            return res;
        }
    }


    public static int findFirstOne(int[] nums, int left, int right) {
        int res = -1;
        while (left <= right) {
            int mid = left + ((right - left)>>>1);
            if (nums[mid] == 1){
                res = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return res;
    }


    public static abstract class Test {
        public abstract int find(int[][] nums);

        public void test() {
            int[][] nums1 = new int[][] {
                    { 0, 0, 0, 0 },
                    { 0, 0, 0, 0 },
                    { 0, 0, 0, 0 },
                    { 0, 0, 0, 0 },};
            int[][] nums2 = new int[][] {
                    { 1, 1, 1, 1 },
                    { 1, 1, 1, 1 },
                    { 1, 1, 1, 1 },
                    { 1, 1, 1, 1 }, };
            int[][] nums3 = new int[][] {
                    { 0, 0, 1, 1 },
                    { 0, 1, 1, 1 },
                    { 0, 0, 0, 1 },
                    { 0, 0, 1, 1 }, };
            int[][] nums4 = new int[][] {
                    { 1, 1, 1, 1 },
                    { 0, 1, 1, 1 },
                    { 0, 0, 0, 0 },
                    { 0, 0, 0, 1 },};
            System.out.println("find1:" + find(nums1));
            System.out.println("find2:" + find(nums2));
            System.out.println("find3:" + find(nums3));
            System.out.println("find4:" + find(nums4));
            System.out.println();
        }
    }

}




