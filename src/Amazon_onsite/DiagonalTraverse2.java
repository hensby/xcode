package Amazon_onsite;

import java.util.*;

public class DiagonalTraverse2 {

    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        int length = 0;
        //根据对角线i+j唯一且相同，LinkedHashMap保持插入排序。效率是最优的
        Map<Integer,List<Integer>> map =new LinkedHashMap<>();
        for(int i = 0;i < nums.size();i++) {
            length += nums.get(i).size();
            for(int j = 0;j < nums.get(i).size();j++) {
                List<Integer> orDefault = map.getOrDefault(i + j, new ArrayList<>());
                orDefault.add(nums.get(i).get(j));
                map.putIfAbsent(i+j,orDefault);
            }
        }
        int[] result = new int[length];
        int index = 0;
        //遍历map，得到结果。
        for(int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for(int j = list.size() - 1;j >= 0;j--) {
                result[index] = list.get(j);
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][] {{1,2,3,4,5},{6,7},{8},{9,10,11},{12,13,14,15,16}};
    }
}
// O(m * n)
//
//1424. Diagonal Traverse II
//        Given a list of lists of integers, nums, return all elements of nums in diagonal order as shown in the below images.
//
//        Example 1:
//
//        Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
//        Output: [1,4,2,7,5,3,8,6,9]
//        Example 2:
//
//        Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
//        Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
//        Example 3:
//
//        Input: nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
//        Output: [1,4,2,5,3,8,6,9,7,10,11]
//        Example 4:
//
//        Input: nums = [[1,2,3,4,5,6]]
//        Output: [1,2,3,4,5,6]
//
//        Constraints:
//
//        1 <= nums.length <= 10^5
//        1 <= nums[i].length <= 10^5
//        1 <= nums[i][j] <= 10^9
//        There at most 10^5 elements in nums.
