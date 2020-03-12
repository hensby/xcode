package sort;

import java.util.Arrays;

public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; ++i)
            dists[i] = dist(points[i]);

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; ++i)
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];
        return ans;
    }

    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }


    public static void main(String[] args) {
        KClosest kClosest = new KClosest();
        int[][] points = new int[][] {
                {-5, 4},
                {-6, -5},
                {4, 6}};
//        int[][] points = new int[][] {
//                {1,3},
//                {-2,-2}};
        System.out.println(Arrays.deepToString(kClosest.kClosest(points, 2)));
    }
}

