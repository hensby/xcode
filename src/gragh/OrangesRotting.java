package gragh;

import java.util.*;

public class OrangesRotting {
//    int[] dr = new int[]{-1, 0, 1, 0};   //row
//    int[] dc = new int[]{0, -1, 0, 1};   //colomn
//
//    public int orangesRotting(int[][] grid) {
//        int R = grid.length, C = grid[0].length;
//
//        // queue : all starting cells with rotten oranges
//        Queue<Integer> queue = new LinkedList<>();
//        Map<Integer, Integer> depth = new HashMap();
//        for (int r = 0; r < R; ++r) {
//            for (int c = 0; c < C; ++c) {
//                if (grid[r][c] == 2) {
//                    int code = r * C + c;
//                    queue.add(code);
//                    depth.put(code, 0);
//                }
//            }
//        }
//        int ans = 0;
//        while (!queue.isEmpty()) {
//            int code = queue.remove();
//            int r = code / C, c = code % C;
//            for (int k = 0; k < 4; ++k) {
//                int nr = r + dr[k];
//                int nc = c + dc[k];
//                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
//                    grid[nr][nc] = 2;
//                    int ncode = nr * C + nc;
//                    queue.add(ncode);
//                    depth.put(ncode, depth.get(code) + 1);
//                    ans = depth.get(ncode);
//                }
//            }
//        }
//
//        for (int[] row: grid)
//            for (int v: row)
//                if (v == 1)
//                    return -1;
//        return ans;
//
//    }
int width, height;
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        width = grid[0].length;
        height = grid.length;
        int res = 0, count = 0;
        Queue<Integer> orangeQueue = new LinkedList<>();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] == 2) {
                    orangeQueue.add(countOrange(row, col));
                } else if (grid[row][col] == 1) {
                    count++;
                }
            }
        }
        System.out.println(orangeQueue);
        while(count > 0 && !orangeQueue.isEmpty()) {
            res++;
            for (int i = 0; i < orangeQueue.size(); i++) {
                int orange = orangeQueue.poll();
                System.out.println(orangeQueue);
                int row = orange / width, col = orange % width;
                if(col + 1 < width && grid[row][col + 1] == 1) {
                    orangeQueue.add(countOrange(row, col + 1));
                    grid[row][col + 1] = 2;
                    System.out.println("yi");
                    count--;
                }
                System.out.println(orangeQueue);
                if(col - 1 >= 0 && grid[row][col - 1] == 1) {
                    orangeQueue.add(countOrange(row, col - 1));
                    grid[row][col - 1] = 2;
                    count--;
                    System.out.println("er");
                }
                System.out.println(orangeQueue);
                if(row + 1 < height && grid[row + 1][col] == 1) {
                    orangeQueue.add(countOrange(row + 1, col));
                    grid[row + 1][col] = 2;
                    count--;
                    System.out.println("san");
                }
                System.out.println(orangeQueue);
                if(row - 1 >= 0 && grid[row - 1][col] == 1) {
                    orangeQueue.add(countOrange(row - 1, col));
                    grid[row - 1][col] = 2;
                    count--;
                    System.out.println("si");
                }
                System.out.println(orangeQueue);
                System.out.println(" ");
            }
            System.out.println(orangeQueue);
        }
        if (count > 0) return -1;
        return res;
    }

    public int countOrange(int row, int col) {
        return row * width + col;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 2, 1, 1},
//                {1, 1, 0},
//                {0, 1, 1}
        };
        OrangesRotting orangesRotting = new OrangesRotting();
        System.out.println(orangesRotting.orangesRotting(input));
    }
}
