package Amazon_oa;

import java.util.ArrayList;
import java.util.List;
//228
public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int len = nums.length;
        int left = 0;
        for (int right = 0; right < len; right++) {
            if (right == len - 1 || nums[right] + 1 != nums[right + 1]) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[left]);
                if (right != left) {
                    sb.append("->");
                    sb.append(nums[right]);
                }
                res.add(sb.toString());
                left = right + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[] {0,2,3,4,6,8,9};
        System.out.println(summaryRanges(input));
    }
}
//    228
//    You are given a sorted unique integer array nums.
//
//        Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
//
//        Each range [a,b] in the list should be output as:
//
//        "a->b" if a != b
//        "a" if a == b
//         
//
//        Example 1:
//
//        Input: nums = [0,1,2,4,5,7]
//        Output: ["0->2","4->5","7"]
//        Explanation: The ranges are:
//        [0,2] --> "0->2"
//        [4,5] --> "4->5"
//        [7,7] --> "7"
//        Example 2:
//
//        Input: nums = [0,2,3,4,6,8,9]
//        Output: ["0","2->4","6","8->9"]
//        Explanation: The ranges are:
//        [0,0] --> "0"
//        [2,4] --> "2->4"
//        [6,6] --> "6"
//        [8,9] --> "8->9"
//        Example 3:
//
//        Input: nums = []
//        Output: []
//        Example 4:
//
//        Input: nums = [-1]
//        Output: ["-1"]
//        Example 5:
//
//        Input: nums = [0]
//        Output: ["0"]
