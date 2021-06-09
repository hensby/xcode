package Amazon_oa;

import java.util.*;

public class BuyItemsWithLimitedMoney {

    public static List<int[]> buyItemsWithLimitedMoney(List<int[]> input, int target) {
        if (input == null || input.size() == 0 ) return null;
        int res = 0;
        List<int[]> result = new ArrayList<>();
        if (input == null || input.size() == 0 || target == 0) return null;
        List<int[]> list12 = getCombination(input.get(0), input.get(1));
        List<int[]> list34 = getCombination(input.get(2), input.get(3));
        list34.sort((l1, l2) -> (l1[0] + l1[1]) - (l2[0] + l2[1]));
        for (int i = 0; i < list12.size(); i++) {
            int remain = target - list12.get(i)[0] - list12.get(i)[1];
            for (int[] j: binarySearch(list34, remain)){
                result.add(new int[]{list12.get(i)[0], list12.get(i)[1], j[0], j[1]});
                res++;
            }
        }
        System.out.println(res);
        return result;
    }

    public static List<int[]> binarySearch(List<int[]> input, int target) {
        List<int[]> res = new ArrayList<>();
        int left = 0, right = input.size() - 1;
        while (left < right) {
            int mid = (input.get(left)[0] + input.get(left)[1] + input.get(right)[0] + input.get(right)[1]) >>> 1;
            if (mid > target) {
                right--;
            } else {
                left++;
            }
        }
        res.addAll(input.subList(0, left));
        return res;
    }

    public static List<int[]> getCombination(int[] list1, int[] list2) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                res.add(new int[] {list1[i], list2[j]});
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<int[]> input = new ArrayList<int[]>() {{add(new int[]{1, 3, 4});add(new int[]{4});add(new int[]{2,4});add(new int[]{1,2});}};
        buyItemsWithLimitedMoney(input, 10).forEach((i) -> System.out.println(i[0] + " " + i[1] + " " + i[2] + " " + i[3]));
    }

}
//给了4个list，对应4类衣服的价格表，给定总金额，求每类衣服各选一件，使得总价不超过总金额的选法数。
//        eg:
//        input:
//        l1: [1, 3, 4],
//        l2: [4],
//        l3: [2, 4],
//        l4: [1, 2],
//        money: 10
//        output:
//        4
//        explenation:
//        可能的组和: [1,4,2,1],[1,4,2,2],[1,4,4,1],[3,4,2,1] 共四种
//        solution:
//        直接O(n^4)最后几个case会超时。
//        我的解法是先求出l1和l2的所有的价格组和c1，l3和l4的所有组和c2，对c2排序。
//        这样，对c1里的每个价格p1，都可以用二分在c2里找到一个max p2，使得p1 + p2 <= money。
//        这样的事件复杂度是O(n^2log(n))，所有case都过了。