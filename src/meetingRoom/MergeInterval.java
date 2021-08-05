package meetingRoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1 ) return intervals;
        Arrays.sort(intervals, (l1, l2)->l1[0] - l2[0]);
         System.out.println(Arrays.deepToString(intervals));
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
//时间复杂度：O(n\log n)O(nlogn)，其中 nn 为区间的数量。除去排序的开销，我们只需要一次线性扫描，所以主要的时间开销是排序的 O(n\log n)O(nlogn)。
//空间复杂度：O(\log n)O(logn)，其中 nn 为区间的数量。这里计算的是存储答案之外，使用的额外空间。O(\log n)O(logn) 即为排序所需要的空间复杂度。
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