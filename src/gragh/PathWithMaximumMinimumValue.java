package gragh;

import java.util.PriorityQueue;

public class PathWithMaximumMinimumValue {
    int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int maximumMinimumPath(int[][] A) {
        int m = A.length, n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        pq.offer(new int[]{A[0][0], 0, 0});
        int res = A[0][0];
        visited[0][0] = true;

        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            // System.out.println(top[0] + " " + top[1] + " " + top[2]);
            res = Math.min(res, top[0]);
            if(top[1] == m - 1 && top[2] == n - 1) {
                break;
            }
            for(int[] dir : dirs) {
                int x = dir[0] + top[1];
                int y = dir[1] + top[2];
                // System.out.println("can" + " " + x + " " + y);
                if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                // System.out.println("add" + A[x][y] + " " + x + " " + y);
                pq.offer(new int[]{A[x][y], x, y});
                visited[x][y] = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {5,4,5},
                {1,2,6},
                {7,4,6}
        };
        PathWithMaximumMinimumValue p = new PathWithMaximumMinimumValue();
        System.out.println(p.maximumMinimumPath(input));
    }
}
//LeetCode 1102. Path With Maximum Minimum Value
//
//Given a matrix of integers A with R rows and C columns, find the maximum score of a path starting at [0,0] and ending at [R-1,C-1].
//
//The score of a path is the minimum value in that path.  For example, the value of the path 8 →  4 →  5 →  9 is 4.
//
//A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions (north, east, west, south).
