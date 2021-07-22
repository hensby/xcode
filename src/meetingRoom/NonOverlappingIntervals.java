package meetingRoom;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        if(len <= 1) return 0;
        Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);
        System.out.println(Arrays.deepToString(intervals));
        int end = intervals[0][1], count = 1;
        for(int i = 1; i < len; i++) {
            if(intervals[i][0] < end) continue;
            end = intervals[i][1];
            count++;
        }
        return len - count;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1,2},{2,3},{3,4},{1,3},{1,7},{3,5},{6,7}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
//按照右边界排序，就要从左向右遍历，因为右边界越小越好，只要右边界越小，留给下一个区间的空间就越大，所以从左向右遍历，优先选右边界小的。
//435. Non-overlapping Intervals
//        Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
//
//        Example 1:
//
//        Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
//        Output: 1
//        Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
//        Example 2:
//
//        Input: intervals = [[1,2],[1,2],[1,2]]
//        Output: 2
//        Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
//        Example 3:
//
//        Input: intervals = [[1,2],[2,3]]
//        Output: 0
//        Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
//
//
//        Constraints:
//
//        1 <= intervals.length <= 2 * 104
//        intervals[i].length == 2
//        -2 * 104 <= starti < endi <= 2 * 104
