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
