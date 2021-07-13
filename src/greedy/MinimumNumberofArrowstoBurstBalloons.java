package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberofArrowstoBurstBalloons {

    public static int findMinArrowShots(int[][] points) {
        int len = points.length;
        if (len == 0) {
            return 0;
        }
        Arrays.sort(points, (o1, o2) -> o1[1] - o2[1]);
        int end = points[0][1], count = 1;
        for (int i = 1; i < len; i++) {
            if (points[i][0] <= end) continue;
            count++;
            end = points[i][1];
        }
        return count;
    }

    public static int findMinArrowShots1(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int len = points.length;
        if (len == 1) return 1;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int end = points[0][1], arrows = 1;
        for (int i = 1; i < len; i++) {
            if (points[i][0] <= end) continue;
            end = points[i][1];
            arrows++;
        }
        return arrows;
    }

    public static void main(String[] args) {
        int[][] points = new int[][] {{1,2},{2,3},{3,4},{1,3},{1,7},{3,5},{6,7}};
        System.out.println(findMinArrowShots1(points));
    }
}
//452. Minimum Number of Arrows to Burst Balloons
//        There are some spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter, and hence the x-coordinates of start and end of the diameter suffice. The start is always smaller than the end.
//
//        An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps traveling up infinitely.
//
//        Given an array points where points[i] = [xstart, xend], return the minimum number of arrows that must be shot to burst all balloons.
//
//
//
//        Example 1:
//
//        Input: points = [[10,16],[2,8],[1,6],[7,12]]
//        Output: 2
//        Explanation: One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
//        Example 2:
//
//        Input: points = [[1,2],[3,4],[5,6],[7,8]]
//        Output: 4
//        Example 3:
//
//        Input: points = [[1,2],[2,3],[3,4],[4,5]]
//        Output: 2
//
//
//        Constraints:
//
//        1 <= points.length <= 104
//        points[i].length == 2
//        -231 <= xstart < xend <= 231 - 1