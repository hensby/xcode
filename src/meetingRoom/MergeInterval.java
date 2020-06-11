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
        return res.toArray(new int[0][12]);
    }

    public static void main(String[] args) {

    }
}
