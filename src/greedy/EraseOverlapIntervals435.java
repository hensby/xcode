package greedy;

import java.util.Arrays;
import java.util.Comparator;
//435
public class EraseOverlapIntervals435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        System.out.println(Arrays.deepToString(intervals));
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
            {1,2},{2,3},{3,4},{1,3}
        };
        EraseOverlapIntervals435 e = new EraseOverlapIntervals435();
        System.out.println(e.eraseOverlapIntervals(input));
    }
}
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