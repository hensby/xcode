package meetingRoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1 || intervals == null) return intervals;
        Arrays.sort(intervals, (l1, l2)->l1[0] - l2[0]);
        // System.out.println(Arrays.toString(intervals));
        List<int[]> res = new ArrayList<int[]>();
        int len = intervals.length;
        int i = 0;
        while(i < len) {
            int left = intervals[i][0], right = intervals[i][1];
            while (i < len - 1 && right >= intervals[i + 1][0]) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[0][2]);
    }

    public static void main(String[] args) {
        MergeInterval merge = new MergeInterval();
        int[][] input = new int[][] {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge.merge(input)));
    }
}
//        56. Merge Intervals
//        Given a collection of intervals, merge all overlapping intervals.
//
//        Example 1:
//
//        Input: [[1,3],[2,6],[8,10],[15,18]]
//        Output: [[1,6],[8,10],[15,18]]
//        Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//        Example 2:
//
//        Input: [[1,4],[4,5]]
//        Output: [[1,5]]
//        Explanation: Intervals [1,4] and [4,5] are considered overlapping.