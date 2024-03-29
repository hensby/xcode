package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
//        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(points, (p1, p2) -> p1[1] - p2[1]);

        System.out.println(Arrays.deepToString(points));
        int cnt = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }
            end = points[i][1];
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
                {10, 16},{2, 8},{1, 6},{7, 12}
        };
        int[][] input1 = new int[][] {
                {-2147483646,-2147483645},{2147483646,2147483647}
        };
        FindMinArrowShots f = new FindMinArrowShots();
        System.out.println(f.findMinArrowShots(input1));
    }
}
